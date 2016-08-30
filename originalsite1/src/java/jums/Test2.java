package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;

public class Test2 extends HttpServlet {

 public void start(Stage stage) {
         
     // 日本語が文字化けしないテーマ
    ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());    
        
        stage.setTitle("折れ線グラフ");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("月　日");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("○○さんの体重");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("体重");
        
        series1.getData().add(new XYChart.Data("Jan", 23));
        series1.getData().add(new XYChart.Data("Feb", 14));
        series1.getData().add(new XYChart.Data("Mar", 15));
        series1.getData().add(new XYChart.Data("Apr", 24));
        series1.getData().add(new XYChart.Data("May", 34));
        series1.getData().add(new XYChart.Data("Jun", 36));
        series1.getData().add(new XYChart.Data("Jul", 22));
        series1.getData().add(new XYChart.Data("Aug", 45));
        series1.getData().add(new XYChart.Data("Sep", 43));
        series1.getData().add(new XYChart.Data("Oct", 17));
        series1.getData().add(new XYChart.Data("Nov", 29));
        series1.getData().add(new XYChart.Data("Dec", 25));
        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1);
       
        stage.setScene(scene);
        stage.show();
    }
}