<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = (UserData)hs.getAttribute("user");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新ページ</title>
    </head>
    <body>
        <a href="Login">ログアウト</a>
        <br>
        <form action="UpdateResult" method="POST">
            ユーザー名： <input type="text" name="txtname" value="<%= udb.getName()%>" required=""><br>
            パスワード： <input type="password" name="txtPass" value="<%= udb.getPass()%>" required=""><br>
            年齢：       <select name="selage" required="">
                            <option value=""></option>
                            <% for(int i = 1; i<=120; i++){ %>
                            <option value="<%=i%>" <% if(udb.getAge() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
                            <% } %>
                        </select>歳<br>
            身長：      <input type="number" name="numhgt" step="1" value="<%= udb.getHeight()%>" required>cm<br> 
        <input type="submit" value="変更">
        </form>
    </body>
    <%=jh.home()%>
</html>
