package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SerchWeight extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       //セッションスタート
        HttpSession session = request.getSession();
        
        try{
            //ユーザーのデータをUDBに格納
            UserData udb = (UserData)session.getAttribute("user");
            UserData rdb = new UserData();
            rdb.setUserID(udb.getUserID());
                    
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO recordData = new UserDataDTO();
            rdb.UD2DTOMapping(recordData);    
 
            //DBからデータを持ってきてセッションに格納
            ArrayList<UserDataDTO> recordlist = UserDataDAO .getInstance().recordsearch(recordData);
            rdb.UD2BeansMapping(recordData);
            session.setAttribute("rdb", recordlist);
            
            //計算用の数値のUDBを作成
            UserData calbean = new UserData();
            calbean.setUserID(udb.getUserID());
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO calData = new UserDataDTO();
            calbean.UD2DTOMapping(calData); 
            
             //DBからデータを持ってくる
            UserDataDTO callist = UserDataDAO .getInstance().bmical(calData);
            
            //BMI数値の計算
            double bmi;
            bmi = callist.getWeight()/((udb.getHeight()/100)*(udb.getHeight()/100));
            request.setAttribute("bmi",bmi);
            
            //結果画面での表示用に入力パラメータ―をリクエストパラメータとして保持
            System.out.print("rdb");
            Log l = new Log();
            l.Logs("体重詳細");
            l.Logs("weightcompleteに遷移");
            request.getRequestDispatcher("/weightcomplete.jsp").forward(request, response);
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
