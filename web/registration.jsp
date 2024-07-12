<%-- 
    Document   : registration
    Created on : Jul 12, 2024, 10:06:19 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <a href="login.jsp">Login Page</a>
        <h1>User Registration</h1>
        <form method="post" action="RegisterServlet" onsubmit="return checkPassword()">
            <ul>
                <li>Name:-<br><input type="text" name="fullname" placeholder="Enter Your Name..." required></li>
                <li>Email:-<br><input type="text" name="email" placeholder="Enter Your Email..." required></li>
                <li>Username:-<br><input type="text" name="username" placeholder="Enter Your Username..." required></li>
                <li>Password:-<br><input type="password" id="password" name="password" placeholder="Enter Password..." required></li>
                <li>Confirm Password:-<br><input type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password..." required></li>
            </ul>
            <input type="submit" value="Confirm Registration">
            <input type="reset" value="Reset">
        </form>
        <p>${message}</p>
    </body>
    <script>
        function checkPassword() {
            var password = document.getElementById("password").value;
            var confirmpassword = document.getElementById("confirmpassword").value;

            if (password !== confirmpassword) {
                alert("Password and Confirm Password do not match");
                return false;
            }

            return true;
        }
    </script>
</html>
