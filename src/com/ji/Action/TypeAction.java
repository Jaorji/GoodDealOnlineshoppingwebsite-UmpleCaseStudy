/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;
import java.util.List;
import com.ji.DAO.*;
import com.ji.Entity.*;

// line 7 "../../../TypeAction.ump"
public class TypeAction extends Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TypeAction Attributes
  private int action;

  //TypeAction Associations
  private TypeDao dao;
  private Type type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TypeAction(int aAction, TypeDao aDao, Type aType)
  {
    super();
    action = aAction;
    if (!setDao(aDao))
    {
      throw new RuntimeException("Unable to create TypeAction due to aDao");
    }
    if (!setType(aType))
    {
      throw new RuntimeException("Unable to create TypeAction due to aType");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAction(int aAction)
  {
    boolean wasSet = false;
    action = aAction;
    wasSet = true;
    return wasSet;
  }

  public int getAction()
  {
    return action;
  }

  public TypeDao getDao()
  {
    return dao;
  }

  public Type getType()
  {
    return type;
  }

  public boolean setDao(TypeDao aNewDao)
  {
    boolean wasSet = false;
    if (aNewDao != null)
    {
      dao = aNewDao;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setType(Type aNewType)
  {
    boolean wasSet = false;
    if (aNewType != null)
    {
      type = aNewType;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    dao = null;
    type = null;
  }

  // line 21 "../../../TypeAction.ump"
   public  TypeAction(){
    
  }

  // line 26 "../../../TypeAction.ump"
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    dao = new TypeDao();
    this.action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        return bigTypeSelect(mapping, form, request, response); 
      }
      case 2: {
        return bigTypeInsert(mapping, form, request, response); 
      }
      case 3: {
        return bigTypeDelete(mapping, form, request, response); 
      }
    }

    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  // line 49 "../../../TypeAction.ump"
   public ActionForward bigTypeDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    if (dao.deleteBig(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("result", "Delete Type");
    }
    else {
      request.setAttribute("result", "Сon not delete type");
    }

    return mapping.findForward("resultBigType");
  }

  // line 65 "../../../TypeAction.ump"
   public ActionForward bigTypeInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    dao.insertBig(request.getParameter("name"));
    request.setAttribute("result", "Insert type");
    return mapping.findForward("resultBigType");
  }

  // line 76 "../../../TypeAction.ump"
   public ActionForward bigTypeSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Type> list = dao.selectBig();
    int pageNumber = list.size(); 
    int maxPage = pageNumber;
    String number = request.getParameter("i");
    if (maxPage % 6 == 0) {
      maxPage = maxPage / 6;
    }
    else {
      maxPage = maxPage / 6 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));
    request.setAttribute("list", list);
    return mapping.findForward("bigTypeSelect");
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "action" + ":" + getAction()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dao = "+(getDao()!=null?Integer.toHexString(System.identityHashCode(getDao())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "type = "+(getType()!=null?Integer.toHexString(System.identityHashCode(getType())):"null")
     + outputString;
  }
}