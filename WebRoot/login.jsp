<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>index.jsp</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="resources/js/jquery-1.12.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#sub").bind("click",function(){
			var admins=[{
				username:"obje1",
				password:"obje1"
			},{
				username:"obje2",
				password:"obje2",
			}];
			var param={
				username:"obje1",
				password:"obje1"
			};
// 			var param1={
// 				username:"obje2",
// 				password:"obje2",
// 			};
// 			admins.push(param);
// 			admins.push(param1);
			var obj={
				 "username":"1321313",
				 "password":"456466",
				 "lists":[{"id":1,"username":"222"},{"id":2,"username":"231"}]
				 };
			var param1={
				 "username":"tttt",
// 				 "admin.username":"1321313",
// 				 "admin.password":"456466"
				 admin:JSON.stringify(obj)
			};
			$.ajax({
				url:"${ctx}/admin/login",
				type:"post",
				dataType:"json",
//  			contentType:"application/json",  
// 				data:$("#form1").serialize(),
				data:param1,
// 				data:param,
				success:function(data){
// 					alert(data.username);
				}
			});
// 			$("form").submit();
		});
	});
		
	</script>
</head>

<body>
	<form action="${ctx}/admin/login" method="post" id="form1">
		<label> 用户名： </label> <input type="text" name="username" id="username"><br>
		<label> 密码： </label> <input type="password" name="password"
			id="password"><br> <label> 邮箱： </label> <input
			type="text" name="email" id="email"><br> <input id="sub"
			type="button" value="登陆">
	</form>
</body>
</html>
