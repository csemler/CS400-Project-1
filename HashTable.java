// --== CS400 File Header Information ==--
// Name: Christopher Semler
// Email: csemler@wisc.edu
// Team: CG
// Role: DataWrangler2
// TA: Yeping
// Lecturer: Florian
// Notes to Grader: nope

import java.util.NoSuchElementException;

public class HashTable<KeyType, ValueType> implements MapADT<KeyType, ValueType>
{
  private HashNode<KeyType, ValueType>[] map;
  private int items;
  private double loadCapacity = 0.8;
  
  //constructor with one parameter
  //sets array capacity to int capacity parameter
  public HashTable(int capacity)
  {
    map = new HashNode[capacity];
    items = 0;
  }
  
  //default constructor to set capacity to ten
  public HashTable() // with default capacity = 10
  {
    map = new HashNode[10];
    items = 0;
  } 

  //inserts data in hash table according to key's hash code
  //returns true if successful
  //returns false if key is already in table
  public boolean put(KeyType key, ValueType value) 
  {
    //containsKey() returns true if key is already stored
    if (containsKey(key))
      return false;
    
    //store value in hash table according to hashCode() modulus current table capacity
    int index = Math.abs(key.hashCode()) % size();
    HashNode<KeyType, ValueType> temp = map[index];
    
    //if slot is currently unused, new node is created
    if (temp == null)
    {
      map[index] = new HashNode<KeyType, ValueType>(key, value, null, null);
    }
    //if slot is in use, chaining occurs
    //updates temp to be last node in chain
    else
    {
      while (temp.getNext() != null)
          temp = temp.getNext();
      
      //creates new node with data at end of chain at given index
      HashNode<KeyType, ValueType> newNode = new HashNode<KeyType, ValueType>(key, value, null, temp);
      temp.setNext(newNode);
    }
    items++;
    
    //checks to see if array needs to be resized
    //if array needs to be resized, it is automatically by calling method reSize() in the checkCapacity() method
    checkCapacity();
    
    return true;
  }
  
  //returns the ValueType data associated with a key
  public ValueType get(KeyType key) throws NoSuchElementException 
  {
    //containsKey() returns false if key is not stored
    if (containsKey(key) == false)
      throw new NoSuchElementException();
    
    //only iterates through linked list at given array index
    int index = Math.abs(key.hashCode()) % size();
    HashNode<KeyType, ValueType> temp = map[index];
    
    while (!(key.equals(temp.getKey())))
    {
      temp = temp.getNext();
    }
    
    return temp.getValue();
  }

  //returns the length of hash table
  public int size() 
  {
    return map.length;
  }

  //iterates the linked list at the key's hash code index for the given key
  //returns boolean true if key is found
  public boolean containsKey(KeyType key) 
  {
    int index = Math.abs(key.hashCode()) % size();
    HashNode<KeyType, ValueType> temp = map[index];
    
    //if no node at given index
    if (temp == null)
      return false;
    
    //scans each node in chain at the given index
    while (temp != null)
    {
      if (key.equals(temp.getKey()))
        return true;
      
      temp = temp.getNext();
    }
    
    //key is not found anywhere in map
    return false;
  }

  //removes node storing the key parameter
  //returns the ValueType data stored from that node being deleted
  public ValueType remove(KeyType key) 
  {
    if (containsKey(key) == false)
      return null;
    
    int index = Math.abs(key.hashCode()) % size();
    HashNode<KeyType, ValueType> temp = map[index];
    ValueType output = null; //if no key is found, null is returned
    
    //key being removed is the first node in chain
    if (key.equals(temp.getKey()))
    {
      output = temp.getValue();
      
      //if more nodes in linked list after one being removed
      if (temp.getNext() != null)
      {
        map[index] = temp.getNext();
        //updates temp to the second node (first not being removed, aka the new head)
        temp = temp.getNext();
        temp.setPrevious(null);
      }
      
      //if node being removed is the only node in linked list
      if (temp.getNext() == null)
      {
        map[index] = null;
      }
    }
    
    //scans linked list for the given key
    //updates the next data for the node before the one being removed
    while (!(temp.getNext() == null))
    {
      if (key.equals(temp.getNext().getKey()))
      {
        output = temp.getNext().getValue();
        //sets the node before the key to be removed to skip the node being removed
        temp.setNext(temp.getNext().getNext());
        
        //updates the previous node data of the node following the one being removed
        temp = temp.getNext();
        //if node that was removed was not end of linked list
        if (temp != null)
          temp.setPrevious(temp.getPrevious().getPrevious());
        
        //exits while loop if found
        break;
      }
      
      //iterates temp through linked list if not found
      temp = temp.getNext();
    }
    
    items--;
    
    return output;
  }
  
  //removes all key-value pairs from collection
  public void clear() 
  {
    HashNode<KeyType, ValueType>[] tempArray = new HashNode[size()];
    map = tempArray;
    
    items = 0;
  }
  
  //returns true if load factor is less than the threshold
  //returns false if HashMap needs to be resized
  private boolean checkCapacity()
  {
    //converts number of items and tabe size to double not int
    if (loadCapacity <= (items * 1.0) / (1.0*size()))
    {
      reSize();  
      return false;
    }
    
    return true;
  }
  
  //doubles the size of array
  //then iterators through the current array to rehash all elements into the new array
  private void reSize()
  {
    //creates new array with size double
    HashNode<KeyType, ValueType>[] tempArray = new HashNode[size()*2];
    //used like an iterator for map
    HashNode tempMapNode = null;
    //used like an iterator for new tempArray
    HashNode tempArrayNode = null;
    //stores map's current capacity size
    KeyType tempKey = null;
    ValueType tempVal = null;
    int tempIndex = 0;
    
    for (int i = 0; i < map.length; i++)
    {
      tempMapNode = map[i];
      
      while (tempMapNode != null)
      {
        //stores the key and value to be rehashed
        tempKey = (KeyType) tempMapNode.getKey();
        tempVal = (ValueType) tempMapNode.getValue();
        
        //calculates new index of key's hash code
        tempIndex = Math.abs(tempKey.hashCode()) % tempArray.length;
        
        //if new index is empty, creates new HashNode to place there 
        if (tempArray[tempIndex] == null)
          tempArray[tempIndex] = new HashNode<KeyType, ValueType>(tempKey, tempVal, null, null);
        //if index is not empty, iterator to end of linked list to place new HashNode
        else
        {
          tempArrayNode = tempArray[tempIndex];
          while (tempArrayNode.getNext() != null)
          {
            tempArrayNode = tempArrayNode.getNext();
          }
          HashNode<KeyType, ValueType> newNode = new HashNode<KeyType, ValueType>(tempKey, tempVal, null, tempArrayNode);
          tempArrayNode.setNext(newNode);
        }
        
        tempMapNode = tempMapNode.getNext();
      }
    }
    
    //updates the instance field with the new array with doubled size and already rehashed
    map = tempArray;
  }
}

