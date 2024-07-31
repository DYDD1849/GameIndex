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
 * Servlet implementation class manger
 */
@WebServlet("/manger")
public class manger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manger() {
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
		response.setCharacterEncoding("UTF-8");
		List<game> games=new ArrayList<game>();
		user user=new user();
		String path="";
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		
		try {
			String name;
			String statement1="select * from user ";
			String statement2="select * from game";
			path=(String) request.getAttribute("path");
			System.out.println("path="+path);
			if(request.getParameter("username")!=null&&!request.getParameter("username").equals(""))
				name=request.getParameter("username");
			else name=(String) request.getAttribute("username");
			con=DriverManager.getConnection(url,username,code);
			statement1=statement1+" where name=\""+name+"\";";
			PreparedStatement st1 =con.prepareStatement(statement1);
			PreparedStatement st2 =con.prepareStatement(statement2);
			ResultSet rs1=st1.executeQuery();
			ResultSet rs2=st2.executeQuery();
			System.out.println("连接成功");
			if(rs1.next())
			user=new user(rs1.getString("name"),rs1.getString("code"),rs1.getString("isManger"));
			while(rs2.next()) {
			game game=new game(rs2.getString("name"),rs2.getString("date"),rs2.getString("intro"),rs2.getString("image"));
			games.add(game);
			System.out.println("读取成功");}
			rs1.close();
			rs2.close();
			st1.close();
			st2.close();
			con.close();
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("连接失败");
		}
		request.setAttribute("games", games);
		request.setAttribute("user", user);
		request.setAttribute("path", path);
		request.getRequestDispatcher("manger.jsp").forward(request, response);
	}

}
