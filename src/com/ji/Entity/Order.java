/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.sql.Date;
import java.util.*;

// line 6 "../../../Order.ump"
public class Order extends ActionForm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int id;
  private String orderNumber;
  private String paymentMethod;
  private String shipmentMethod;
  private String message;
  private Date datePlaced;
  private Date datePayment;
  private Date shipped;
  private Date delivered;
  private Address address;

  //Order State Machines
  public enum Status { NotPaid, paid, shipped, delivered }
  private Status status;

  //Order Associations
  private List<OrderDetail> orderDetails;
  private Member member;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order()
  {
    super();
    id = 0;
    orderNumber = "";
    paymentMethod = "";
    shipmentMethod = "";
    message = "";
    datePlaced = null;
    datePayment = null;
    shipped = null;
    delivered = null;
    address = null;
    orderDetails = new ArrayList<OrderDetail>();
    setStatus(Status.NotPaid);
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

  public boolean setPaymentMethod(String aPaymentMethod)
  {
    boolean wasSet = false;
    paymentMethod = aPaymentMethod;
    wasSet = true;
    return wasSet;
  }

  public boolean setShipmentMethod(String aShipmentMethod)
  {
    boolean wasSet = false;
    shipmentMethod = aShipmentMethod;
    wasSet = true;
    return wasSet;
  }

  public boolean setMessage(String aMessage)
  {
    boolean wasSet = false;
    message = aMessage;
    wasSet = true;
    return wasSet;
  }

  public boolean setDatePlaced(Date aDatePlaced)
  {
    boolean wasSet = false;
    datePlaced = aDatePlaced;
    wasSet = true;
    return wasSet;
  }

  public boolean setDatePayment(Date aDatePayment)
  {
    boolean wasSet = false;
    datePayment = aDatePayment;
    wasSet = true;
    return wasSet;
  }

  public boolean setShipped(Date aShipped)
  {
    boolean wasSet = false;
    shipped = aShipped;
    wasSet = true;
    return wasSet;
  }

  public boolean setDelivered(Date aDelivered)
  {
    boolean wasSet = false;
    delivered = aDelivered;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(Address aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
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

  /**
   * 1 -- 1 PaymentMethod
   */
  public String getPaymentMethod()
  {
    return paymentMethod;
  }

  /**
   * 1--1 ShipmentMethod
   */
  public String getShipmentMethod()
  {
    return shipmentMethod;
  }

  public String getMessage()
  {
    return message;
  }

  public Date getDatePlaced()
  {
    return datePlaced;
  }

  public Date getDatePayment()
  {
    return datePayment;
  }

  public Date getShipped()
  {
    return shipped;
  }

  public Date getDelivered()
  {
    return delivered;
  }

  public Address getAddress()
  {
    return address;
  }

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean makePayment()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case NotPaid:
        setStatus(Status.paid);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ship()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case paid:
        setStatus(Status.shipped);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean confirmedDelivery()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case shipped:
        setStatus(Status.delivered);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;
  }

  public OrderDetail getOrderDetail(int index)
  {
    OrderDetail aOrderDetail = orderDetails.get(index);
    return aOrderDetail;
  }

  public List<OrderDetail> getOrderDetails()
  {
    List<OrderDetail> newOrderDetails = Collections.unmodifiableList(orderDetails);
    return newOrderDetails;
  }

  public int numberOfOrderDetails()
  {
    int number = orderDetails.size();
    return number;
  }

  public boolean hasOrderDetails()
  {
    boolean has = orderDetails.size() > 0;
    return has;
  }

  public int indexOfOrderDetail(OrderDetail aOrderDetail)
  {
    int index = orderDetails.indexOf(aOrderDetail);
    return index;
  }

  public Member getMember()
  {
    return member;
  }

  public boolean hasMember()
  {
    boolean has = member != null;
    return has;
  }

  public static int minimumNumberOfOrderDetails()
  {
    return 0;
  }

  public boolean addOrderDetail(OrderDetail aOrderDetail)
  {
    boolean wasAdded = false;
    if (orderDetails.contains(aOrderDetail)) { return false; }
    Order existingOrder = aOrderDetail.getOrder();
    if (existingOrder == null)
    {
      aOrderDetail.setOrder(this);
    }
    else if (!this.equals(existingOrder))
    {
      existingOrder.removeOrderDetail(aOrderDetail);
      addOrderDetail(aOrderDetail);
    }
    else
    {
      orderDetails.add(aOrderDetail);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrderDetail(OrderDetail aOrderDetail)
  {
    boolean wasRemoved = false;
    if (orderDetails.contains(aOrderDetail))
    {
      orderDetails.remove(aOrderDetail);
      aOrderDetail.setOrder(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderDetailAt(OrderDetail aOrderDetail, int index)
  {  
    boolean wasAdded = false;
    if(addOrderDetail(aOrderDetail))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderDetails()) { index = numberOfOrderDetails() - 1; }
      orderDetails.remove(aOrderDetail);
      orderDetails.add(index, aOrderDetail);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderDetailAt(OrderDetail aOrderDetail, int index)
  {
    boolean wasAdded = false;
    if(orderDetails.contains(aOrderDetail))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderDetails()) { index = numberOfOrderDetails() - 1; }
      orderDetails.remove(aOrderDetail);
      orderDetails.add(index, aOrderDetail);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderDetailAt(aOrderDetail, index);
    }
    return wasAdded;
  }

  public boolean setMember(Member aMember)
  {
    boolean wasSet = false;
    Member existingMember = member;
    member = aMember;
    if (existingMember != null && !existingMember.equals(aMember))
    {
      existingMember.removeOrder(this);
    }
    if (aMember != null)
    {
      aMember.addOrder(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !orderDetails.isEmpty() )
    {
      orderDetails.get(0).setOrder(null);
    }
    if (member != null)
    {
      Member placeholderMember = member;
      this.member = null;
      placeholderMember.removeOrder(this);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "orderNumber" + ":" + getOrderNumber()+ "," +
            "paymentMethod" + ":" + getPaymentMethod()+ "," +
            "shipmentMethod" + ":" + getShipmentMethod()+ "," +
            "message" + ":" + getMessage()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "datePlaced" + "=" + (getDatePlaced() != null ? !getDatePlaced().equals(this)  ? getDatePlaced().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "datePayment" + "=" + (getDatePayment() != null ? !getDatePayment().equals(this)  ? getDatePayment().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "shipped" + "=" + (getShipped() != null ? !getShipped().equals(this)  ? getShipped().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "delivered" + "=" + (getDelivered() != null ? !getDelivered().equals(this)  ? getDelivered().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "address" + "=" + (getAddress() != null ? !getAddress().equals(this)  ? getAddress().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "member = "+(getMember()!=null?Integer.toHexString(System.identityHashCode(getMember())):"null")
     + outputString;
  }
}