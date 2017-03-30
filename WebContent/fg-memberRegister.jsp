<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>GoodDeal</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function checkEmpty(memberForm) {
		for (i = 0; i < memberForm.length-1; i++) {
			if (memberForm.elements[i].value == "") {
				alert("can not be empty!"+ i);
				return false;
			}
		}
		if (document.memberForm.password.value != document.memberForm.passwordOne.value) {
			window.alert("Passwords are not the same!");
			return false;
		}

	}
</script>
<body>
	<jsp:include page="fg-top.jsp" flush="true" />
	<table width="766" border="0" align="center" cellpadding="0"
		cellspacing="0" bordercolor="#000000">
		<tr>
			<td bgcolor="#F5F5F5" align="center"><img src="image/fg1.jpg"
				width="752" height="39"> <html:form
					action="memberAction.do?action=0"
					onsubmit="return checkEmpty(memberForm)">
					

					<table width="270" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="107" height="35">
								<div align="right">First&nbsp;Name：</div>
							</td>
							<td width="163">
								<div align="left">
								<input name="firstName" type = "text">
								</div>
							</td>
						</tr>
						<tr>
							<td width="107" height="35">
								<div align="right">Last&nbsp;Name：</div>
							</td>
							<td width="163">
								<div align="left">
									<input name="lastName" type = "text">
								</div>
							</td>
						</tr>
						<tr>
							<td width="107" height="35">
								<div align="right">Birthday：</div>
							</td>
							<td width="163">
								<div align="left">
								<input name="birthday" type = "date">
									
								</div>
							</td>
						</tr>
						
						<tr>
							<td height="35">
								<div align="right">Email&nbsp;Address：</div>
							</td>
							<td>
								<div align="left">
								<input name="emailAddress" type = "text">
									
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">Password：</div>
							</td>
							<td>
								<div align="left">
								<input name="password" type = "password">
									
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">Password&nbsp;Confirm：</div>
							</td>
							<td>
								<div align="left">
								
									<input type="password" name="passwordOne">
								</div>
							</td>
						</tr>
						<tr>
							<td width="107" height="35">
								<div align="right">User&nbsp;Name：</div>
							</td>
							<td width="163">
								<div align="left">
								<input name="userName" type = "text">
									
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">Profession：</div>
							</td>
							<td>
								<div align="left">
								<input name="profession" type = "text">
									
								</div>
							</td>
						</tr>

						<tr>
							<td height="35">
								<div align="right">Qestion：</div>
							</td>
							<td>
								<div align="left">
								<input name="question" type = "text">
									
								</div>
							</td>
						</tr>
						<tr>
							<td height="35">
								<div align="right">Answer：</div>
							</td>
							<td>
								<div align="left">
								<input name="answer" type = "text">
									
								</div>
							</td>
						</tr>
					</table>
					<br>
					
					<input type="image" class="input1" width="51"
						height="20" src="image/save.jpg">
&nbsp;&nbsp;
<a type="reset" href="#" onClick="javascript:memberForm.reset()"><img src="image/clear01.gif"/></a>
&nbsp;&nbsp;
<a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back01.gif"/></a>
				</html:form>
				<p>&nbsp;</p></td>
		</tr>
	</table>
	<jsp:include page="fg-down.jsp" flush="true" />
</body>
</html:html>
