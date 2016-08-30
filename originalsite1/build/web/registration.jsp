<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserData udb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udb = (UserData)hs.getAttribute("udb");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録ページ</title>
    </head>
    <body>
        <form action="RegistrationConfirm" method="POST">
            ユーザー名 ：<input type="text" name="txtname" value="<% if(reinput){out.print(udb.getName());}%>"required><br>
            パスワード ：<input type="password" minlength="4" maxlength="8" name="txtPass" value="<% if(reinput){out.print(udb.getPass());}%>" required><br>
            年齢       ：<select name="selage" required>
                            <option value=""></option>
                            <% for(int i = 1; i<=120; i++){ %>
                            <option value="<%=i%>"<% if(reinput && udb.getAge() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
                            <% } %>
                        </select>歳<br>   
            性別       ：   <input type="radio" name="radiosex" value="男性" required> 男性
                            <input type="radio" name="radiosex" value="女性" required>女性<br>
            身長       ：<input type="number" name="numhgt" step="1" value="<% if(reinput){out.print(udb.getHeight());}%>" required>cm<br>               
        <input type="submit" value="登録">
        </form>
    </body>
    <%=jh.home()%>
</html>
