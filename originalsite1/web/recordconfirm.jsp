<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = (UserData)hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties2();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認</title>
    </head>
    <body>
        <% if(chkList.size()==0){ %>
        体重    　　：<%=udb.getWeight()%><br>
        カロリー    ：<%=udb.getCalorie()%><br>
        上記の内容で登録いたします。よろしいですか？
        <form action="RecordComplete" method="POST">
        <input type="submit" name="YES" value="はい">
    </form>
    <form action="Record" method="POST">
        <input type="hidden" name="mode" value="REINPUT">
        <input type="submit" name="NO" value="いいえ">
    </form>
        <%}else{%>
         <%=jh.chkinput2(chkList)%><br>
        <form action="Record" method="POST">
            <input type="hidden" name="mode" value="REINPUT">
            <input type="submit" name="NO" value="入力画面に戻る">
    </form>
        <%}%>
    </body>
    <%=jh.home()%>
</html>