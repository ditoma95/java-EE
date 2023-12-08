package hello;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AffichageTableServlet
 */
@WebServlet("/")
public class AffichageTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataresource");                                                                
	EntityManager entityManager = emf.createEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> users = null;
		users = entityManager.createNativeQuery("select * from users", User.class).getResultList();
		request.setAttribute("ListesUers", users);
		
		
		
		this.getServletContext().getRequestDispatcher("/show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
