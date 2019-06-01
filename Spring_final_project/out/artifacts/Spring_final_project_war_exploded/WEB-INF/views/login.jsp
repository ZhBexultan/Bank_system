<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Войти</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="resources/login/images/bank.jpg"/>
    <link rel="stylesheet" type="text/css" href="resources/login/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resources/login/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="resources/login/css/main.css">
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="resources/login/images/bank.jpg" alt="IMG">
            </div>

            <form class="login100-form validate-form" action="login" method="post">
					<span class="login100-form-title">
						Авторизация
					</span>

                <div class="wrap-input100 validate-input"
                     data-validate="Введите действующий логин. Например: ex@abc.xyz">
                    <input class="input100" type="text" name="login_parameter" placeholder="Логин" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Введите пароль объязательно!">
                    <input class="input100" type="password" name="password_parameter" placeholder="Пароль" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="container-login100-form-btn">
                    <input type="submit" class="login100-form-btn" value="Войти в систему">
                </div>

            </form>
        </div>
    </div>
</div>


<script src="resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/login/vendor/tilt/tilt.jquery.min.js"></script>

</body>
</html>