package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.StarBean;
/**
 * Servlet implementation class StarServlet
 */
@WebServlet("/StarServlet")
public class StarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String star = request.getParameter("star");
		
		if(star == null || star.length() == 0) {
			request.setAttribute("message", "星座を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}



		StarBean s = new StarBean(star);

		request.setAttribute("star", s);
		RequestDispatcher rd = request.getRequestDispatcher("/StarShow.jsp");
		rd.forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
