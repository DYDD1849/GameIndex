package GameBack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class check
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
	private static  String statement="select * from user ";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
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
		String sname= request.getParameter("name");
		String scode= request.getParameter("code");
		Connection con=null;
		String isRepeat="false";
		user user=new user();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		try {
			con=DriverManager.getConnection(url,username,code);
			PreparedStatement st =con.prepareStatement(statement);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				if(sname.equals(rs.getString("name"))&&scode.equals(rs.getString("code"))){
					isRepeat="true";
					user=new user(rs.getString("name"),rs.getString("code"),rs.getString("isManger"));
				}
			}
			if(isRepeat.equals("false")) {
				request.setAttribute("isRepeat", isRepeat);
				request.getRequestDispatcher("Index.jsp").forward(request, response);
			}
			System.out.println("连接成功");
				rs.close();
				st.close();

		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("连接失败");
		}
		if(!isRepeat.equals("false")) { 
		String satement3="select * from game";
		List<game> games=new ArrayList<game>();
		try {
		PreparedStatement st3=con.prepareStatement(satement3);
		ResultSet rs2=st3.executeQuery();
		while(rs2.next()) {
			game game=new game(rs2.getString("name"),rs2.getString("date"),rs2.getString("intro"),rs2.getString("image"));
			games.add(game);
		}
			st3.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("games", games);
		request.setAttribute("user", user);
		request.getRequestDispatcher("mainPage.jsp").forward(request, response);
		}
	}

}
