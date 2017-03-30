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

// line 9 "../../../OrderAction.ump"
public class OrderAction extends Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderAction Attributes
  private int action;

  //OrderAction Associations
  private OrderDao orderDao;
  private Order order;
  private OrderDetailDao orderDetail;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderAction(int aAction, OrderDao aOrderDao, Order aOrder, OrderDetailDao aOrderDetail)
  {
    super();
    action = aAction;
    if (!setOrderDao(aOrderDao))
    {
      throw new RuntimeException("Unable to create OrderAction due to aOrderDao");
    }
    if (!setOrder(aOrder))
    {
      throw new RuntimeException("Unable to create OrderAction due to aOrder");
    }
    if (!setOrderDetail(aOrderDetail))
    {
      throw new RuntimeException("Unable to create OrderAction due to aOrderDetail");
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

  public OrderDao getOrderDao()
  {
    return orderDao;
  }

  public Order getOrder()
  {
    return order;
  }

  public OrderDetailDao getOrderDetail()
  {
    return orderDetail;
  }

  public boolean setOrderDao(OrderDao aNewOrderDao)
  {
    boolean wasSet = false;
    if (aNewOrderDao != null)
    {
      orderDao = aNewOrderDao;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setOrder(Order aNewOrder)
  {
    boolean wasSet = false;
    if (aNewOrder != null)
    {
      order = aNewOrder;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setOrderDetail(OrderDetailDao aNewOrderDetail)
  {
    boolean wasSet = false;
    if (aNewOrderDetail != null)
    {
      orderDetail = aNewOrderDetail;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    orderDao = null;
    order = null;
    orderDetail = null;
  }

  // line 23 "../../../OrderAction.ump"
   public  OrderAction(){
    
  }

  // line 28 "../../../OrderAction.ump"
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    action = Integer.parseInt(request.getParameter("action"));
    orderDao = new OrderDao();
    orderDetail = new OrderDetailDao();
    switch (action) {
      case 0: {
        return selectOrder(mapping, form, request, response); 
      }
      case 1: {
        return selectOrderSend(mapping, form, request, response); 
      }
      case 2: {
      return deleteOrder(mapping, form, request, response); 
    }
    case 3: {
        return selectOneOrder(mapping, form, request, response); 
      }

    }
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

  // line 54 "../../../OrderAction.ump"
   public ActionForward selectOneOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    String number=request.getParameter("orderNumber");
   request.setAttribute("orderForm",orderDao.selectOrderNumber(number));
   request.setAttribute("orderDetailList",orderDetail.selectOrderDetailNumber(number));
   return mapping.findForward("selectOneOrder");
  }

  // line 64 "../../../OrderAction.ump"
   public ActionForward deleteOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    String number = (String) request.getParameter("orderNumber");
    orderDetail.deleteOrderDetail(number);
    orderDao.deleteOrder(number);
    return selectOrder(mapping, form, request, response);
  }

  // line 75 "../../../OrderAction.ump"
   public ActionForward selectOrderSend(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    orderDao.updateStatusOrderShip(request.getParameter("orderNumber"));
    return selectOrder(mapping, form, request, response);
  }

  // line 85 "../../../OrderAction.ump"
   public ActionForward selectOrder(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Order> list = orderDao.selectOrderList();
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
    return mapping.findForward("selectOrder");
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "action" + ":" + getAction()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "orderDao = "+(getOrderDao()!=null?Integer.toHexString(System.identityHashCode(getOrderDao())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderDetail = "+(getOrderDetail()!=null?Integer.toHexString(System.identityHashCode(getOrderDetail())):"null")
     + outputString;
  }
}