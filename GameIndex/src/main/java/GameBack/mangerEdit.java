package GameBack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mangerEdit
 */
@MultipartConfig
@WebServlet("/mangerEdit")
public class mangerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  String username=Mysqlconstant.USER_NAME;
	private static  String url=Mysqlconstant.URL;
	private static  String code=Mysqlconstant.CODE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mangerEdit() {
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
			String statement1="update game set  ";
			//String path="C:\\daima\\Eclipse\\GameIndex\\src\\main\\webapp\\gameImg\\";
			ServletContext context = getServletContext();
			String path=context.getRealPath("/gameImg");
			statement1=statement1+"name = \""+request.getParameter("name")+" \"";
			statement1=statement1+" , date = \""+request.getParameter("date")+" \"";
			statement1=statement1+", intro =\" "+request.getParameter("intro")+"\" ";
			System.out.println(request.getPart("image").getSubmittedFileName());
			if(request.getPart("image")!=null&&!request.getPart("image").getSubmittedFileName().equals("")) {
				statement1=statement1+", image = \""+request.getPart("image").getSubmittedFileName()+"\"";
				request.getPart("image").write(path+"/"+request.getPart("image").getSubmittedFileName());
			}
			statement1 = statement1 + " where name = ? and date = ?";
			System.out.println(statement1);
			con=DriverManager.getConnection(url,username,code);
			PreparedStatement st1 =con.prepareStatement(statement1);
			st1.setString(1, request.getParameter("oldname"));
			st1.setString(2,request.getParameter("olddate"));
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
