<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>File Upload</title>
</head>
<body>
<center>
    <h1>File Upload</h1>
    <form method="post" action="UploadServlet"
          enctype="multipart/form-data">
        Select file to upload: <input type="file" name="file" size="6000" /><br />
        <br /> <input type="submit" value="Upload" />
    </form>
</center>
</body>
</html>