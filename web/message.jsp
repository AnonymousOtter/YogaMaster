<%--
  Created by IntelliJ IDEA.
  User: espinajohn
  Date: 12/02/2018
  Time: 7:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Loading Data from a Static JSON String - fusioncharts.com</title>
    <script src="/FusionCharts/fusioncharts.js"></script>
</head>
<body>
<div id="chart"></div>
<%@page import="fusioncharts.FusionCharts" %>
<%
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
            "json",
            "{\"chart\": {  \"caption\": \"Monthly revenue for last year\",\"subCaption\": \"Harry’s SuperMart\",\"xAxisName\": \"Month\",\"yAxisName\": \"Revenues (In USD)\",\"numberPrefix\": \"$\",\"theme\": \"zune\"},\"data\": [{\"label\": \"Jan\",\"value\": \"420000\"}, {\"label\": \"Feb\",\"value\": \"810000\"}, {\"label\": \"Mar\",\"value\": \"720000\"}, {\"label\": \"Apr\",\"value\": \"550000\"}, {\"label\": \"May\",\"value\": \"910000\"}, {\"label\": \"Jun\",\"value\": \"510000\"}, {\"label\": \"Jul\",\"value\": \"680000\"}, {\"label\": \"Aug\",\"value\": \"620000\"}, {\"label\": \"Sep\",\"value\": \"610000\"}, {\"label\": \"Oct\",\"value\": \"490000\"}, {\"label\": \"Nov\",\"value\": \"900000\"}, {\"label\": \"Dec\",\"value\": \"730000\"}]}");
%>
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
