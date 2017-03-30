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

// line 8 "../../../BrandAction.ump"
public class BrandAction extends Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BrandAction Attributes
  private int action;

  //BrandAction Associations
  private BrandDao dao;
  private Brand brand;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BrandAction(int aAction, BrandDao aDao, Brand aBrand)
  {
    super();
    action = aAction;
    if (!setDao(aDao))
    {
      throw new RuntimeException("Unable to create BrandAction due to aDao");
    }
    if (!setBrand(aBrand))
    {
      throw new RuntimeException("Unable to create BrandAction due to aBrand");
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

  public BrandDao getDao()
  {
    return dao;
  }

  public Brand getBrand()
  {
    return brand;
  }

  public boolean setDao(BrandDao aNewDao)
  {
    boolean wasSet = false;
    if (aNewDao != null)
    {
      dao = aNewDao;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setBrand(Brand aNewBrand)
  {
    boolean wasSet = false;
    if (aNewBrand != null)
    {
      brand = aNewBrand;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    dao = null;
    brand = null;
  }

  // line 21 "../../../BrandAction.ump"
   public  BrandAction(){
    
  }

  // line 26 "../../../BrandAction.ump"
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    action = Integer.parseInt(request.getParameter("action"));
    dao = new BrandDao();
    switch (action) {
      case 0: {
        return smallTypeSelect(mapping, form, request, response);
      }
      case 2: {
        return smallTypeInsert(mapping, form, request, response); 
      }
      case 3: {
        return smallTypeDelete(mapping, form, request, response); 
      }
      case 4: {
        return smallTypeSelectOne(mapping, form, request, response); 
      }
      case 5: {
        return smallTypeUpdate(mapping, form, request, response); 
      }
      case 6: {
        return smallTypeSelectBigId(mapping, form, request, response); 
      }
    }


    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  // line 59 "../../../BrandAction.ump"
   public ActionForward smallTypeSelectBigId(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Brand> list = dao.selectOneBigId(Integer.valueOf(request.getParameter("typeId")));
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
    return mapping.findForward("smallTypeSelect");
  }

  // line 84 "../../../BrandAction.ump"
   public ActionForward smallTypeUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    Type typeForm = new Type();
    Brand smallTypeForm = new Brand();
    TypeDao typeDao = new TypeDao();
    typeForm = typeDao.selectOneType(Integer.valueOf(request.getParameter("typeId")));
    smallTypeForm.setId(Integer.valueOf(request.getParameter("id")));
    smallTypeForm.setName(request.getParameter("name"));
    smallTypeForm.setType(typeForm);
    dao.updateSmall(smallTypeForm);
    request.setAttribute("success", "Update sccessfully");
    return mapping.findForward("smallTypeOperation");
  }

  // line 101 "../../../BrandAction.ump"
   public ActionForward smallTypeSelectOne(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    request.setAttribute("small",
                         dao.selectOneBig(Integer.valueOf(request.
        getParameter("id"))));
    return mapping.findForward("smallTypeSelectOne");
  }

  // line 113 "../../../BrandAction.ump"
   public ActionForward smallTypeDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    if (dao.deleteSmall(Integer.valueOf(request.getParameter("id")))) {
      request.setAttribute("result", "Brand Deleted");
    }else {
      request.setAttribute("result", "can not delete");
    }
    return mapping.findForward("smallTypeOperation");
  }

  // line 126 "../../../BrandAction.ump"
   public ActionForward smallTypeInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    Type typeForm = new Type();
    Brand smallTypeForm=new Brand();
    
    TypeDao typeDao = new TypeDao();
    typeForm = typeDao.selectOneType(Integer.valueOf(request.getParameter("typeId")));
    smallTypeForm.setName(request.getParameter("name"));
    smallTypeForm.setType(typeForm);
    dao.insertSmall(smallTypeForm);
    request.setAttribute("result", "Inset Brand");
    return mapping.findForward("smallTypeOperation");
  }

  // line 143 "../../../BrandAction.ump"
   public ActionForward smallTypeSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Brand> list = dao.selectSmall();
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
    return mapping.findForward("smallTypeSelect");
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "action" + ":" + getAction()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dao = "+(getDao()!=null?Integer.toHexString(System.identityHashCode(getDao())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "brand = "+(getBrand()!=null?Integer.toHexString(System.identityHashCode(getBrand())):"null")
     + outputString;
  }
}