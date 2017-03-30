<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ji.Entity.OrderDetail"%>
<%@ page import="com.ji.Entity.Order"%>
<%@ page import="com.ji.Entity.Member"%>
<jsp:useBean id="order" scope="page" class="com.ji.DAO.OrderDao"/>
<jsp:useBean id="orderDetail" scope="page" class="com.ji.DAO.OrderDetailDao"/>
<jsp:useBean id="goodsDao" scope="page" class="com.ji.DAO.GoodsDao"/>
<jsp:useBean id="member" scope="page" class="com.ji.DAO.MemberDao"/>
<%Member form=(Member)session.getAttribute("form");%>
<%Member memberForm=member.selectOneMember(form.getId());%>
<%List orderList=order.selectOrderHead(memberForm.getId());%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GoodDeal</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>











<jsp:include page="fg-top.jsp" flush="true"/>

<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="207" bgcolor="#F5F5F5">
    <!--左侧01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
    <!--右侧01-->	
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	
	<br><br>
	<strong>Order Detail</strong>
	 <br>	 <br>	 <br>
              <%if(orderList.size()==0){%>
     No Order History!
     <%}else{%>
          
		  <table width="95%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

       <tr align="center">
            <td width="15%" height="21">ID</td> 
            <td width="18%">Status</td>
            <td width="12%">Operation</td>
           <td width="12%">If Delivered</td>
          </tr>
      <%
      for(int i=0;i<orderList.size();i++){
        Order orderForm=(Order)orderList.get(i);
        %>
         
          <tr align="center">
            <td height="24"><%=orderForm.getOrderNumber()%></td>
            <td><%=orderForm.getStatus() %></td>
             <td><a href="cart_detail.jsp?orderNumber=<%=orderForm.getOrderNumber()%>">Detail Information</a></td>
             <td><%if(orderForm.getStatusFullName().equals("delivered")){%>
		 Delivered
		 <%}else if(orderForm.getStatusFullName().equals("paid")){
			 
		 }
		 %><%else{%>
		  <a  href="cart_detail.jsp?orderId=<%=orderForm.getId()%>">Confirm Delivery</a>
		
		 <%}%>
		 &nbsp;&nbsp;
             </td>
          </tr>
          
          <%}%>
         
      </table>
   

      <div align="center">

		   <br>
		    <%if(request.getParameter("orderId")!=null){
		   order.updateStatusOrderDeliver(Integer.valueOf(request.getParameter("orderId")));
		   } %>
	      <%if(request.getParameter("orderNumber")!=null){%>

	      <br>
	      Detail Information
	      <br>
<br>

      <table width="89%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

        <tr align="center">
          <td width="25%" height="21">Id</td>
          <td width="24%">Name</td>
          <td width="28%">Price</td>
          <td width="23%">Quantity</td>
          
        </tr>  <%
        double sum=0;
            List orderDetailList=orderDetail.selectOrderDetailNumber(request.getParameter("orderNumber"));
        for(int orderDetailNumber=0;orderDetailNumber<orderDetailList.size();orderDetailNumber++){
         OrderDetail orderDetailForm=(OrderDetail)orderDetailList.get(orderDetailNumber);
         sum=sum+orderDetailForm.getPrice()*orderDetailForm.getQuantity();
         %>
        <tr  align="center" >
          <td height="21"><%=orderDetailForm.getOrderNumber()%></td>
          <%
          for(int i=0;i<orderDetailForm.getGoods().size();i++){ %>
           <td height="21"><%=orderDetailForm.getGoods().get(i).getName() %></td><%} %>
         
          <td><%=orderDetailForm.getPrice()%>$</td>
          <td><%=orderDetailForm.getQuantity()%></td>
        
        </tr>
        <%}%>
      </table>

	   <table width="89%"  border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td height="24"><div align="right">Total Price：<%=sum%>$</div></td>
         </tr>
       </table> <%}%>
      </div>
      <%} %>
	
	
</td>
  </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>























</body>
</html>
