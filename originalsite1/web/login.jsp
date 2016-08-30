<%@page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
   // ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfI2CQTAAAAALpR3Lvg-QDZir1mZEcfPDG03UEc", "y6LfI2CQTAAAAAAAapuqrqhY8JW08Ll-6cLXn8rHz", false);
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
        <body>
        <%if(request.getAttribute("er") != null){%>
        <h1>ログインに失敗しました。</h1>
        <%out.print(request.getAttribute("er"));}%>
    <form action="LoginResult" method="GET">
       <!--out.print(c.createRecaptchaHtml(null, null)); --> 
        ユーザー名：<input type="text" name="txtname"><br>
        パスワード：<input type="password" name="txtPass"><br>
        <input type="submit" value="ログイン" />
    </form>    
        <a href="Registration">新規会員登録</a><br>
    </body>
        <%=jh.home()%>
</html>
