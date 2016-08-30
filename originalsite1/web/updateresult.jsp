<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = (UserData)hs.getAttribute("user");
    UserData udb2 = (UserData)request.getAttribute("udb2");
    ArrayList<String> chkList = udb2.chkproperties();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新結果</title>
    </head>
    <body>
        <br>
        <% if(chkList.size()==0){ %>
        ユーザー名　　：<%=udb.getName()%><br>
        パスワード　　：<%=udb.getPass()%><br>
        歳　　　　　　：<%=udb.getAge()%><br>
        身長　　　　　：<%=udb.getHeight()%><br>
        以上の内容で更新しました。<br><br>
       
        <%}else{%>
        <%=jh.chkinput(chkList) %><br>
        <form action="Mydata" method="POST">
        <input type="submit" name="NO" value="入力画面に戻る">
      <%}%>
        </form>
    </body>
    <%=jh.home()%>
</html>
