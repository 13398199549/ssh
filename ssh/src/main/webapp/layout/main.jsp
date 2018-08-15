<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="static/js/jQuery-2.2.2-min.js?version=20180726" charset="utf-8"></script>
<script type="text/javascript"
	src="static/js/jquery.json.js?version=20180726" charset="utf-8"></script>
<script type="text/javascript"
	src="static/js/main.view.js?version=20180726" charset="utf-8"></script>

</head>
<body>

	<button id="btn01">完成用户新增</button>
	<button id="btn02">完成用户删除</button>
	<button id="btn03">完成用户修改</button>
	<button id="btn04">根据ID完成用户查询</button>
	<button id="btn05">根据用户名和登录名查询用户</button>
	<button id="btn06">根据用户名完成分页查询</button>

	<p />
	
	<fieldset>
		<legend>修改用户</legend>
		<form action="users/form" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="hidden" name="id" value="6" /> <input type="hidden"
			name="version" value="0" /> 
		用户名：<input type="text" name="userName" />
		<br /> 
		登录名：<input type="text" name="loginName" /> 
		<br /> 
		<input type="submit" value="保存"/>
	</form>
		
	</fieldset>
	
	
<p />
	
	<fieldset>
		<legend>删除用户</legend>
		<form action="users/form" method="post">
		<input type="hidden" name="_method" value="DELETE" /> 
		<input type="hidden" name="id" value="6" /> 
		<input type="hidden" name="version" value="1" /> 
		<br /> 
		<input type="submit" value="保存"/>
	</form>
		
	</fieldset>
	








</body>
</html>