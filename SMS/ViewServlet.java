import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ViewServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/mysql";

		String USER = "subashree";
		String PASS = "eightdav";


		PrintWriter out = response.getWriter();

		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Student_Details";
			Statement pst = conn.createStatement();

            ResultSet rs = pst.executeQuery(sql);
            out.println("<!DOCTYPE html>");
            out.println("<html><head></head>");
            out.println("<body style='font-size: 16pt; background: rgb(10,11,41); background: radial-gradient(circle, #301b3f 20%, #000 69%); ; color: white;'>");
                
            out.println("<h1 style='font-size: 25pt; text-align: center; color: white;'>Student Records</h1>");
            out.println("<table style='border: 2px solid white; width:100%; border-collapse: collapse; text-align: center;'>");
            out.println("<tr style='border: 2px solid white;'><th style='border: 1px solid white;'>Name</th><th style='border: 1px solid white;'>Age</th><th style='border: 1px solid white;'>Register Number</th><th style='border: 1px solid white;'>Gender</th><th style='border: 1px solid white;'>Address</th><th style='border: 1px solid white;'>Contact Number</th><th style='border: 1px solid white;'>Date of Birth</th></tr>");
            while (rs.next()) {
                response.setContentType("text/html");
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String status = rs.getString("phone_number");
                String dov = rs.getString("date_of_birth");

                out.println("<tr style='border: 1px solid white;'><td style='border: 1px solid white;'>" + name + "</td><td style='border: 1px solid white;'>" + age + "</td><td style='border: 1px solid white;'>" + id + "</td><td style='border: 1px solid white;'>" + gender
                        + "</td><td style='border: 1px solid white;'>" + address + "</td><td style='border: 1px solid white;'>" + status + "</td><td style='border: 1px solid white;'>" + dov + "</td></tr>");
            }
            
			pst.close();
            conn.close();
            
			
		} catch (SQLException sql) {
			sql.printStackTrace();
			out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
			out.println(e);
		}
	}
}
