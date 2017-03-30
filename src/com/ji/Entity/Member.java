/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;
import org.apache.struts.action.ActionForm;
import java.util.*;

// line 8 "../../../Member.ump"
public class Member extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Member Attributes
  private String userName;
  private String profession;
  private String question;
  private String answer;

  //Member Associations
  private List<Order> orders;
  private List<Address> addresses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Member()
  {
    super();
    userName = "";
    profession = "";
    question = "";
    answer = "";
    orders = new ArrayList<Order>();
    addresses = new ArrayList<Address>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserName(String aUserName)
  {
    boolean wasSet = false;
    userName = aUserName;
    wasSet = true;
    return wasSet;
  }

  public boolean setProfession(String aProfession)
  {
    boolean wasSet = false;
    profession = aProfession;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuestion(String aQuestion)
  {
    boolean wasSet = false;
    question = aQuestion;
    wasSet = true;
    return wasSet;
  }

  public boolean setAnswer(String aAnswer)
  {
    boolean wasSet = false;
    answer = aAnswer;
    wasSet = true;
    return wasSet;
  }

  public String getUserName()
  {
    return userName;
  }

  public String getProfession()
  {
    return profession;
  }

  public String getQuestion()
  {
    return question;
  }

  public String getAnswer()
  {
    return answer;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public Address getAddress(int index)
  {
    Address aAddress = addresses.get(index);
    return aAddress;
  }

  public List<Address> getAddresses()
  {
    List<Address> newAddresses = Collections.unmodifiableList(addresses);
    return newAddresses;
  }

  public int numberOfAddresses()
  {
    int number = addresses.size();
    return number;
  }

  public boolean hasAddresses()
  {
    boolean has = addresses.size() > 0;
    return has;
  }

  public int indexOfAddress(Address aAddress)
  {
    int index = addresses.indexOf(aAddress);
    return index;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Member existingMember = aOrder.getMember();
    if (existingMember == null)
    {
      aOrder.setMember(this);
    }
    else if (!this.equals(existingMember))
    {
      existingMember.removeOrder(aOrder);
      addOrder(aOrder);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    if (orders.contains(aOrder))
    {
      orders.remove(aOrder);
      aOrder.setMember(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAddresses()
  {
    return 0;
  }

  public boolean addAddress(Address aAddress)
  {
    boolean wasAdded = false;
    if (addresses.contains(aAddress)) { return false; }
    Member existingMember = aAddress.getMember();
    if (existingMember == null)
    {
      aAddress.setMember(this);
    }
    else if (!this.equals(existingMember))
    {
      existingMember.removeAddress(aAddress);
      addAddress(aAddress);
    }
    else
    {
      addresses.add(aAddress);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAddress(Address aAddress)
  {
    boolean wasRemoved = false;
    if (addresses.contains(aAddress))
    {
      addresses.remove(aAddress);
      aAddress.setMember(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAddressAt(Address aAddress, int index)
  {  
    boolean wasAdded = false;
    if(addAddress(aAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAddresses()) { index = numberOfAddresses() - 1; }
      addresses.remove(aAddress);
      addresses.add(index, aAddress);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAddressAt(Address aAddress, int index)
  {
    boolean wasAdded = false;
    if(addresses.contains(aAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAddresses()) { index = numberOfAddresses() - 1; }
      addresses.remove(aAddress);
      addresses.add(index, aAddress);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAddressAt(aAddress, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !orders.isEmpty() )
    {
      orders.get(0).setMember(null);
    }
    while( !addresses.isEmpty() )
    {
      addresses.get(0).setMember(null);
    }
    super.delete();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "userName" + ":" + getUserName()+ "," +
            "profession" + ":" + getProfession()+ "," +
            "question" + ":" + getQuestion()+ "," +
            "answer" + ":" + getAnswer()+ "]"
     + outputString;
  }
}