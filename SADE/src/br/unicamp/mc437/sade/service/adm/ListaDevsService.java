package br.unicamp.mc437.sade.service.adm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
 * Servlet implementation class ListaDevsService
 */
@WebServlet("/service/adm/listaDevs")
public class ListaDevsService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDevsService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		GenericService<Desenvolvedor> devService = new GenericServiceImpl<Desenvolvedor>(
				Desenvolvedor.class, HibernateUtil.getSessionFactory());
		
		Gson gson = new Gson();
		ListaDevsMessage message = new ListaDevsMessage();
		message.setData(new LinkedList<>());

		for (Desenvolvedor dev : devService.getAll()) {
			List<String> line = new ArrayList<String>();
			line.add(dev.getNome());
			line.add(dev.getEmail());
			line.add(dev.getJava().toString());
			line.add(dev.getPhp().toString());
			line.add(dev.getMysql().toString());
			line.add(dev.getAjax().toString());
			line.add(dev.getJavascript().toString());
			line.add(dev.getPython().toString());
			line.add(dev.getCsharp().toString());
			message.getData().add(line);
		}
		
		writer.append(gson.toJson(message, ListaDevsMessage.class));
	}

}
