<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserData udb = (UserData)request.getAttribute("udb");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録画面</title>
    </head>
    <body>
        <a href="Mypage">マイページ</a>　　<a href="Login">ログアウト</a>
        <h1>登録結果</h1><br>
        体重    　　：<%= udb.getWeight()%><br>
        カロリー    ：<%= udb.getCalorie()%><br>
        以上の内容で登録しました。<br>
    </body>
    <%=jh.home()%>
</html>
