package br.unicamp.mc437.sade.service.dev;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unicamp.mc437.sade.dataService.GenericService;
import br.unicamp.mc437.sade.dataService.GenericServiceImpl;
import br.unicamp.mc437.sade.persistance.Desenvolvedor;
import br.unicamp.mc437.sade.util.HibernateUtil;

/**
 * Servlet implementation class CleanDBService
 */
@WebServlet("/service/dev/cleanDB")
public class CleanDBService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CleanDBService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenericService<Desenvolvedor> devService = new GenericServiceImpl<Desenvolvedor>(
				Desenvolvedor.class, HibernateUtil.getSessionFactory());
		devService.deleteAll();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
