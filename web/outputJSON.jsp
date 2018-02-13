<%--
  Created by IntelliJ IDEA.
  User: espinajohn
  Date: 13/02/2018
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Paths" %>
<%
        String fileName = (String) request.getAttribute("file");
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        out.write(content.toCharArray());


%>





</body>
</html>
