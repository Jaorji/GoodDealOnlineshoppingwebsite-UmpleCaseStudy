<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.ji.Entity.Type"%>
<jsp:useBean id="big" scope="page" class="com.ji.DAO.TypeDao"/>
<%List bigList=(List)big.selectBig();%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<table  height="25"  border="0" cellpadding="0" cellspacing="0" align="center">
   <tr>
     <td  align="center">
     <%for(int i=0;i<bigList.size();i++){
       Type bigForm=(Type)bigList.get(i);
     %>
     <a href="goodsAction.do?action=12&big=<%=bigForm.getId()%>"><%=bigForm.getName()%></a>&nbsp;&nbsp;
     <%}%>
	 </td>
   </tr>
</table>
