package br.unicamp.mc437.sade.service.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
			Gson gson = new Gson();
			CadastraDevMessage message = gson.fromJson(request.getParameter("json"), CadastraDevMessage.class);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			writer.append("{ status: “ok” }");
		} catch (Exception e) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("{ status: “fail”, message:"+e.getMessage()+" }");
		}
	}

}
