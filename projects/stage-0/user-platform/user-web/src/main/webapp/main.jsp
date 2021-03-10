<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<jsp:directive.include
	file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
<title>My Home Page</title>
</head>
<body>
	<div class="container-lg">
		注册成功！
		<table cellpadding="3" cellspacing="0" >
			<tr><td>id</td>
				<td>名称</td>
				<td>email</td>
				<td>电话号码</td>
			</tr>
			<c:forEach items="${users}" var="user">

			<tr><td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.phoneNumber}</td>
			</tr>

			</c:forEach>
	</div>
</body>