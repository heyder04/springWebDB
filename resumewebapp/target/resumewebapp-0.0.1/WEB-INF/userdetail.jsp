<%-- 
    Document   : Users
    Created on : Oct 1, 2023, 4:35:03 PM
    Author     : HP
--%>

<%@page import="com.company.entity.User"%>
<%@page import="com.company.dao.impl.UserDaoImpl"%>
<%@page import="com.mycompany.dao.inter.UserDaoInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%

        User u=(User) request.getAttribute("user");
       %>
       <div>
        <form action="userdetail" method="post">

        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%=u.getId()%>">

        <label for="name">Name:</label>
        <input type="text" name="name" value="<%=u.getName()%>">
        <br>
        <label for="surname">Surname:</label>
        <input type="text" name="surname" value="<%=u.getSurname()%>">
        <br>
        <input name="action" type="submit" value="update">
       
        </form>
       </div>

    </body>
</html>
