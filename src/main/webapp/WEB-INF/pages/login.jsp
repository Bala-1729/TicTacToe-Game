<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="shortcut icon" href="<c:url value="/resources/favicon.ico" />" type="image/x-icon" />
    <link href="<c:url value="/resources/login.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/login.js" />" defer> </script>
</head>
<body id="body" style="display: none;" onload="load_login()">
    <h1 class="heading">TicTacToe</h1>
    <div class="swap">
        <div class="button_after" id="login_button" onclick="login()"><strong>Login</strong></div>
        <div class="button_before" id="register_button" onclick="register()"><strong>Register</strong></div>
    </div>
    <div id="form" class="login_form">
        <form>
            <div>
                <p style="font-size:x-large;">Welcome</p>
            </div>
            <div class="register">
                <label for="firstname">Firstname:</label>
                <input type="text" id="fname" name="fname" placeholder="Type you firstname" required/><br/>
            </div>
            <div class="register">
                <label for="lastname">Lastname:</label>
                <input type="text" id="lname" name="lname" placeholder="Type you lastname" required/><br/>
            </div>
            <div class="login">
                <label for="username">Username:</label>
                <input type="text" id="uname" name="uname" placeholder="Type you username" required/><br/>
            </div>
            <div class="register">
                <label for="email">E-mail-ID:</label>
                <input type="text" id="email" name="email" placeholder="Type you email address" required/><br/>
            </div>
            <div class="login">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Type you password" required/><br/>
            </div>
            <div class="submitButton">
                <button type="button" id="submitButton" style="padding: 6px 14px;border-radius: 4px;">Submit</button>   
            </div>
        </form>
    </div>
</body>
</html>