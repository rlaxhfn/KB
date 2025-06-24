<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h1>login</h1>
<form name='f' action='/security/login' method='POST'>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<%--    <input type="hidden" name="_csrf" value="d5bab99f-8a5d-46ad-990e-8b5504bce41b"/>--%>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'>
                <input name="submit" type="submit" value="Login" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>