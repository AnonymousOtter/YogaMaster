<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Yoga Symmetry Analyser</title>
    <style type="text/css">
        .form-style-8{
            font-family: 'Open Sans Condensed', arial, sans;
            width: 500px;
            padding: 30px;
            background: #FFFFFF;
            margin: 50px auto;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
            -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
            -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);

        }
        .form-style-8 h2{
            background: #4D4D4D;
            text-transform: uppercase;
            font-family: 'Open Sans Condensed', sans-serif;
            color: #797979;
            font-size: 18px;
            font-weight: 100;
            padding: 20px;
            margin: -30px -30px 30px -30px;
        }
        .form-style-8 input[type="text"],
        .form-style-8 input[type="date"],
        .form-style-8 input[type="datetime"],
        .form-style-8 input[type="email"],
        .form-style-8 input[type="number"],
        .form-style-8 input[type="search"],
        .form-style-8 input[type="time"],
        .form-style-8 input[type="url"],
        .form-style-8 input[type="password"],
        .form-style-8 textarea,
        .form-style-8 select
        {
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            outline: none;
            display: block;
            width: 100%;
            padding: 7px;
            border: none;
            border-bottom: 1px solid #ddd;
            background: transparent;
            margin-bottom: 10px;
            font: 16px Arial, Helvetica, sans-serif;
            height: 45px;
        }
        .form-style-8 textarea{
            resize:none;
            overflow: hidden;
        }
        .form-style-8 input[type="button"],
        .form-style-8 input[type="file"],
        .form-style-8 input[type="submit"]{
            -moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;
            -webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;
            box-shadow: inset 0px 1px 0px 0px #45D6D6;
            background-color: #2CBBBB;
            border: 1px solid #27A0A0;
            display: inline-block;
            cursor: pointer;
            color: #FFFFFF;
            font-family: 'Open Sans Condensed', sans-serif;
            font-size: 14px;
            padding: 8px 18px;
            text-decoration: none;
            text-transform: uppercase;
        }
        .form-style-8 input[type="button"]:hover,
        .form-style-8 input[type="submit"]:hover {
            background:linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);
            background-color:#34CACA;
        }
    </style>
</head>
<body>

<script>
    function showGreenTick(){
        var img = document.getElementById("image");
        img.src="Images/greenTick.png";
        return false;
    }
    function showGreenTick1(){
        var img = document.getElementById("image1");
        img.src="Images/greenTick.png";
        return false;
    }
    function showAlert(){

    }

    function adjust_textarea(h) {
        h.style.height = "20px";
        h.style.height = (h.scrollHeight)+"px";
    }
</script>

<div class="form-style-8">
    <h1>Yoga Symmetry Analyser</h1>

    <form method="post" action="/UploadServlet"
          enctype="multipart/form-data">
        <input style=" display: none; overflow: hidden; content:'Select some files';" type="file" id="myFileInput" name="file" onClick="showGreenTick()"/>
        <input style="width: 400px; height: 50px" type="button" onclick="document.getElementById('myFileInput').click()" value="Select a File" />
        <img style="margin-top: 60px; margin-left:30px" id="image" src="Images/redCross.png" width="50dp" height="50dp">
        <br>
        <input style="width: 400px; height: 50px" type="submit" value="Upload" onClick="showGreenTick1()">
        <img style="margin-top: 30px; margin-left:30px" id="image1" src="Images/redCross.png" width="50dp" height="50dp">
    </form>
</div>




</body>
</html>

<%--<form method="post" action="UploadServlet" enctype="multipart/form-data">--%>
<%--Please select a file: <input type="file"  onclick="document.getElementById('demo').innerHTML = Date()" name="file" size="6000" /><br />--%>
<%--<br /> <input type="submit" value="Upload" />--%>
<%--</form>--%>