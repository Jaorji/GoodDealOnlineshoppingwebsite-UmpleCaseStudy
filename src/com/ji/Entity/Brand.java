/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Entity;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.upload.FormFile;
import java.util.*;

// line 6 "../../../Brand.ump"
public class Brand extends ActionForm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Brand Attributes
  private int id;
  private String name;

  //Brand Associations
  private List<Goods> goods;
  private Type type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Brand()
  {
    super();
    id = 0;
    name = "";
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

  public Type getType()
  {
    return type;
  }

  public boolean hasType()
  {
    boolean has = type != null;
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
    Brand existingBrand = aGood.getBrand();
    if (existingBrand == null)
    {
      aGood.setBrand(this);
    }
    else if (!this.equals(existingBrand))
    {
      existingBrand.removeGood(aGood);
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
      aGood.setBrand(null);
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

  public boolean setType(Type aType)
  {
    boolean wasSet = false;
    Type existingType = type;
    type = aType;
    if (existingType != null && !existingType.equals(aType))
    {
      existingType.removeBrand(this);
    }
    if (aType != null)
    {
      aType.addBrand(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !goods.isEmpty() )
    {
      goods.get(0).setBrand(null);
    }
    if (type != null)
    {
      Type placeholderType = type;
      this.type = null;
      placeholderType.removeBrand(this);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "type = "+(getType()!=null?Integer.toHexString(System.identityHashCode(getType())):"null")
     + outputString;
  }
}