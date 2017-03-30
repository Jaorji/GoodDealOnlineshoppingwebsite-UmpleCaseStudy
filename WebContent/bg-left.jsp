<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
  <script Language="JavaScript">
 function quit() {
  if(confirm("Log out£¿")){
    window.location.href="loginOut.jsp";
	}
  }
 </script>
 
 
 
 
 <%com.ji.Entity.Manager manager=(com.ji.Entity.Manager)session.getAttribute("manager"); %>
<table width="35" height="22" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="image/bg_left1.jpg" width="170" height="45"></td>
      </tr>
    </table>
      <table width="170" height="46" border="0" cellpadding="0" cellspacing="0" background="image/bg_left2.jpg">
        <tr>
          <td><table width="118" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="118" height="17" align="center" valign="bottom"><div align="left"><a href="goodsAction.do?action=0" class="a3">Goods Manage</a></div></td>
            </tr>
          </table></td>
        </tr>
      </table>
      <table width="170" height="46" border="0" cellpadding="0" cellspacing="0" background="image/bg_left2.jpg">
        <tr>
          <td><table width="118" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="109" height="17" align="center" valign="bottom"><div align="left"><a href="memberAction.do?action=2" class="a3">Member Manage</a></div></td>
              </tr>
          </table></td>
        </tr>
      </table>
      <table width="170" height="46" border="0" cellpadding="0" cellspacing="0" background="image/bg_left2.jpg">
        <tr>
          <td><table width="118" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="109" height="17" align="center" valign="bottom"><div align="left"><a href="bigTypeAction.do?action=0" class="a3">Type Manage</a></div></td>
              </tr>
          </table></td>
        </tr>
      </table>
      <table width="170" height="46" border="0" cellpadding="0" cellspacing="0" background="image/bg_left2.jpg">
        <tr>
          <td><table width="118" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="109" height="17" align="center" valign="bottom"><div align="left"><a href="smallTypeAction.do?action=0" class="a3">Brand Manage</a></div></td>
              </tr>
          </table></td>
        </tr>
      </table>
      
      <%if(manager.getIfAdmin()==1){%>        
      <table width="170" height="46" border="0" cellpadding="0" cellspacing="0" background="image/bg_left2.jpg">
        <tr>
          <td><div align="left">
            <table width="118" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="127" height="17" align="center" valign="bottom"><div align="left"><a href="managerAction.do?action=1" class="a3">Admin Manage</a></div></td>
                </tr>
             </table>
          </div></td>
        </tr>
      </table>
      <%}else{%>
       <table width="170" height="46" border="0" cellpadding="0" cellspacing="0" background="image/bg_left2.jpg">
        <tr>
          <td><div align="left">
            <table width="118" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="127" height="17" align="center" valign="bottom"><div align="left"><a href="bg-managerUpdatePassword.jsp" class="a3">Admin Password</a></div></td>
                </tr>
             </table>
          </div></td>
        </tr>
      </table>      
      <%}%>
      
      
      
      
      
      
      
      <table width="170" height="46" border="0" cellpadding="0" cellspacing="0" background="image/bg_left2.jpg">
        <tr>
          <td><table width="118" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="127" height="17" align="center" valign="bottom"><div align="left"><a href="orderAction.do?action=0" class="a3">Order Manage</a></div></td>
              </tr>
          </table></td>
        </tr>
      </table>
      <table width="170" height="47" border="0" cellpadding="0" cellspacing="0" background="image/bg_left03.jpg">
        <tr>
          <td><table width="118" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="127" height="17" align="center" valign="bottom"><div align="left"><a href="javascript:quit()" class="a3">Log Out</a></div></td>
              </tr>
          </table></td>
        </tr>
      </table>
      <table width="37" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="image/bg_left04.jpg" width="170" height="68"></td>
        </tr>
      </table>