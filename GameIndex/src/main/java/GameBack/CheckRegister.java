package GameBack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class check
 */
@WebServlet("/CheckRegister")
public class CheckRegister extends HttpServlet {
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckRegister() {
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
		String statement="select name from user ";
		String sname= request.getParameter("name");
		String isRepeat="false";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("驱动加载失败");
		}
		try {
			Connection con=DriverManager.getConnection(url,username,code);
			PreparedStatement st =con.prepareStatement(statement);
			ResultSet rs=st.executeQuery();

			while(rs.next())
			{
				if(sname.equals(rs.getString("name"))){
					isRepeat="true";
				}
			}
			if(!isRepeat.equals("true")) {
			String 	statement2="insert into user value(?,?,?);";
				PreparedStatement st2=con.prepareStatement(statement2);
				st2.setString(1,sname);
				st2.setString(2,request.getParameter("code"));
				st2.setString(3,"false");
				st2.executeUpdate();
				st2.close();
			}
			System.out.println("连接成功");
				rs.close();
				st.close();
				con.close();
		}catch (Exception e) {
		e.printStackTrace();
		System.out.println("连接失败");
		}
		request.setAttribute("isRepeat", isRepeat);
		request.getRequestDispatcher("doRegister.jsp").forward(request, response);
	}

}
