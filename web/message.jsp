<%--
  Created by IntelliJ IDEA.
  User: espinajohn
  Date: 12/02/2018
  Time: 7:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Loading Data from a Static JSON String - fusioncharts.com</title>
    <script src="/FusionCharts/fusioncharts.js"></script>
</head>
<body>
<div id="chart"></div>
<%@page import="fusioncharts.FusionCharts" %>
<%@ page import="java.io.File" %>
<%@ page import="jdk.nashorn.internal.parser.JSONParser" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page import="java.nio.file.Paths" %>
<%

    // access the json file stored somewhere
    File file = (File)request.getAttribute("file");

    // Parse the file into a string
    String jsonString = new String(Files.readAllBytes(Paths.get(file.getPath())), Charset.defaultCharset());

    // Create the chart
    FusionCharts columnChart= new FusionCharts(
            // chartType
            "column2d",
            // chartId
            "chart1",
            // chartWidth, chartHeight
            "600","400",
            // chartContainer
            "chart",
            // dataFormat
            // either json string or jsonURL
            //if using jsonURL, then the json file hast to be hosted somewhere
            //if using json string, then hson file will have to be parsed into Java String
            "json",
            jsonString);%>

// Render the chart using the FusionCharts JavaScript
<%=columnChart.render()%>

</body>
</html>








<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>

    <%--<title>Upload</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>${requestScope.message}</h2>--%>
<%--<p>We will insert the graph here! Maybe :)</p>--%>
<%--</body>--%>
<%--</html>--%>
