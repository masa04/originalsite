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
        <title>データ入力＆情報</title>
    </head>
    <body>
        <h2><script>
        //今日の日付データを変数hidukeに格納
        var hiduke=new Date(); 

        //年・月・日・曜日を取得する
        var year = hiduke.getFullYear();
        var month = hiduke.getMonth()+1;
        var week = hiduke.getDay();
        var day = hiduke.getDate();

        var yobi= new Array("日","月","火","水","木","金","土");

        document.write(year+"年"+month+"月"+day+"日 "+yobi[week]+"曜日");
        </script></h2>
        
        <h1><%=udb.getName()%>さんのマイページ(体重&カロリー)</h1>
        <h3><a href="Login">ログアウト</a></h3>
        
        <h3>データ入力＆情報</h3>
        <h3><a href="SerchWeight">体重体重&カロリー表示</a><br><br>
        <div style="display:inline-flex">
        <form action="Record" method="POST">
            <input type="submit" name="record" value="入力">
   　　 </form>   
        <form action="ChangeRecord" method="POST">
            <input type="submit" name="changerecord" value="変更">
   　　 </form>
        </div><br><br>
    </body>
    <%=jh.home()%>
</html>
