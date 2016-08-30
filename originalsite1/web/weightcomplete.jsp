<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.*"%>
<%@page import="jums.UserDataDTO"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = (UserData)hs.getAttribute("user");
    ArrayList<UserDataDTO> rdb =(ArrayList<UserDataDTO>)hs.getAttribute("rdb");
    double bmi = (double)request.getAttribute("bmi");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>詳細ページ</title>
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
 
        <h3>ログイン情報</h3>
        <table border=1>
            体重＆カロリー
            <% for (int i = 0 ; i< rdb.size(); i++ ){%>
            <tr>
                <td><%= rdb.get(i).getWeight()%></a></td>
                <td><%= rdb.get(i).getCalorie()%></td><%}%>
            </tr>
        </table><br>
            BMI　　:   
            <%=bmi%><br><br>
    </body>
    <%=jh.home()%>
</html>