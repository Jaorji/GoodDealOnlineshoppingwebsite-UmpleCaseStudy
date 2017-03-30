<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Order"%>
<%@page import="com.ji.Entity.OrderDetail"%>
<%@page import="com.ji.Entity.Goods"%>
<%@page import="com.ji.Entity.Address" %>
<jsp:useBean id="order" scope="page" class="com.ji.DAO.OrderDao"/>
<jsp:useBean id="goods" scope="page" class="com.ji.DAO.GoodsDao"/>
<jsp:useBean id="orderDetail" scope="page" class="com.ji.DAO.OrderDetailDao"/>
<jsp:useBean id="addressDao" scope="page" class="com.ji.DAO.AddressDao"/>
<%Order orderForm=(Order)request.getAttribute("orderForm");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Background System</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<jsp:include page="bg-up.jsp" flush="true"/>


<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td align="center"><strong>Order ：<%=orderForm.getOrderNumber() %>&nbsp;&nbsp;Detail Information</strong></td>
          </tr>
        </table>
        <br>

<table width="76%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DCDCDC">
      <tr align="center" >
        <td width="26%" height="25">User Name</td>
        <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getMember().getUserName()%></td>
 
              <td height="30"><div align="center">Address：</div></td>
              <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getAddress().getCountry()%></td>
              </tr>
              <tr>
              <td height="30"><div align="center">Province：</div></td>
              <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getAddress().getProvince()%></td>
          
              <td height="30"><div align="center">City：</div></td>
              <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getAddress().getCity()%></td>
              </tr>
             <tr>
              <td height="30"><div align="center">Street&nbsp;Number：</div></td>
             <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getAddress().getStreetNumber()%></td>
            
              <td height="30"><div align="center">Street&nbsp;Name：</div></td>
             <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getAddress().getStreetName()%></td>
              </tr>
              <tr>
              <td height="30"><div align="center">Postal Code：</div></td>
             <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getAddress().getPostalCode()%></td>
              
              <td height="30"><div align="center">Telephone：</div></td>
              <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getAddress().getTelephone()%></td>
              </tr>
    
      <tr  align="center">
        <td height="25">PaymentMethod</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getPaymentMethod()%></td>
        <td>Shipment Method</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getShipmentMethod()%></td>
      </tr>
      <tr align="center">
        <td height="25" >Message</td>
        <td bgcolor="#FFFFFF"><%=orderForm.getMessage()%></td>
       
      </tr>
    </table>
	<br>
	    <strong>Goods Information</strong>	  <br><br>
	    <table width="74%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DCDCDC">
          <tr>
            <td><div align="center">Name</div></td>
            <td><div align="center">Quantity</div></td>
            <td><div align="center">Price</div></td>
          </tr>
         <%
        double sum=0;
            List orderDetailList=orderDetail.selectOrderDetailNumber(orderForm.getOrderNumber());
            System.out.println("orderDetailInfo"+ orderDetailList);
            System.out.println("orderDetailInfo number"+ orderForm.getOrderNumber());
        for(int orderDetailNumber=0;orderDetailNumber<orderDetailList.size();orderDetailNumber++){
         OrderDetail orderDetailForm=(OrderDetail)orderDetailList.get(orderDetailNumber);
         System.out.println("orderDeatilForm"+ orderDetailForm);
         System.out.println("order goods name"+orderDetailForm.getGoods() );
         sum=sum+orderDetailForm.getPrice()*orderDetailForm.getQuantity();
         %>
        <tr  align="center" >
          <% for(int i=0;i<orderDetailForm.getGoods().size();i++){ %>
           <td height="21"><%=orderDetailForm.getGoods().get(i).getName() %></td><%} %>
           <td><%=orderDetailForm.getQuantity()%></td>
          <td><%=orderDetailForm.getPrice()%>$</td>
        
        </tr>
        <%}%>
      </table>
	    <br>
    Total Price:<%=sum%><br>
    <table width="76%" height="19"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="72%">
              <div align="left">
                <%if(orderForm.getStatusFullName().equals("shipped")||orderForm.getStatusFullName().equals("delivered")){%>
                Sent
                <%}else{%>
                No send
                <%}%>
              </div></td><td width="28%"><div align="right"><a href="javascript:history.go(-1)">back</a></div></td>
      </tr>
    </table>



    </td>
  </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true" />

</body>
</html>
