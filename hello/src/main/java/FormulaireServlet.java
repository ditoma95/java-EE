
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet({"/formulaire", "/inscription"})
public class FormulaireServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{ 
		this.getServletContext().getRequestDispatcher("").forward(req, resp);
		
//		req.setCharacterEncoding("utf-8");
//		String name = req.getParameter("name");
//		String surname = req.getParameter("surname");
	
		
//		resp.setContentType("text/plain");
//		resp.setCharacterEncoding("utf-8");
//		resp.getWriter().write("Hello " + name + " ! " + surname);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nom = request.getParameter("nom");
		String motdepasse = request.getParameter("password");
		String email = request.getParameter("email");
		
		response.getWriter().write("Nom : " + nom);
		response.getWriter().write("Mot de passe : " + motdepasse);
		response.getWriter().write("Email : " + email);
		
		
		
		 FileWriter myWriter = new FileWriter("/home/dimitri/eclipse-workspace/hello-webapp/dock/my-file.txt", true);
	      myWriter.write(nom + " " + motdepasse + " " + email + "\n" );
	      myWriter.close();
	      this.getServletContext().getRequestDispatcher("/formulaire.jsp").forward(request, response);
		
	}


}
