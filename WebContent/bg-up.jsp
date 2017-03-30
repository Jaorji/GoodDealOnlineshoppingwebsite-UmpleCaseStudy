<%@ page contentType="text/html; charset=gb2312"%>
<jsp:useBean id="countTime" class="com.ji.tool.CountTime" scope="request"/>
<%@ page import="com.ji.Entity.Manager"%>
<%
if(session.getAttribute("manager")==null){
out.print("<script language=javascript>alert('Please sign in again£¡');window.location.href='bg-land.jsp';</script>");
}else{
Manager manager=(Manager)session.getAttribute("manager");
%>
<table width="788" height="66" border="0" align="center" cellpadding="0" cellspacing="0" background="image/bg_01.jpg">
  <tr>
    <td valign="top"><table width="770" border="0" align="center">
      <tr >
        <td width="413" height="53" valign="bottom"><div align="right"></div></td>
        <td width="347" valign="bottom" align="right"><font color="#FFFFFF"><a href="goodsAction.do?action=0" class="a2">Goods Management</a> | <a href="bigTypeAction.do?action=0" class="a2">Type Management</a> | <a href="smallTypeAction.do?action=0" class="a2">Brand Management</a> | <a href="orderAction.do?action=0" class="a2">Home</a></font></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#000000">
  <tr>
    <td width="15" height="25">&nbsp;</td>
    <td width="579"><font color="#FFFFFF">Welcome£º<%=manager.getAccountName()%></font></td>
    <td width="194"><font color="#FFFFFF">Today is <%=countTime.currentlyTime()%></font></td>
  </tr>
</table>
<%}%>