/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;

// line 6 "../../../OrderDetail.ump"
public class OrderDetail extends ActionForm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderDetail Attributes
  private int id;
  private String orderNumber;
  private double price;
  private int quantity;

  //OrderDetail Associations
  private List<Goods> goods;
  private Order order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderDetail()
  {
    super();
    id = 0;
    orderNumber = "";
    price = 0.0;
    quantity = 0;
    goods = new ArrayList<Goods>();
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

  public boolean setOrderNumber(String aOrderNumber)
  {
    boolean wasSet = false;
    orderNumber = aOrderNumber;
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

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getOrderNumber()
  {
    return orderNumber;
  }

  public double getPrice()
  {
    return price;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public Goods getGood(int index)
  {
    Goods aGood = goods.get(index);
    return aGood;
  }

  public List<Goods> getGoods()
  {
    List<Goods> newGoods = Collections.unmodifiableList(goods);
    return newGoods;
  }

  public int numberOfGoods()
  {
    int number = goods.size();
    return number;
  }

  public boolean hasGoods()
  {
    boolean has = goods.size() > 0;
    return has;
  }

  public int indexOfGood(Goods aGood)
  {
    int index = goods.indexOf(aGood);
    return index;
  }

  public Order getOrder()
  {
    return order;
  }

  public boolean hasOrder()
  {
    boolean has = order != null;
    return has;
  }

  public static int minimumNumberOfGoods()
  {
    return 0;
  }

  public boolean addGood(Goods aGood)
  {
    boolean wasAdded = false;
    if (goods.contains(aGood)) { return false; }
    OrderDetail existingOrderDetail = aGood.getOrderDetail();
    if (existingOrderDetail == null)
    {
      aGood.setOrderDetail(this);
    }
    else if (!this.equals(existingOrderDetail))
    {
      existingOrderDetail.removeGood(aGood);
      addGood(aGood);
    }
    else
    {
      goods.add(aGood);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGood(Goods aGood)
  {
    boolean wasRemoved = false;
    if (goods.contains(aGood))
    {
      goods.remove(aGood);
      aGood.setOrderDetail(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addGoodAt(Goods aGood, int index)
  {  
    boolean wasAdded = false;
    if(addGood(aGood))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGoods()) { index = numberOfGoods() - 1; }
      goods.remove(aGood);
      goods.add(index, aGood);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGoodAt(Goods aGood, int index)
  {
    boolean wasAdded = false;
    if(goods.contains(aGood))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGoods()) { index = numberOfGoods() - 1; }
      goods.remove(aGood);
      goods.add(index, aGood);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGoodAt(aGood, index);
    }
    return wasAdded;
  }

  public boolean setOrder(Order aOrder)
  {
    boolean wasSet = false;
    Order existingOrder = order;
    order = aOrder;
    if (existingOrder != null && !existingOrder.equals(aOrder))
    {
      existingOrder.removeOrderDetail(this);
    }
    if (aOrder != null)
    {
      aOrder.addOrderDetail(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !goods.isEmpty() )
    {
      goods.get(0).setOrderDetail(null);
    }
    if (order != null)
    {
      Order placeholderOrder = order;
      this.order = null;
      placeholderOrder.removeOrderDetail(this);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "orderNumber" + ":" + getOrderNumber()+ "," +
            "price" + ":" + getPrice()+ "," +
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null")
     + outputString;
  }
}