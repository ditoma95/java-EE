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
 * Servlet implementation class editServlet
 */
@WebServlet("/edit/*")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataresource");                                                                
	EntityManager entityManager = emf.createEntityManager();
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		String userId = request.getPathInfo().substring(1);
		if (userId != null && !userId.isEmpty()) {
		    long yourUserId = Long.parseLong(userId);
		    user =  entityManager.find(User.class, yourUserId);
		}
		request.setAttribute("user", user);
		
		List<Role> roles = null;
		roles = entityManager.createNativeQuery("(select * from roles) except (select roles.* from roles, users_roles where roles.id_role = users_roles.roles_id_role)", Role.class).getResultList();
		request.setAttribute("Listesroles",  roles);
		
		this.getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataresource");
		  EntityManager entityManager = emf.createEntityManager();
	
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
			
		  User user = null;
		  String userId = request.getPathInfo().substring(1);
		  

		if (userId != null && !userId.isEmpty()) {
		    long yourUserId = Long.parseLong(userId);
		    user =  entityManager.find(User.class, yourUserId);
		}
		System.out.println(user);
		entityManager.getTransaction().begin();
		//entityManager.merge(user);
		user.setNom(request.getParameter("nom"));
		user.setNom(request.getParameter("prenom"));
        user.setEmail(request.getParameter("email"));
        user.setMotdepasse(request.getParameter("password"));
        user.setContact(request.getParameter("contact"));
        user.setRoles(rol);
		entityManager.getTransaction().commit();
		
		List<User> users = null;
		users = entityManager.createNativeQuery("SELECT * FROM users", User.class).getResultList();
		request.setAttribute("users",users);
		this.getServletContext().getRequestDispatcher("/").forward(request, response);
	}

}
