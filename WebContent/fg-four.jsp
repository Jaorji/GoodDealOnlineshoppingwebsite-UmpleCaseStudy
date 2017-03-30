<%@ page contentType="text/html; charset=gb2312" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GoodDeal</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<%@page import="com.ji.Entity.Member"%>
<jsp:useBean id="dao" scope="page" class="com.ji.DAO.MemberDao"/>
<%
request.setCharacterEncoding("gb2312");
String password=request.getParameter("password").trim();
Integer id=Integer.valueOf(request.getParameter("id"));
System.out.println("password" + request.getParameter("password"));
System.out.println("id" + request.getParameter("id"));
boolean change=dao.updatePassword(password,id);
System.out.println("change" + change);
%>
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td bgcolor="#FFFFFF" align="center">
<img src="image/fg2.jpg" width="752" height="45">
 

  

  
  
   <p><strong>
    <%if(change){%>
    Updated your password！！！
  <%}else{%>
    Your password didn't update！！！
  <%}%>
  </strong></p>
<meta http-equiv="refresh" content="3;URL=index.jsp">
  
  
  
  
  
  
  
  
  
   </td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
