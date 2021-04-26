import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/mysql";

		String USER = "subashree";
		String PASS = "eightdav";


		PrintWriter out = response.getWriter();
		String age = request.getParameter("age");
		String id = request.getParameter("id");
		String address = request.getParameter("address");
		String status = request.getParameter("status");

		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "UPDATE Student_Details SET age=?, address=?, phone_number=? WHERE id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(age));
			pst.setString(2, address);
            pst.setString(3, status);
            pst.setInt(4, Integer.parseInt(id));


			pst.executeUpdate();
			pst.close();
			conn.close();
			
			out.println("<B> Record updated successfully</B><br>");

			RequestDispatcher rd = request.getRequestDispatcher("/view.html");
			rd.forward(request, response);
			
		} catch (SQLException sql) {
			sql.printStackTrace();
			out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
			out.println(e);
		}
	}
}