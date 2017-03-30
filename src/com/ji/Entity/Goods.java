/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import javax.servlet.http.HttpServletRequest;

// line 4 "../../../Goods.ump"
public class Goods extends ActionForm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Goods Attributes
  private int id;
  private String name;
  private String description;
  private double price;
  private int numberInInventory;
  private String picture;
  private int mark;
  private double salePrice;
  private String manufacturer;
  private FormFile formFile;

  //Goods State Machines
  public enum Status { NotSale, sale }
  private Status status;

  //Goods Associations
  private OrderDetail orderDetail;
  private Brand brand;
  private Type type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Goods()
  {
    super();
    id = 0;
    name = "";
    description = "";
    price = 0.0;
    numberInInventory = 0;
    picture = "";
    mark = 0;
    salePrice = 0.0;
    manufacturer = "";
    formFile = null;
    setStatus(Status.NotSale);
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
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

  public boolean setNumberInInventory(int aNumberInInventory)
  {
    boolean wasSet = false;
    numberInInventory = aNumberInInventory;
    wasSet = true;
    return wasSet;
  }

  public boolean setPicture(String aPicture)
  {
    boolean wasSet = false;
    picture = aPicture;
    wasSet = true;
    return wasSet;
  }

  public boolean setMark(int aMark)
  {
    boolean wasSet = false;
    mark = aMark;
    wasSet = true;
    return wasSet;
  }

  public boolean setSalePrice(double aSalePrice)
  {
    boolean wasSet = false;
    salePrice = aSalePrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setManufacturer(String aManufacturer)
  {
    boolean wasSet = false;
    manufacturer = aManufacturer;
    wasSet = true;
    return wasSet;
  }

  public boolean setFormFile(FormFile aFormFile)
  {
    boolean wasSet = false;
    formFile = aFormFile;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public double getPrice()
  {
    return price;
  }

  public int getNumberInInventory()
  {
    return numberInInventory;
  }

  public String getPicture()
  {
    return picture;
  }

  public int getMark()
  {
    return mark;
  }

  public double getSalePrice()
  {
    return salePrice;
  }

  public String getManufacturer()
  {
    return manufacturer;
  }

  public FormFile getFormFile()
  {
    return formFile;
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

  public boolean changePrice()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case NotSale:
        setStatus(Status.sale);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean backToOriginalPrice()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case sale:
        setStatus(Status.NotSale);
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

  public OrderDetail getOrderDetail()
  {
    return orderDetail;
  }

  public boolean hasOrderDetail()
  {
    boolean has = orderDetail != null;
    return has;
  }

  public Brand getBrand()
  {
    return brand;
  }

  public boolean hasBrand()
  {
    boolean has = brand != null;
    return has;
  }

  public Type getType()
  {
    return type;
  }

  public boolean hasType()
  {
    boolean has = type != null;
    return has;
  }

  public boolean setOrderDetail(OrderDetail aOrderDetail)
  {
    boolean wasSet = false;
    OrderDetail existingOrderDetail = orderDetail;
    orderDetail = aOrderDetail;
    if (existingOrderDetail != null && !existingOrderDetail.equals(aOrderDetail))
    {
      existingOrderDetail.removeGood(this);
    }
    if (aOrderDetail != null)
    {
      aOrderDetail.addGood(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setBrand(Brand aBrand)
  {
    boolean wasSet = false;
    Brand existingBrand = brand;
    brand = aBrand;
    if (existingBrand != null && !existingBrand.equals(aBrand))
    {
      existingBrand.removeGood(this);
    }
    if (aBrand != null)
    {
      aBrand.addGood(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setType(Type aType)
  {
    boolean wasSet = false;
    Type existingType = type;
    type = aType;
    if (existingType != null && !existingType.equals(aType))
    {
      existingType.removeGood(this);
    }
    if (aType != null)
    {
      aType.addGood(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (orderDetail != null)
    {
      OrderDetail placeholderOrderDetail = orderDetail;
      this.orderDetail = null;
      placeholderOrderDetail.removeGood(this);
    }
    if (brand != null)
    {
      Brand placeholderBrand = brand;
      this.brand = null;
      placeholderBrand.removeGood(this);
    }
    if (type != null)
    {
      Type placeholderType = type;
      this.type = null;
      placeholderType.removeGood(this);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "," +
            "description" + ":" + getDescription()+ "," +
            "price" + ":" + getPrice()+ "," +
            "numberInInventory" + ":" + getNumberInInventory()+ "," +
            "picture" + ":" + getPicture()+ "," +
            "mark" + ":" + getMark()+ "," +
            "salePrice" + ":" + getSalePrice()+ "," +
            "manufacturer" + ":" + getManufacturer()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "formFile" + "=" + (getFormFile() != null ? !getFormFile().equals(this)  ? getFormFile().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderDetail = "+(getOrderDetail()!=null?Integer.toHexString(System.identityHashCode(getOrderDetail())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "brand = "+(getBrand()!=null?Integer.toHexString(System.identityHashCode(getBrand())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "type = "+(getType()!=null?Integer.toHexString(System.identityHashCode(getType())):"null")
     + outputString;
  }
}