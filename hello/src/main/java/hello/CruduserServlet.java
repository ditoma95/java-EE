package hello;
import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class CruduserServlet
 */
//@WebServlet("/CruduserServlet")
@WebServlet({"/formulaire", "/show"})
public class CruduserServlet extends HttpServlet {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataresource");                                                                
	EntityManager entityManager = emf.createEntityManager();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CruduserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Role> roles = null;
		roles = entityManager.createNativeQuery("(select * from roles) except (select roles.* from roles, users_roles where roles.id_role = users_roles.roles_id_role)", Role.class).getResultList();
		request.setAttribute("Listesroles",  roles);
		
		this.getServletContext().getRequestDispatcher("/formulaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String motdepasse = request.getParameter("password");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String username = request.getParameter("username");
		
		String[] roles = request.getParameterValues("roles");
		List<Role> rol = new ArrayList();
		Long id;
		if(roles !=null) {
			for(String id_role : roles) {
				id = Long.parseLong(id_role);
				Role role = new Role(id);
				rol.add(role);
			}
		}
		
		
		User user = new User(nom, prenom, motdepasse, email, contact, username);
		user.setRoles(rol);
		
		entityManager.getTransaction().begin();
		boolean transactionOk = false;
		try {
		    entityManager.persist(user);
		    transactionOk = true;
		}
		finally {
		    if(transactionOk) {
		        entityManager.getTransaction().commit();
		    }
		    else {
		        entityManager.getTransaction().rollback();
		    }
		}

//		List<User> users = null;
//		users = entityManager.createNativeQuery("select * from users", User.class).getResultList();
//		request.setAttribute("ListesUers", users);
//		this.getServletContext().getRequestDispatcher("/").forward(request, response);
		response.sendRedirect("/hello");
		
	}
}

































