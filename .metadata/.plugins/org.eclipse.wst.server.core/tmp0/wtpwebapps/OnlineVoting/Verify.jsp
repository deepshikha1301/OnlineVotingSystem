<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%! String name, password; %>
    <% 
       name = request.getParameter("username");
       password = request.getParameter("password");
       if(name.equals("deepshikha")&& password.equals("1234"))
               {%>
                 <jsp:forward page="Profile.jsp"></jsp:forward>
                 <%}else { %>
                 Wrong username or password!!
                 <jsp:include page="Login.jsp"></jsp:include>
                 <%} %>
  
</body>
</html>