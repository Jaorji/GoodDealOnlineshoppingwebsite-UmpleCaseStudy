<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Address" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%><head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GoodDeal</title>
</head>

<html:html>
<link href="css/css.css" rel="stylesheet" type="text/css"> 
<script language="javascript">
function checkEmpty(memberForm){
for(i=0;i<memberForm.length;i++){
if(memberForm.elements[i].value==""){
alert("Can not be blank");
return false;
}
}
if(document.memberForm.password.value!=document.memberForm.passwordOne.value){
window.alert("Passwords are not the same");
return false;
}
if(isNaN(document.memberForm.age.value)){
window.alert("Age just can be numbers");
return false;
}
}
</script>
<%@page import="com.ji.Entity.Member"%>
<jsp:useBean id="addressDao" scope="page" class="com.ji.DAO.AddressDao"/>
<%Member form=(Member)session.getAttribute("form");
%>
<%List<Address> addressForm= addressDao.selectMemberAddress(form.getId());
%>
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td bgcolor="#F5F5F5" align="center">
<img src="image/fg1.jpg" width="752" height="39">


<html:form action="memberAction.do?action=6&id=<%=form.getId()%>"  onsubmit="return checkEmpty(memberForm)">
<table width="298"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="105" height="35">
          <div align="right">User&nbsp;Name：</div></td>
        <td width="187"><div align="center">
          <input type="text" name="name" value="<%=form.getUserName()%>">
        </div></td>
      </tr>
       <tr>
        <td height="35">
          <div align="right">Orignal&nbsp;Password：</div></td>
        <td><div align="center">
           <input type="hidden" name="answer" value="<%=form.getAnswer()%>">
            <input type="hidden" name="question" value="<%=form.getQuestion()%>">
          <input type="hidden" name="passwordOld" value="<%=form.getPassword()%>">
          <input type="password" name="oldPassword">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">New&nbsp;Password：</div></td>
        <td><div align="center">
          <input type="password" name="password">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">Password&nbsp;Confirm：</div></td>
        <td><div align="center">
          <input type="password" name="passwordOne">
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">First&nbsp;Name：</div></td>
        <td><div align="center">
          <input type="hidden" name="firstName" value="<%=form.getFirstName()%>"><%=form.getFirstName()%>
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">Last&nbsp;Name：</div></td>
        <td><div align="center">
           <input type="hidden" name="lastName" value="<%=form.getLastName()%>"><%=form.getLastName()%>
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">Birthday：</div></td>
        <td><div align="center">
           <input type="hidden" name="Birthday" value="<%=form.getBirthday()%>"><%=form.getBirthday()%>
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">Profession：</div></td>
        <td><div align="center">
          <input type="hidden" name="Profession" value="<%=form.getProfession()%>"><%=form.getProfession()%>
        </div></td>
      </tr>
      <tr>
        <td height="35">
          <div align="right">Email Address：</div></td>
        <td><div align="center">
          <input name="email" type="text"  value="<%=form.getEmailAddress()%>">
        </div></td>
        
      </tr>
        
    </table>
    
    <table>
    <tr>
    <td  height="25"><div align="center">Address</div></td>
      </tr>
    <tr>
    <%if(addressForm==null){ %>
  <td height="30" colspan="2">
            <div align="center"><img src="image/bg-add.gif" width="9" height="9"><a href="fg-addressInsert.jsp">&nbsp;Add New Address&nbsp;</a></div>
            </td><%} %><%else{ %>
          <%for(int i=0;i<addressForm.size();i++) {%>
          <tr>
        <td><div align="center">
        
          <input type="hidden"name="address" type="text"  value="<%=addressForm.get(i).getCountry()%>"><%=addressForm.get(i).getCountry()%>&nbsp;
          <%=addressForm.get(i).getProvince()%>&nbsp;<%=addressForm.get(i).getCity()%>&nbsp;<%=addressForm.get(i).getStreetNumber()%>&nbsp;<%=addressForm.get(i).getStreetName()%>
          &nbsp;<%=addressForm.get(i).getPostalCode()%>&nbsp; <%=addressForm.get(i).getTelephone()%>
        </div>
      
        </td>
        
        <td>
          <a href="fg-updateMember.jsp?addressId=<%=addressForm.get(i).getId()%>">&nbsp;&nbsp;Delete</a>
          <%if(request.getParameter("addressId")!=null) {
        	  addressDao.deleteAddress(Integer.valueOf(request.getParameter("addressId")));
          }
          %>
        </td>
        </tr>
        <%} %>
      </tr>
        <td height="30" colspan="2">
            <div align="center"><img src="image/bg-add.gif" width="9" height="9"><a href="fg-memberAddressInsert.jsp">&nbsp;Add New Address&nbsp;</a></div>
            </td>
            <%} %>
    </table>
   
    <br>
<input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
<a href="#" onClick="javascript:memberForm.reset()"><img src="image/clear01.gif"></a>
&nbsp;&nbsp;
<a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back01.gif"></a>
</html:form>



 
  <p>&nbsp;  </p>    </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html:html>
