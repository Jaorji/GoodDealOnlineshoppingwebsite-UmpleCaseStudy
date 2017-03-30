<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ji.Entity.OrderDetail"%>
<%@ page import="com.ji.Entity.Order"%>
<%@ page import="com.ji.Entity.Goods"%>
<%@ page import="com.ji.Entity.Cart"%>
<%@ page import="com.ji.Entity.Address" %>
<%@ page import="com.ji.Entity.Member" %>
<%@ page import="com.ji.Entity.Brand" %>
<%@ page import="com.ji.Entity.Type" %>
<%@ page import="com.ji.tool.CountTime" %>
<jsp:useBean id="goodsDao" scope="page" class="com.ji.DAO.GoodsDao"/>
<jsp:useBean id="orderDao" scope="page" class="com.ji.DAO.OrderDao"/>
<jsp:useBean id="orderDetailDao" scope="page" class="com.ji.DAO.OrderDetailDao"/>
<jsp:useBean id="addressDao" scope="page" class="com.ji.DAO.AddressDao"/>
<jsp:useBean id="memberDao" scope="page" class="com.ji.DAO.MemberDao"/>
<%

Member mform=(Member)session.getAttribute("form");
Address address=(Address)session.getAttribute("address");
request.setCharacterEncoding("gb2312");

Goods goodsForm= new Goods();
Order order=new Order();
OrderDetail orderDetail=new OrderDetail();
Cart sellGoodsForm=new Cart();

String number=request.getParameter("orderNumber").trim();
//先添加订单表
order.setOrderNumber(number);


order.setPaymentMethod(request.getParameter("paymentMethod"));
order.setShipmentMethod(request.getParameter("shippmentMethod"));
order.setMessage(request.getParameter("message"));
Address addressForm= new Address();
addressForm = addressDao.selectOneAddress(Integer.valueOf(request.getParameter("addressId")));
order.setAddress(addressForm);
Member memberForm = new Member();
memberForm = memberDao.selectOneMember(Integer.valueOf(mform.getId()));
System.out.println("44444"+ mform.getId());
memberForm.addOrder(order);
/* order.setMember(memberForm); */
java.util.Date utilDate = new java.util.Date();
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//order.setDatePlaced(sqlDate);
//order.setDatePayment(sqlDate);
 
order.makePayment();
order.getStatus();
System.out.println("order status"+order.getStatus());

orderDao.insertOrderDetail(order);
orderDao.updateStatusOrder(number);

//然后添加商品的明仔细表
System.out.println("check out"+session.getAttribute("cart"));
List cart=(List)session.getAttribute("cart");
System.out.println("cart"+ cart);
for(int i=0;i<cart.size();i++){
  Cart form=(Cart)cart.get(i);
 orderDetail.setOrderNumber(number);
 orderDetail.setId(new Integer(form.getId()));
 goodsForm = goodsDao.selectOneGoods(form.getId());
 orderDetail.setPrice(form.getPrice());
 orderDetail.setQuantity(form.getNumber());
 
 orderDetail.addGood(goodsForm);
orderDetail.setOrder(order);
 goodsDao.updateGoodsNumber(form.getNumber(),new Integer(form.getId()));
 orderDetailDao.insertOrderDetail(orderDetail);
}
out.println("<script language='javascript'>alert('Please remember your order number!');window.location.href='cart_clear.jsp';</script>");
%>
