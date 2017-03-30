/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Action;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.util.*;
import com.ji.Entity.*;
import com.ji.DAO.*;

// line 6 "../../../managerAction.ump"
public class ManagerAction extends Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ManagerAction Attributes
  private int action;

  //ManagerAction Associations
  private Manager managerForm;
  private ManagerDao dao;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ManagerAction(int aAction, Manager aManagerForm, ManagerDao aDao)
  {
    super();
    action = aAction;
    if (!setManagerForm(aManagerForm))
    {
      throw new RuntimeException("Unable to create ManagerAction due to aManagerForm");
    }
    if (!setDao(aDao))
    {
      throw new RuntimeException("Unable to create ManagerAction due to aDao");
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

  public Manager getManagerForm()
  {
    return managerForm;
  }

  public ManagerDao getDao()
  {
    return dao;
  }

  public boolean setManagerForm(Manager aNewManagerForm)
  {
    boolean wasSet = false;
    if (aNewManagerForm != null)
    {
      managerForm = aNewManagerForm;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setDao(ManagerDao aNewDao)
  {
    boolean wasSet = false;
    if (aNewDao != null)
    {
      dao = aNewDao;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    managerForm = null;
    dao = null;
  }

  // line 16 "../../../managerAction.ump"
   public  ManagerAction(){
    
  }

  // line 25 "../../../managerAction.ump"
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    dao = new ManagerDao();
    action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        return managerCheck(mapping, form, request, response); 
        }
      case 1: {
        return managerSelect(mapping, form, request, response); 
      }
      case 3: {
        return managerInsert(mapping, form, request, response); 
      }
      case 4: {
        return managerDelete(mapping, form, request, response); 
      }
      case 8: {
        return managerUpdatePassword(mapping, form, request, response); 
      }
    }
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  // line 53 "../../../managerAction.ump"
   public ActionForward managerUpdatePassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    Manager managerForm = (Manager) form;
 
    managerForm.setAccountName(request.getParameter("accountName"));
    managerForm.setPassword(request.getParameter("password"));
    dao.updateManagerPassword(managerForm);
    request.setAttribute("reslut", "password changed");
    return mapping.findForward("managerUpdatePassword");
  }

  // line 69 "../../../managerAction.ump"
   public ActionForward managerDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    dao.deleteManager(Integer.valueOf(request.getParameter("id")));
    request.setAttribute("reslut", "manager deleted");
    return managerSelect(mapping,form,request,response);
  }

  // line 78 "../../../managerAction.ump"
   public ActionForward managerInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    Manager managerForm = (Manager) form;
    managerForm.setAccountName(request.getParameter("accountName"));
     managerForm.setPassword(request.getParameter("password"));
      managerForm.setFirstName(request.getParameter("firstName"));
       managerForm.setLastName(request.getParameter("lastName"));
        managerForm.setBirthday(request.getParameter("birthday"));
         managerForm.setEmailAddress(request.getParameter("emailAddress"));

    Manager manager = dao.selectOne(managerForm.getAccountName());
    if (manager == null || manager.equals("")) {
       dao.insertManager(managerForm);
       return managerSelect(mapping,form,request,response);
    }else {
      request.setAttribute("reslut", "Insert Manager");
      return mapping.findForward("managerInsert");
    }
  }

  // line 102 "../../../managerAction.ump"
   public ActionForward managerSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Manager> list = dao.selectManager();
    int pageNumber = list.size(); 
    int maxPage = pageNumber; 
    String number = request.getParameter("i");
    if (maxPage % 7 == 0) {
      maxPage = maxPage / 7;
    }
    else {
      maxPage = maxPage / 7 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));

    request.setAttribute("list", list);
    return mapping.findForward("managerSelect");
  }

  // line 128 "../../../managerAction.ump"
   public ActionForward managerCheck(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    String account =request.getParameter("accountName");
    Manager managerForm= dao.selectOne(account);
    if (managerForm == null) {
      request.setAttribute("result", "no such manager exist!");
      return mapping.findForward("checkResult");
    }
    else if (!managerForm.getPassword().equals(request.getParameter("password"))) {
      request.setAttribute("result", "password worry");
      return mapping.findForward("checkResult");
    } else {
      request.setAttribute("manager", managerForm);
      return mapping.findForward("checkResult");
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "action" + ":" + getAction()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "managerForm = "+(getManagerForm()!=null?Integer.toHexString(System.identityHashCode(getManagerForm())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "dao = "+(getDao()!=null?Integer.toHexString(System.identityHashCode(getDao())):"null")
     + outputString;
  }
}