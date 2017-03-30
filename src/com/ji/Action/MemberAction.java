/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;
import java.io.IOException;
import java.util.*;
import com.ji.Entity.*;
import com.ji.DAO.*;

// line 6 "../../../MemberAction.ump"
public class MemberAction extends Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MemberAction Attributes
  private int action;

  //MemberAction Associations
  private Member memberForm;
  private MemberDao dao;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MemberAction(int aAction, Member aMemberForm, MemberDao aDao)
  {
    super();
    action = aAction;
    if (!setMemberForm(aMemberForm))
    {
      throw new RuntimeException("Unable to create MemberAction due to aMemberForm");
    }
    if (!setDao(aDao))
    {
      throw new RuntimeException("Unable to create MemberAction due to aDao");
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

  public Member getMemberForm()
  {
    return memberForm;
  }

  public MemberDao getDao()
  {
    return dao;
  }

  public boolean setMemberForm(Member aNewMemberForm)
  {
    boolean wasSet = false;
    if (aNewMemberForm != null)
    {
      memberForm = aNewMemberForm;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setDao(MemberDao aNewDao)
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
    memberForm = null;
    dao = null;
  }

  // line 20 "../../../MemberAction.ump"
   public  MemberAction(){
    
  }

  // line 24 "../../../MemberAction.ump"
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException{
    dao = new MemberDao();
		this.action = Integer.parseInt(request.getParameter("action"));
		switch (action) {
		case 0: {
			return insertMember(mapping, form, request, response); 
		}
		case 1: {
			return checkMember(mapping, form, request, response); 
		}
		case 2: {
			return selectMember(mapping, form, request, response); 
		}
        case 3: {
			return selectOneMember(mapping, form, request, response); 
		}
		case 4: {
			return deleteMember(mapping, form, request, response); 
		}
		case 5: {
			return selectOneMemberHead(mapping, form, request, response); 
		}
		case 6: {
			return updateMemberHead(mapping, form, request, response); 
		}

		}
		// MemberForm memberForm = (MemberForm) form;
		throw new java.lang.UnsupportedOperationException(
				"Method $execute() not yet implemented.");
  }

  // line 59 "../../../MemberAction.ump"
   public ActionForward updateMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    Member memberForm = (Member) form;		
		dao.updateMember(memberForm);
		request.setAttribute("success", "update your information");
		return mapping.findForward("operationMember");
  }

  // line 69 "../../../MemberAction.ump"
   public ActionForward selectOneMemberHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    request.setAttribute("form", dao.selectOneMember(Integer
				.valueOf(request.getParameter("id"))));
		return mapping.findForward("selectOneMemberHead");
  }

  // line 77 "../../../MemberAction.ump"
   public ActionForward deleteMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException{
    if (!dao.deleteMember(Integer.valueOf(request.getParameter("id")))) {
		   return mapping.findForward("deleteMember");
		}
		return selectMember(mapping,form,request,response);
  }

  // line 87 "../../../MemberAction.ump"
   public ActionForward selectOneMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    Integer id=Integer.valueOf(request.getParameter("id"));
		request.setAttribute("form", dao.selectOneMember(id));
		return mapping.findForward("selectOneMember");
  }

  // line 95 "../../../MemberAction.ump"
   public ActionForward selectMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Member> list = dao.selectMember();
		int pageNumber = list.size(); 
		int maxPage = pageNumber; 
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
			maxPage = maxPage / 6 + 1;
		}
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		return mapping.findForward("selectMember");
  }

  // line 117 "../../../MemberAction.ump"
   public ActionForward checkMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    String name = request.getParameter("userName");
		System.out.println("name" + name);
		Member memberForm = dao.selectMember(name);
		if (memberForm==null||memberForm.equals("")) {
			request.setAttribute("result", "no such username");
		} else if (!memberForm.getPassword().equals(request.getParameter("password").trim())) {
		    System.out.println("password"+request.getParameter("password"));
		     System.out.println("password"+memberForm.getPassword());
		    
			request.setAttribute("result", "password error");
		} else {	
			request.setAttribute("memberForm", memberForm);
		}
		return mapping.findForward("checkMember");
  }

  // line 135 "../../../MemberAction.ump"
   public ActionForward insertMember(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    memberForm=(Member)form;
		Member formSelect=dao.selectMember(memberForm.getUserName());
		if (formSelect == null || formSelect.equals("")) {
			dao.insertMember(memberForm);
			request.setAttribute("success", "register successful");
		} else {
			request.setAttribute("success", "register error");
		}
		return mapping.findForward("operationMember");
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "action" + ":" + getAction()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "memberForm = "+(getMemberForm()!=null?Integer.toHexString(System.identityHashCode(getMemberForm())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "dao = "+(getDao()!=null?Integer.toHexString(System.identityHashCode(getDao())):"null")
     + outputString;
  }
}