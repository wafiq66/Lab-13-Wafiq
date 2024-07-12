<%-- 
    Document   : login
    Created on : Jul 12, 2024, 4:27:25 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Using MVC-DAO</h1>
        <form action="LoginServlet" method="post">
            <table>
                <tr>
                    <td>Username:-</td>
                    <td><input type="text" name="username"></td>
                <tr>
                <tr>
                    <td>Password:-</td>
                    <td><input type="password" name="password"></td>
                <tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"><input type="reset" value="Reset"></td>
                <tr>
            </table>
            <p>${message}</p>
        </form>
        
    </body>
</html>
