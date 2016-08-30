<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udb = (UserData)hs.getAttribute("udb2");   
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>体重入力ページ</title>
    </head>
    <body>
        <a href="Mypage">マイページ</a>　　<a href="Login">ログアウト</a>
        <br><br>
        <form action="RecordConfirm" method="POST">
            体重：       <input type="number" name="numwt" step="1" value="<% if(reinput){out.print(udb.getWeight());}%>" required>kg<br>
            カロリー：   <input type="number" name="numcal" step="1" value="<% if(reinput){out.print(udb.getCalorie());}%>" required>kcal<br>
        <input type="submit" value="確認">
        </form>
    </body>
    <%=jh.home()%>
</html>
    </body>
</html>

