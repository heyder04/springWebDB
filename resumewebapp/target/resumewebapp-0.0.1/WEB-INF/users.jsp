
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script rel="script" src="assets/js/users.js"></script>
    <title>JSP Page</title>
</head>
<body>
<%--       <%="Welcome,"+user.getName()%>--%>
<div class="container " >
    <div  class="col-4">
        <form class="form-group" action="users" value="GET">
            <label for="name">Name:</label>
            <input class="form-control" type="text" name="name" value="">
            <br>
            <label for="surname">Surname:</label>
            <input class="form-control" type="text" name="surname" value="">
            <br>
            <input class="btn btn-primary" type="submit" value="search" name="search">
        </form>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.getName()}</td>
                <td>${u.getSurname()}</td>
                <td>${u.getNationality().getName()==null?"N/A":u.getNationality().getName()}</td>
                <td>

                    <input type="hidden" name="id" value="${u.getId()}">
                    <input type="hidden" name="action" value="delete">
                    <button onclick="getId('${u.getId()}')" class="btn  btn-danger" type="submit" value="delete"  data-toggle="modal" data-target="#exampleModal">

                        <i class="fa-solid fa-trash"></i>
                    </button>
                </td><td>
                <form action="userdetail" method="get">
                    <input type="hidden" name="id"   value="${u.getId()}">
                    <input type="hidden" name="action" value="update">
                    <button class="btn btn-primary" type="submit" value="update" >
                        <i class="fa-solid fa-pen-to-square"></i>

                    </button>
                </form>
            </td>
            </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="post">
                    <input type="hidden" name="id" value="" id="idForDelete">
                    <input type="hidden" name="action" value="delete">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input  type="submit" class="btn btn-danger" value="Delete">
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
