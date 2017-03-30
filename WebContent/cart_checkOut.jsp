<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ji.Entity.Member"%>
<%@ page import="com.ji.Entity.Address" %>
<%java.util.Date date=new java.util.Date();%>
<jsp:useBean id="dao" scope="page" class="com.ji.DAO.MemberDao"/>
<jsp:useBean id="addressDao" scope="page" class="com.ji.DAO.AddressDao"/>
<%

Member form=(Member)session.getAttribute("form");
Address addressForm=(Address)session.getAttribute("addressForm");
List addressList=addressDao.selectAddress();
System.out.println("cart session"+session.getAttribute("cart"));
%>
<html>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("Can not be blank");
return false;
}
}

}


</script>
<script  type= "text/javascript" src = "country.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GoodDeal</title>

<style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-weight: bold;
}
-->
</style>
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
	<strong>Check Out</strong>   <form name="form" method="post" action="cart_checkOutOrder.jsp"  onSubmit="checkEmpty(form)">
		  <table width="68%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" colspan="2"> <div align="center" class="style1">Notice: Please don't submit useless order! </div></td>
            </tr>
			   <tr>
              <td height="30"><div align="center">Order&nbsp;Code&nbsp;Number：</div></td>
              <td>&nbsp;<input type="hidden" name="orderNumber" value="<%=date.getTime()%>"><%=date.getTime()%></td>
            </tr>
            <tr>
              <td width="24%" height="30"><div align="center">User Name：</div></td>
              <td width="76%">&nbsp;<input type="text" name="userName" value="<%=form.getUserName()%>"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">First Name：</div></td>
              <td>&nbsp;<input type="text" name="firstName" value="<%=form.getFirstName()%>"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">Last Name：</div></td>
              <td>&nbsp;<input type="text" name="lastName" value="<%=form.getLastName()%>"></td>
            </tr>
            <%if(addressList.isEmpty()){%>
        
            <tr>
             <td height="30" colspan="2"><div align="center">Please add a new address!：</div></td>
            </tr>
            <tr>
            <td height="30" colspan="2">
            <div align="center"><img src="image/bg-add.gif" width="9" height="9"><a href="fg-addressInsert.jsp">&nbsp;Add New Address&nbsp;</a></div></td>
            </tr>
          
          <%}else{ %>
          <tr>
              <td height="30"><div align="center">Address：</div></td>
              <td width="4%" height= "30"><select name="addressId" width="4%" align="center"><option width="4%" value="">Please Select</option>
          <%for(int i=0;i<addressList.size();i++){
            Address address=(Address)addressList.get(i);
            %>

          <option value="<%=address.getId()%>">
		  <%=addressDao.selectOneAddress(address.getId()).getCountry()%>&nbsp;
          <%=addressDao.selectOneAddress(address.getId()).getProvince()%>&nbsp;<%=addressDao.selectOneAddress(address.getId()).getCity()%>&nbsp;
          <%=addressDao.selectOneAddress(address.getId()).getStreetNumber()%>&nbsp;
          <%=addressDao.selectOneAddress(address.getId()).getStreetName()%>
          &nbsp;<%=addressDao.selectOneAddress(address.getId()).getPostalCode()%>&nbsp; <%=addressDao.selectOneAddress(address.getId()).getTelephone()%>
		  </option>
            <%}%>
            </select></td>
              </tr>
   
                 <tr>
            
            </tr>
           
<%} %>
            <tr>
              <td height="30"><div align="center">PaymentMethod：</div></td>
              <td>&nbsp;
			  <select name="paymentMethod" class="textarea">
			        <option value="">Please Select</option>
      <option value="Visa">Visa</option>
      <option value="Master Card">Master card</option>
      <option value="Debit">Debit</option>
    </select>
			  </td>
            </tr>

            <tr>
              <td height="30"><div align="center">Mail Method：</div></td>
              <td>&nbsp;<select name="shippmentMethod" class="textarea">
			        <option value="">Please Select</option>
      <option value="EMS">EMS</option>
      <option value="UPS">UPS</option>
      <option value="Canada Post">Canada Post</option>
    </select>
			  
			  </td>
            </tr>
            <tr>
              <td height="60"><div align="center">Message：</div></td>
              <td>&nbsp;<textarea name="message"></textarea></td>
            </tr>
        </table>
                <input type="submit" name="Submit2" value="Submit">&nbsp;
               <input type="reset" name="reset" value="Clear">&nbsp;
          <input type="button" name="back" value="Back" onClick="javasrcipt:history.go(-1)">
      </form>



	
	
</td>
  </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>













































</body>
</html>
