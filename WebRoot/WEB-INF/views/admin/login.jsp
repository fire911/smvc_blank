<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>橙市生活管理平台</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			var msg = {'name':'用户名不能为空', 'password':'密码不能为空', 'code':'验证码不能为空'};
			var currentCheckName = '';
			function login(){
				$('#errorMsg').hide();
				var username = $('#username').val();
				var password = $('#password').val();
				var verifycode = $('#verifycode').val();
				if(!username || username ===''){
					$('#verifyError p').text(msg['name']);
					$('#verifyError').fadeIn('normal');
					currentCheckName = 'username';
					$('#username').css('border-color', 'red');
					return false;
				}
				if(!password || password ===''){
					$('#verifyError p').text(msg['password']);
					$('#verifyError').fadeIn('normal');
					currentCheckName = 'password';
					$('#password').css('border-color', 'red');
					return false;
				}
				if(!verifycode || verifycode ===''){
					$('#verifyError p').text(msg['code']);
					$('#verifyError').fadeIn('normal');
					currentCheckName = 'verifycode';
					$('#verifycode').css('border-color', 'red');
					return false;
				}
				$("form").submit();
			}
			$('.login-button').click(login);
			$('#refreshCode').click(refreshCode);
			function refreshCode(){
				var codeUrl = "verifyCode?" + new Date().getTime();
				var img = $('#code').attr('src',codeUrl);
			}
			$('#verifycode').keydown(function(e){
				if(e.keyCode == 13){
					login();
				} 
			})
			
			$('.login-row input').keyup(function(){
				var val = $(this).val();
				if( val !== null && val !== ''){
					if($(this).attr('id') === currentCheckName){
						$('#verifyError').fadeOut('slow');
						$(this).css('border-color', '#d9d9d9');
					}
				}
			})
		});
	</script>
</head>
<body class="login-body">
<div class="login-header">
    <!-- <a href=""><img src="images/login_logo.png" width="230px" height="100px" /></a> -->
</div>
<form action="j_spring_security_check" method="post">
<div class="login-wrap">
    <div class="login-content">
        <div class="alert alert-danger" <c:if test="${errMsg == null }">style="display: none</c:if>" id="errorMsg"> 
            <p>登录失败：${errMsg}</p>
        </div>
         <div class="alert alert-danger" style="display: none" id="verifyError"> 
            <p></p>
        </div>
        <h1>橙市生活管理平台</h1>
        <div class="login-row">
            <label>用户名</label>
            <input type="text" class="login-yzm" name="j_username" id="username" />
        </div>
        <div class="login-row">
            <label>密码</label>
            <input type="password" class="login-yzm" name="j_password" id="password" />
        </div>
        <div class="login-row">
            <label>验证码</label>
            <input type="text" class="login-yzm" name="verifycode" id="verifycode" />
            <img id="code" src="verifyCode" class="login-yzmimg" style="vertical-align: middle;width: 100px;height: 40px" alt="验证码" title="验证码"/>
            <a id="refreshCode" href="#" title="点击更换验证码" >点击更换</a>
        </div>
        <div class="text-center">
            <button type="button" class="login-button">登 录</button>
        </div>
    </div>
</div>
</form>
</body>
</html>




