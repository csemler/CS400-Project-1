// --== CS400 File Header Information ==--
// Name: Christopher Semler
// Email: csemler@wisc.edu
// Team: CG
// TA: Yeping
// Lecturer: Florian Heimerl
// Notes to Grader: none

public class HashNode<KeyType, ValueType> 
{
  private KeyType k;
  private ValueType v;
  private HashNode<KeyType, ValueType> n;
  private HashNode<KeyType, ValueType> p;
  
  //default constructor
  public HashNode()
  {
    k = null;
    v = null;
    n = null;
    p = null;
  }
  
  //constructor with parameters
  public HashNode(KeyType key, ValueType value, HashNode<KeyType, ValueType> next, HashNode<KeyType, ValueType> previous)
  {
    k = key;
    v = value;
    n = next;
    p = previous;
  }
  
  //getter method for KeyType
  public KeyType getKey()
  {
    return k;
  }
  
  //getter method for ValueType
  public ValueType getValue()
  {
    return v;
  }
  
  //getter method for next node
  public HashNode<KeyType, ValueType> getNext()
  {
    return n;
  }
  
  //getter method for previous node
  public HashNode<KeyType, ValueType> getPrevious()
  {
    return p;
  }

  //setter method for KeyType
  public void setKey(KeyType key)
  {
    k = key;
  }
  
  //setter method for ValueType
  public void setValue(ValueType value)
  {
    v = value;
  }
  
  //setter method for next node
  public void setNext(HashNode<KeyType, ValueType> next)
  {
    n = next;
  }
  
  //setter method for previous node
  public void setPrevious(HashNode<KeyType, ValueType> previous)
  {
    p = previous;
  }
}


