package GameBack;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class send
 */
@WebServlet("/send")
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection con=null;
		LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String nowtime = now.format(formatter);  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		
		try {
			String statement1="insert into liuyan value(?,?,?,?)";
			con=DriverManager.getConnection(url,username,code);
			PreparedStatement st1 =con.prepareStatement(statement1);
			st1.setString(1, request.getParameter("username"));
			st1.setString(2,nowtime);
			st1.setString(3,request.getParameter("liuyan"));
			st1.setString(4,request.getParameter("gamename"));
			st1.executeUpdate();
			System.out.println("连接成功");
			st1.close();
			con.close();
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("连接失败");
		}
		String usernamesend = request.getParameter("username");
		String gamename = request.getParameter("gamename");
		String gametime = request.getParameter("date");
		System.out.println(gametime);
		String encodedUsername = URLEncoder.encode(usernamesend, "UTF-8");
		String encodedGamename = URLEncoder.encode(gamename, "UTF-8");
		response.sendRedirect("gameIndex?username=" + encodedUsername + "&gamename=" + encodedGamename+"&gametime="+gametime);
	}

}
