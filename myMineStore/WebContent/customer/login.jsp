<%@ page language="java" pageEncoding="GBK"%>
<%@page contentType="text/html;charset=GBK"%>
<%
	request.setCharacterEncoding("GBK");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link rel="stylesheet" type="text/css" href="../css/daohang.css">
		<script type="text/javascript">
function reloadcode(){
var verify=document.getElementById('safecode');
verify.setAttribute('src','image.jsp?'+Math.random());
}

function check2(){
	var userName2=document.form2.userName.value;
	var userPassword2=document.form2.userPassword.value;

	if(userName2==""){
		alert("�������û���!");
		form2.userName2.focus();
		return false;
	}
	
	if(userPassword2==""){
		alert("����������!");
		form2.userPassword2.focus();
		return false;
	}
	return true;
}
   </script>
	</head>
<body>
<div id="tabs5"
			style="position: absolute; top: 1%; left: 15%; height: 8%; width: 71%">
			<ul>
				<li>
					<a href=./customerRegister.jsp><span>�˿�ע��</span>
					</a>
				</li>

				<li>
					<a href=./../index.jsp><span>������ҳ</span>
					</a>
				</li>
			</ul>
		</div>
		<br>
		<div id="tabs5"
			style="position: absolute; top: 9%; left: 15%; height: 80%; width: 71%">
			<center>
				<h1>
					�û���½
				</h1>
				<form name="form2" action="../CustomerLoginCtrl" method="post"
					onsubmit="return check2()">
					<table border="0"" >
						<tr>
							<td>
								�û���:
							</td>
							<td>
								<input type="text" name="customerName">
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								��&nbsp;&nbsp;��:
							</td>
							<td>
								<input type="password" name="customerPass">
							</td>
						</tr>
						
							<td colspan="2" align="center">
								<input type="submit" name="submit" value="��¼">
								<input type="reset" name="reset" value="����" />
						</tr>
					</table>
				</form>
			</center>
		</div>
</body>
</html>