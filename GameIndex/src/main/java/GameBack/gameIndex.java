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
 * Servlet implementation class gameIndex
 */
@WebServlet("/gameIndex")
public class gameIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gameIndex() {
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
		List<liuyan> liuyans=new ArrayList<liuyan>();
		Connection con=null;
		
		user user=new user();
		game game =new game();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		
		try {
			String statement1="select * from user ";
			String statement2="select * from game ";
			String statement3="select * from liuyan where gamename = ";
			con=DriverManager.getConnection(url,username,code);
			statement1=statement1+" where name=\""+request.getParameter("username")+"\";";
			statement2=statement2+" where name=\""+request.getParameter("gamename")+"\" and date=\""+request.getParameter("gametime")+"\";";
			statement3=statement3+"\""+request.getParameter("gamename")+"\"";
			System.out.println(statement3);
			PreparedStatement st1 =con.prepareStatement(statement1);
			PreparedStatement st2 =con.prepareStatement(statement2);
			PreparedStatement st3 =con.prepareStatement(statement3);
			ResultSet rs1=st1.executeQuery();
			ResultSet rs2=st2.executeQuery();
			ResultSet rs3=st3.executeQuery();
			System.out.println("连接成功");
			if(rs1.next())
			user=new user(rs1.getString("name"),rs1.getString("code"),rs1.getString("isManger"));
			if(rs2.next())
			game=new game(rs2.getString("name"),rs2.getString("date"),rs2.getString("intro"),rs2.getString("image"));
			System.out.println("查询成功");
			while(rs3.next()){
			liuyan liuyan=new liuyan(rs3.getString("liuyanRen"),rs3.getString("liuyantime"),rs3.getString("gamename"),rs3.getString("liuyan"));
			liuyans.add(liuyan);
			System.out.println("查询成功");
			}
			System.out.println("查询成功");
			rs1.close();
			rs2.close();
			st1.close();
			st2.close();
			con.close();
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("连接失败");
		}
		request.setAttribute("game", game);
		request.setAttribute("user", user);
		request.setAttribute("liuyans", liuyans);
		request.getRequestDispatcher("gameindex.jsp").forward(request, response);
		}
	}

