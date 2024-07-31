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
 * Servlet implementation class mangerSelect
 */
@WebServlet("/mangerSelect")
public class mangerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mangerSelect() {
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
		user user=new user();
		List<game> games=new ArrayList<game>();
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		try {
			String select=request.getParameter("select");
			
			
			con=DriverManager.getConnection(url,username,code);
			String statement1="select * from game where name like ?";
			PreparedStatement st1 =con.prepareStatement(statement1);
			st1.setString(1, "%"+select+"%");
			ResultSet rs1=st1.executeQuery();
			while(rs1.next()) {
				game game=new game(rs1.getString("name"),rs1.getString("date"),rs1.getString("intro"),rs1.getString("image"));
				games.add(game);
			}
			
			
			String statement2="select * from game where date like ?";
			PreparedStatement st2 =con.prepareStatement(statement2);
			st2.setString(1, "%"+select+"%");
			ResultSet rs2=st2.executeQuery();
			
			if(!select.equals("")) {
			while(rs2.next()) {
				game game=new game(rs2.getString("name"),rs2.getString("date"),rs2.getString("intro"),rs2.getString("image"));
				games.add(game);
			}
			}
			
			String statement3="select * from user where name= \""+request.getParameter("username")+"\"";
			PreparedStatement st3 =con.prepareStatement(statement3);
			ResultSet rs3=st3.executeQuery();
			while(rs3.next()) {
				user=new user(rs3.getString("name"),rs3.getString("code"),rs3.getString("isManger"));
			}
			System.out.println(statement3);

			System.out.println("连接成功");
			st1.close();
			st2.close();
			st3.close();
			rs1.close();
			rs2.close();
			rs3.close();
			con.close();
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("连接失败");
		}
		request.setAttribute("games",games);
		request.setAttribute("user",user);
		if(request.getParameter("main").equals("main"))request.getRequestDispatcher("mainPage.jsp").forward(request, response);
		if(request.getParameter("main").equals("manger"))request.getRequestDispatcher("manger.jsp").forward(request, response);
	}

}
