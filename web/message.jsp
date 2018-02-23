<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Upload</title>
    <script src="/FusionCharts/fusioncharts.js"></script>
    <link rel="stylesheet" href="CSS/chart.css">
</head>
<body>
<h2>Result of Symmetry Analysis:</h2>

<div id="chart1"></div>

<%@page import="fusioncharts.FusionCharts" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.File" %>

<%
    // access the json file stored somewhere
    HashMap <String, String> fileToProcess = (HashMap) request.getAttribute("file");

    String symmetry = fileToProcess.get("symmetry");
    String error = fileToProcess.get("error");


// Create the chart
    FusionCharts symmetryChart = new FusionCharts(

            // chartType
            "zoomline",
            // chartId
            "symmetryChart",
            // chartWidth, chartHeight
            "600","400",
            // chartContainer
            "chart1",
            // dataFormat
            "json",
            symmetry);
%>
<%=symmetryChart.render()%>

<br>
<br>
<br>

<div id="chart2"></div>
<%
    // Create the chart
    FusionCharts errorChart= new FusionCharts(

            /// chartType
            "zoomline",
            // chartId
            "errorChart",
            // chartWidth, chartHeight
            "600","400",
            // chartContainer
            "chart2",
            // dataFormat
            "json",
            //data source
            error);%>

<%=errorChart.render()%>


</body>
</html>
