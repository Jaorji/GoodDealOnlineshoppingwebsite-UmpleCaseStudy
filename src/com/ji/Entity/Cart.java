/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;

// line 3 "../../../Cart.ump"
public class Cart
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cart Attributes
  private int id;
  private double price;
  private int number;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cart()
  {
    id = 0;
    price = 0.0;
    number = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public double getPrice()
  {
    return price;
  }

  public int getNumber()
  {
    return number;
  }

  public void delete()
  {}


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "price" + ":" + getPrice()+ "," +
            "number" + ":" + getNumber()+ "]"
     + outputString;
  }
}