<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html"%>
<%@page import="chart.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Chart.jsp</h1>
        <jsp:useBean id="chart" class="chart.BarChart2"/>
        <img src="<%= System.getProperty("java.io.tmpdir") + "/" + chart.getName() %>" alt="test image" usemap="#test" border="0"/>
    </body>
</html>
