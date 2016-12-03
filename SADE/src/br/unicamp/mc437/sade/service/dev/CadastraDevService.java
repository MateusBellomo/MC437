package br.unicamp.mc437.sade.service.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.unicamp.mc437.sade.dataService.GenericService;
import br.unicamp.mc437.sade.dataService.GenericServiceImpl;
import br.unicamp.mc437.sade.persistance.Desenvolvedor;
import br.unicamp.mc437.sade.util.HibernateUtil;

/**
 * Servlet implementation class CadastraDevService
 */
@WebServlet("/service/dev/cadastraDevService")
public class CadastraDevService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraDevService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{

			GenericService<Desenvolvedor> devService = new GenericServiceImpl<Desenvolvedor>(
					Desenvolvedor.class, HibernateUtil.getSessionFactory());
			
			Gson gson = new Gson();
			Desenvolvedor dev = gson.fromJson(request.getParameter("json"), Desenvolvedor.class);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			writer.append("{ status: “ok” }");
			
			devService.save(dev);
			
			
		} catch (Exception e) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("{ status: “fail”, message:"+e.getMessage()+" }");
		}
	}

}
