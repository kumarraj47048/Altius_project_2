import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{

		PrintWriter out = response.getWriter();

		String name = "";

		// request object will return an array of cookies
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			out.println(
				"<h1> You are a new user, kindly login. </h1>");
			request.getRequestDispatcher("login.html")
				.include(request, response);
			// Above statement includes login.html for the
			// user to re-login if username or password is
			// invalid.
		}
		else {
			for (Cookie c : cookies) {
				String tempName
					= c.getName(); // For every cookie, add
								// cookie name to the
								// tempName.
			
				if (tempName.equals("username"))
				// If tempName and username (that we had set
				// in the cookie c in GFGLoginServlet) are
				// same, then this is an already logged in
				// user and the request is not from a new
				// user. So let the user access profile page.

				{
					name = c.getValue(); // From the (name,
										// value) pair of
										// cookie, fetch
										// value
					out.println(
						"<a href='LogoutServlet' style='font-size:25px;'>Logout </a>");
					out.println(
						"<h1>Welcome to your profile, "
						+ name);
				}
			}
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
