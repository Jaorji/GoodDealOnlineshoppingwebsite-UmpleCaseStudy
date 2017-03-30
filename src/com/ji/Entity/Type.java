/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.upload.FormFile;
import java.util.*;

// line 6 "../../../Type.ump"
public class Type extends ActionForm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Type Attributes
  private int id;
  private String name;

  //Type Associations
  private List<Brand> brands;
  private List<Goods> goods;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Type()
  {
    super();
    id = 0;
    name = "";
    brands = new ArrayList<Brand>();
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
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

  public Brand getBrand(int index)
  {
    Brand aBrand = brands.get(index);
    return aBrand;
  }

  public List<Brand> getBrands()
  {
    List<Brand> newBrands = Collections.unmodifiableList(brands);
    return newBrands;
  }

  public int numberOfBrands()
  {
    int number = brands.size();
    return number;
  }

  public boolean hasBrands()
  {
    boolean has = brands.size() > 0;
    return has;
  }

  public int indexOfBrand(Brand aBrand)
  {
    int index = brands.indexOf(aBrand);
    return index;
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

  public static int minimumNumberOfBrands()
  {
    return 0;
  }

  public boolean addBrand(Brand aBrand)
  {
    boolean wasAdded = false;
    if (brands.contains(aBrand)) { return false; }
    Type existingType = aBrand.getType();
    if (existingType == null)
    {
      aBrand.setType(this);
    }
    else if (!this.equals(existingType))
    {
      existingType.removeBrand(aBrand);
      addBrand(aBrand);
    }
    else
    {
      brands.add(aBrand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBrand(Brand aBrand)
  {
    boolean wasRemoved = false;
    if (brands.contains(aBrand))
    {
      brands.remove(aBrand);
      aBrand.setType(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBrandAt(Brand aBrand, int index)
  {  
    boolean wasAdded = false;
    if(addBrand(aBrand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBrands()) { index = numberOfBrands() - 1; }
      brands.remove(aBrand);
      brands.add(index, aBrand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBrandAt(Brand aBrand, int index)
  {
    boolean wasAdded = false;
    if(brands.contains(aBrand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBrands()) { index = numberOfBrands() - 1; }
      brands.remove(aBrand);
      brands.add(index, aBrand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBrandAt(aBrand, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfGoods()
  {
    return 0;
  }

  public boolean addGood(Goods aGood)
  {
    boolean wasAdded = false;
    if (goods.contains(aGood)) { return false; }
    Type existingType = aGood.getType();
    if (existingType == null)
    {
      aGood.setType(this);
    }
    else if (!this.equals(existingType))
    {
      existingType.removeGood(aGood);
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
      aGood.setType(null);
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

  public void delete()
  {
    while( !brands.isEmpty() )
    {
      brands.get(0).setType(null);
    }
    while( !goods.isEmpty() )
    {
      goods.get(0).setType(null);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}