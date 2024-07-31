package GameBack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeCode
 */
@WebServlet("/ChangeCode")
public class ChangeCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCode() {
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
		Connection con=null;
		String name= request.getParameter("name");
		String oldcode= request.getParameter("code");
		String newcode= request.getParameter("newcode");
		String isWrong="true";
		String statement="update user set code= ? where name=  ? and code=? ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		
		try {
			con=DriverManager.getConnection(url,username,code);	
			System.out.println("连接成功");
			}catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接失败");
			}
		
		try {
			String statement2="select * from user where name=\""+name+"\" and code=\""+oldcode+"\"";
			PreparedStatement st2 =con.prepareStatement(statement2);
			ResultSet rs2=st2.executeQuery();
			while(rs2.next()){
				isWrong="false";
			}
			PreparedStatement st =con.prepareStatement(statement);
			st.setString(1, newcode);
			st.setString(2, name);
			st.setString(3, oldcode);
			st.executeUpdate();
		} catch (SQLException e) {
			isWrong="true";
			System.out.println(newcode);
			System.out.println(name);
			System.out.println(oldcode);
		}
		
		
		request.setAttribute("isWrong", isWrong);
		request.getRequestDispatcher("changeCode.jsp").forward(request, response);
	}

}