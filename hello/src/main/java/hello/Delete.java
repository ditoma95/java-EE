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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete/*")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataresource");                                                                
	EntityManager entityManager = emf.createEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataresource");
		  EntityManager entityManager = emf.createEntityManager();
	
		  User user = null;
		  String userId = request.getPathInfo().substring(1);
		  

		if (userId != null && !userId.isEmpty()) {
		    long yourUserId = Long.parseLong(userId);
		    user =  entityManager.find(User.class, yourUserId);
		}
		System.out.println(user);
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		
		List<User> users = null;
		users = entityManager.createNativeQuery("SELECT * FROM users", User.class).getResultList();
		request.setAttribute("users",users);
		this.getServletContext().getRequestDispatcher("/").forward(request, response);
	}

}
