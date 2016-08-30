package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import net.tanesha.recaptcha.ReCaptcha;
//import net.tanesha.recaptcha.ReCaptchaFactory;
//import net.tanesha.recaptcha.ReCaptchaImpl;
//import net.tanesha.recaptcha.ReCaptchaResponse;

public class LoginResult extends HttpServlet {

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
        
         request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        
        try {
                //入力内容をUDBに格納と入力パラメータ―をセッションとして保持
                UserData udb = new UserData();
                udb.setName(request.getParameter("txtname"));
                udb.setPass(request.getParameter("txtPass"));
                session.setAttribute("user", udb);
                
                //未入力があった場合ならログインはエラー文に飛ぶ
                if(udb.getName()==null || udb.getPass()==null){
                    request.setAttribute("er", "error");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }else{
                
                //DTOオブジェクトにマッピング。DB専用のパラメータに変換する処理
                UserDataDTO searchData = new UserDataDTO();
                udb.UD2DTOMapping(searchData);   
                System.out.print(udb.getName());
                    
                //該当したアカウントデータをDTOに格納
                UserDataDTO loginData = UserDataDAO .getInstance().search(searchData);
                udb.UD2BeansMapping(loginData);
               
                    //deleteFlgが１だった場合の処理
                    if(udb.getDeleteFlg()==1){
                        request.setAttribute("er", "error");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }else{
                   
                        //入力内容が何にも該当しなかった場合の処理
                        if(loginData.getName()==null){
                            request.setAttribute("er", "error");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                        }else{
                        
                            //ログイン成功時、mydateへ飛ぶ！
                            Log l = new Log();
                            l.Logs((String)session.getAttribute("mypageに遷移"));
                            request.getRequestDispatcher("/mypage.jsp").forward(request, response);
                        }
                    }
                }           
        } catch(Exception e){
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