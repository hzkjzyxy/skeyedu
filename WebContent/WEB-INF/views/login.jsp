<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span4">
		</div>
		<div class="span4">
			<form class="form-horizontal" action="login">
				<div class="control-group">
					 <label class="control-label" for="inputEmail">loginname:</label>
					<div class="controls">
						<input id="inputEmail" type="text" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">loginPwd:</label>
					<div class="controls">
						<input id="inputPassword" type="password" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						 <label class="checkbox"><input type="checkbox" /> remember me </label> <button type="submit" class="btn">login </button>
					</div>
				</div>
			</form>
			
			<!-- 切换语言 -->
			<a href="changeLocale?locale=zh_CN">中文</a>&nbsp;&nbsp;<a href="changeLocale?locale=en_US">english</a>
		</div>
		<div class="span4">
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</html>