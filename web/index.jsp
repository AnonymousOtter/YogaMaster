<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>File Upload</title>
    <link rel="stylesheet" href="CSS/uploadPage.css">
</head>
<body>
<center>
    <h1>Yoga Symmetry Analyser</h1>


        <form method="post" action="UploadServlet" id="uploadBtn"
          enctype="multipart/form-data">
        Upload .csf file
            <input type="file" name="file" size="6000" /><br />
        <br /> <input type="submit" value="Analyse" />
        </form>


</center>
</body>
</html>