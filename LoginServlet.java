// Java Program to Illustrate Login in Servlets

// Importing required classes
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation
@WebServlet("/LoginServlet")

// Class
// Extending HttpServlet class
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{

		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html")
			.include(request,
					response); // This statement includes
								// link.html in this servlet

		String name = request.getParameter("user_name");
		String password = request.getParameter("password");

		if (password.equals("kumar")) {
			out.println(
				"<h1>Welcome " + name
				+ ", you have successfully logged in!</h1>");
			// creating cookie
			Cookie c = new Cookie("username", name);
			// attaching cookie to response object
			response.addCookie(c);
		}
		else {
			out.println(
				"Sorry invalid username or password!");
			request.getRequestDispatcher("login.html")
				.include(request, response);
			// Above statement includes login.html for the
			// user to re-login if username or password is
			// invalid.
		}
	}

	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
