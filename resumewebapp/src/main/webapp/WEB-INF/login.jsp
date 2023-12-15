<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 17-Nov-23
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
  <link rel="stylesheet" href="assets/css/users.css?v=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
 <form action="login" method="POST">
   <div class="col-4 container login_fix ">
     <h1 style="text-align: center">Login</h1>
     <div class="form-group">
       <label>Email address</label>
       <input type="email" class="form-control" placeholder="Username" name="username">
     </div>
     <div class="form-group">
       <label>Password</label>
       <input type="password" class="form-control" placeholder="Password" name="password">
     </div>
     <br>
     <button type="submit" class="btn btn-primary" name="login">Login</button>
   </div>

 </form>
</body>
</html>
