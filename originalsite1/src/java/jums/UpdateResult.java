package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateResult extends HttpServlet {

/**
 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
 * methods.
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    HttpSession session = request.getSession();

    try {
        //ログインチェック
        if(session.getAttribute("user") == null){
            throw new Exception("不正なアクセスです");
        }

        //フォームからの入力を取得して、JavaBeansに格納
        UserData udb2 = new UserData();
        udb2.setName(request.getParameter("txtname"));
        udb2.setPass(request.getParameter("txtPass"));
        udb2.setAge(request.getParameter("selage"));
        udb2.setHeight(request.getParameter("numhgt"));
        request.setAttribute("udb2", udb2);

        //未入力がないかチェックする
        ArrayList<String> chkList = udb2.chkproperties();

        if(chkList.size() == 0){
            UserDataDTO Update = new UserDataDTO();
            UserData udb = (UserData)session.getAttribute("user");

            //入力された情報をDTOに入れてUPDATEする
            udb.UD2DTOMapping(Update);
            udb2.UD2DTOMapping(Update);
            UserDataDAO .getInstance().update(Update);

            //更新したものをUserDataBeansに逆マッピングする
            udb.UD2BeansMapping(Update);
           
            Log l = new Log();
            l.Logs("updateresultに遷移");
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
        }
    }catch(Exception e){
        //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
        request.setAttribute("error", e.getMessage());
        request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}

/**
 * Handles the HTTP <code>POST</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
public String getServletInfo() {
    return "Short description";
}// </editor-fold>

}
