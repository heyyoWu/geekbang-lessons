<head>
<jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
	<title>Login Page</title>
    <style>
		.page {
			max-width: 500px;
		}
		.title {
			text-align: center;
			margin-top: 20px;
		}
		.password {
			margin-top: 10px;
		}
		.member {
			margin-top: 5px;
		}
    </style>
</head>
<body>
	<div class="container page">
		<form class="form-signin">
			<h1 class="h3 mb-3 font-weight-normal title">登录</h1>
			<label for="inputEmail" class="sr-only">请输出电子邮件</label>
			<input type="email" id="inputEmail" class="form-control" placeholder="请输入电子邮件" required autofocus>

			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control password" placeholder="请输入密码" required>

			<div class="checkbox mb-3 member">
				<label>
					<input type="checkbox" value="remember-me">&nbsp;Remember me
				</label>
			</div>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
		</form>
	</div>
</body>