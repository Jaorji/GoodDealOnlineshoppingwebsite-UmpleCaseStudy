<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Manager"%>
<%
List list=(List)request.getAttribute("list");
Manager manager=(Manager)session.getAttribute("manager");
int ifAdmin=manager.getIfAdmin();
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*7;
int over=(number+1)*7;
int count=pageNumber-over;
if(count<=0){
  over=pageNumber;
  }
%>
 <script Language="JavaScript">
 function deleteManager(date) {
  if(confirm("Delete Manager？")){
    window.location="managerAction.do?action=4&id="+date;
	}
  }
 </script>
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
            <td><div align="center"><strong>Manager Information</strong></div></td>
          </tr>
        </table>
        <br>
	 <table width="90%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
          <td width="20%" height="20" colspan="4"><div align="right"><a href="bg-managerUpdatePassword.jsp">Change Password</a>&nbsp;&nbsp;&nbsp;</div></td>
        <tr>
      </table>
	    <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">    
	    <tr>
          <td width="20%" height="25"><div align="center">ID</div></td>
          <td width="20%"><div align="center">First Name</div></td>
          <td width="20%"><div align="center">Last Name</div></td>
            <td width="20%"><div align="center">Account Name</div></td>
              <td width="20%"><div align="center">Birthday</div></td>
                <td width="20%"><div align="center">Email Address</div></td>
          <td width="44%"><div align="center">Operation</div></td>
        </tr>
        <%for(int i=start;i<over;i++){
          Manager form=(Manager)list.get(i);
          %>
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center"><%=form.getId()%></div></td>
          <td><div align="center"><%=form.getFirstName()%></div></td>
          <td><div align="center"><%=form.getLastName()%></div></td>
           <td><div align="center"><%=form.getAccountName()%></div></td>
            <td><div align="center"><%=form.getBirthday()%></div></td>
             <td><div align="center"><%=form.getEmailAddress()%></div></td>
          <td><div align="center">
          <%if(form.getIfAdmin()!=1){ %>
         <a href="javascript:deleteManager('<%=form.getId()%>')">Delete</a>
          <% }else
{%>Delete<%}%>
          </div></td>
        </tr>
		<%}%>   
      </table><br>
	   <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
   <tr align="center">
    <td width="13%"><%=maxPage%> Page in Total</td>
			<td width="16%"><%=pageNumber%> Items</td>
            <td width="14%">Page <%=number+1%></td>
    <td width="19%"><%if((number+1)==1){%> Pre<%}else{%><a href="managerAction.do?action=1&i=<%=number-1%>">Pre</a></td><%}%>
            <td width="18%"><%if(maxPage<=(number+1)){%>Next<%}else{%><a href="managerAction.do?action=1&i=<%=number+1%>">Next</a></td><%}%>
     <%if(ifAdmin==1){%>
			<td width="20%">	
			  <div align="right"><img src="image/bg-add.gif" width="9" height="9"><a href="bg-managerInsert.jsp">&nbsp;Add Manager&nbsp;</a></div></td>
			
	</td><%}else{%><%}%>

   </tr>
 </table>  
 
 <%
if(request.getAttribute("reslut")!=null){
%>
<P align="center"><%=request.getAttribute("reslut")%></P>
<%}%>	
 
 
 
 		
</table>		
<jsp:include page="bg-down.jsp" flush="true" />
</body>
</html>
