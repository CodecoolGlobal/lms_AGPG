package com.codecool.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTextPage
 */
@WebServlet("/addtextpage")
public class AddTextPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTextPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
        Connection conn=null;
        String url="jdbc:postgresql://localhost:5432/";
        String dbName="db";
        String driver="com.postgresql.jdbc.Driver";
        
        try{  
            String textPageTitle = request.getParameter("textpage_title");  
            String textPageValue = request.getParameter("textpage_value");  
            Calendar calendar = Calendar.getInstance();
            java.sql.Date javaDateObject = new java.sql.Date(calendar.getTime().getTime());

            Class.forName(driver);  
            conn = DriverManager.getConnection(url+dbName,"postgres", "admin");
            PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into 'db'.'textpage'(textpage_title, textpage_value, date_created) values(?,?,?)");//try2 is the name of the table  

            pst.setString(1,textPageTitle);  
            pst.setString(2,textPageValue);        
            pst.setDate(3,javaDateObject);



            int i = pst.executeUpdate();
            String msg=" ";
            if(i!=0){  
              msg="Record has been inserted";
              pw.println("<font size='6' color=blue>" + msg + "</font>");  


            }  
            else{  
              msg="failed to insert the data";
              pw.println("<font size='6' color=blue>" + msg + "</font>");
             }  
            pst.close();
          }  
          catch (Exception e){  
            pw.println(e);  
          }  
	}

}
