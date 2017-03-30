<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Member"%>
<%
List list=(List)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*6;
int over=(number+1)*6;
int count=pageNumber-over;
if(count<=0){
  over=pageNumber;
  }
%>
 <script Language="JavaScript">
 function deleteMember(date) {
  if(confirm("Are you sure to delete？")){
    window.location="memberAction.do?action=4&id="+date;
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
            <td><div align="center"><strong>Member Information</strong></div></td>
          </tr>
        </table>
        <br>
				 
	    <table width="71%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">

	    <tr>
          <td width="14%" height="25"><div align="center">ID</div></td>
          <td width="14%"><div align="center">User&nbsp;Name</div></td>
          <td width="14%"><div align="center">First&nbsp;Name</div></td>
           <td width="14%"><div align="center">Last&nbsp;Name</div></td>

    <td width="38%"><div align="center">Operation</div></td>
        </tr>
        <%for(int i=start;i<over;i++){
      Member form=(Member)list.get(i);
          %>
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center"><%=form.getId()%></div></td>
          <td><div align="center"><%=form.getUserName()%></div></td>
          <td><div align="center"><%=form.getFirstName()%></div></td>
          <td><div align="center"><%=form.getLastName()%></div></td>
        <td><div align="center">

		 <a href="memberAction.do?action=3&id=<%=form.getId()%>">Detail Information</a>&nbsp;&nbsp;&nbsp;&nbsp;

		 <a href="javascript:deleteMember('<%=form.getId()%>')">Delete</a>

		  </div></td>
        </tr>
        <%}%>
      </table><br>
	   <table width="71%"  border="0" align="center" cellpadding="0" cellspacing="0">
   <tr align="center">
    <td width="17%"><%=maxPage%> Page in total</td>
			<td width="22%"><%=pageNumber%> Items</td>
            <td width="26%">Page<%=number+1%></td>
    <td width="19%"><%if((number+1)==1){%> Pre<%}else{%><a href="memberAction.do?action=2&i=<%=number-1%>">Pre</a></td><%}%>
            <td width="16%"><%if(maxPage<=(number+1)){%>Next<%}else{%><a href="memberAction.do?action=2&i=<%=number+1%>">Next</a></td><%}%>



   </tr>
 </table>
		
	</table>	
<jsp:include page="bg-down.jsp" flush="true" />




</body>
</html>
