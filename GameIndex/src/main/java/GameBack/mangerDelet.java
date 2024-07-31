package GameBack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mangerDelet
 */
@WebServlet("/mangerDelet")
public class mangerDelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mangerDelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		
		try {
			String statement1="delete from game where name=? and date= ?";
			con=DriverManager.getConnection(url,username,code);
			PreparedStatement st1 =con.prepareStatement(statement1);
			st1.setString(1, request.getParameter("gamename"));
			st1.setString(2,request.getParameter("gamedate"));
			st1.executeUpdate();
			System.out.println("连接成功");
			st1.close();
			con.close();
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("连接失败");
		}
		request.setAttribute("username", "username");
		request.getRequestDispatcher("manger").forward(request, response);
	}

}
