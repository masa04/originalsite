package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.time.TimeSeriesCollection;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import org.jfree.chart.ChartPanel;

public class test3 extends HttpServlet {
public static void main(String[] args) {
    test3 frame = new test3();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 500, 500);
    frame.setTitle("グラフサンプル");
    frame.setVisible(true);
  }

  test3(){
    TimeSeriesCollection data = new TimeSeriesCollection();
    JFreeChart chart = 
      ChartFactory.createTimeSeriesChart("PV推移",
                                  "月",
                                  "PV",
                                  data,
                                  true,
                                  false,
                                  false);

    ChartPanel cpanel = new ChartPanel(chart);
    getContentPane().add(cpanel, BorderLayout.CENTER);
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
