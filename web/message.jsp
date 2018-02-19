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
    <link rel="stylesheet" href="CSS/chart.css">

</head>
<body>
<div id="chart"></div>
<%@page import="fusioncharts.FusionCharts" %>
<%@ page import="java.io.File" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.util.HashMap" %>

<%
    // access the json file stored somewhere
    HashMap <String, String> fileToProcess = (HashMap) request.getAttribute("file");

    String symmetryPath = fileToProcess.get("symmetry");
    String errorPath = fileToProcess.get("error");

    File symmetry = new File (symmetryPath);
    File error = new File (errorPath);

    System.out.println("SYMMETRY: " + symmetryPath);
    System.out.println("ERROR: " + errorPath);

    // Parse the file into a string
    String jsonStringSymmetry = new String(Files.readAllBytes(Paths.get(symmetry.getPath())), Charset.defaultCharset());
    String jsonStringError = new String(Files.readAllBytes(Paths.get(error.getPath())), Charset.defaultCharset());

    // Create the chart
    FusionCharts symmetryChart = new FusionCharts(

            /// chartType
            "zoomline",
            // chartId
            "chart1",
            // chartWidth, chartHeight
            "600","400",
            // chartContainer
            "chart",
            // dataFormat
            "json",
            //data source
            jsonStringSymmetry);%>

<br>
<br>
<div id="symmetryChart">
    <%=symmetryChart.render()%>
</div>

<%
    // Create the chart
    FusionCharts errorChart= new FusionCharts(

            /// chartType
            "zoomline",
            // chartId
            "chart1",
            // chartWidth, chartHeight
            "1800","1200",
            // chartContainer
            "chart",
            // dataFormat
            "json",
            //data source
            jsonStringError);%>

Where is the chart??????????
<div id="errorChart">
    <%=errorChart.render()%>
</div>


</body>
</html>