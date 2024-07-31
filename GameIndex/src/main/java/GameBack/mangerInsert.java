package GameBack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.Context;
import javax.servlet.ServletContext;
/**
 * Servlet implementation class mangerInsert
 */
@MultipartConfig
@WebServlet("/mangerInsert")
public class mangerInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mangerInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Connection con=null;
		String path="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		
		try {
			String statement1="insert into game value(?,?,?,?)";
			ServletContext context = getServletContext();
			path=context.getRealPath("/gameImg");
			System.out.print("path");
			//String path="C:\\daima\\WEB\\JSP\\tomcat\\webapps\\GameIndex\\gameImg";
			request.getPart("image").write(path+"/"+request.getPart("image").getSubmittedFileName());
			con=DriverManager.getConnection(url,username,code);
			PreparedStatement st1 =con.prepareStatement(statement1);
			st1.setString(1, request.getParameter("name"));
			st1.setString(2,request.getParameter("date"));
			st1.setString(3,request.getParameter("intro"));
			st1.setString(4,request.getPart("image").getSubmittedFileName());
			st1.executeUpdate();
			System.out.println("连接成功");
			st1.close();
			con.close();
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("连接失败");
		}
		request.setAttribute("username", "username");
		request.setAttribute("path", path);
		request.getRequestDispatcher("manger").forward(request, response);
	}

}
