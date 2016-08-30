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
        <title>mydateページ</title>
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
        
        <h1><%=udb.getName()%>さんのマイページ</h1>
        <h3><a href="Login">ログアウト</a></h3>
    </body>
    　　<h3>ログイン情報</h3>
        ユーザー名    ：<%= udb.getName()%><br>
        パスワード    ：********<br>
        年齢          ：<%= udb.getAge()%><br>
        性別          ：<%= udb.getSex()%><br>
        身長          ：<%= udb.getHeight()%><br>
        <br>
        <div style="display:inline-flex">
        <form action="Update" method="POST">
            <input type="submit" name="update" value="変更">
   　　 </form>   
        <form action="Delete" method="POST">
            <input type="submit" name="delete" value="削除">
   　　 </form>
        </div>
   　　 <br><br>
      <h3><a href="RecordInfo">データ入力＆情報</a></h3>
    </body>
    <%=jh.home()%>
</html>
