<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除完了</title>
    </head>
    <body>
        <a href="Login?p=top">ログイン</a><br>
        <h1>削除しました</h1><br>
    </body>
    <%=jh.home()%>
</html>
