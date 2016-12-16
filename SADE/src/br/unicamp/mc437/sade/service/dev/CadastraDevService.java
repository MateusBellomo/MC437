package br.unicamp.mc437.sade.service.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

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
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			Desenvolvedor dev = null;
			
			//VALIDACOES
			String errorMsg = "";
			try {
				dev = gson.fromJson(request.getParameter("json"), Desenvolvedor.class);
			} catch (JsonSyntaxException e){
				errorMsg += "Campos de Horas Graduação, Disponível e Estágio são Obrigatórios";
			}
			if(dev != null) {
				if(dev.getNome()==null||dev.getNome().equals("")){
					errorMsg += "Campo Nome do Desenvolvedor é Obrigatório\n";
				}
				if(dev.getRg()==null||dev.getRg().equals("")){
					errorMsg += "Campo RG do Desenvolvedor é Obrigatório\n";
				}
				if(dev.getEmail()==null||dev.getEmail().equals("")){
					errorMsg += "Campo Email do Desenvolvedor é Obrigatório\n";
				}
				for(Desenvolvedor devTemp : devService.getAll()){
					if(dev.getRg().equals(devTemp.getRg()))
						errorMsg += "RG Já Utilizado!";
					if(dev.getEmail().equals(devTemp.getEmail()))
						errorMsg += "Email Já Utilizado!";
				}
				if(dev.getTelCel()==null||dev.getTelCel().equals("")){
					errorMsg += "Campo Celular do Desenvolvedor é Obrigatório\n";
				}
				if(dev.getEndereco()==null||dev.getEndereco().equals("")){
					errorMsg += "Campo Endereço do Desenvolvedor é Obrigatório\n";
				}
				if(dev.gethGrad()==null||dev.gethGrad().equals("")){
					errorMsg += "Campo Horas Graduação é Obrigatório\n";
				}
				if(dev.gethDisp()==null||dev.gethDisp().equals("")){
					errorMsg += "Campo Horas Disponível é Obrigatório\n";
				}
				if(dev.gethEstag()==null||dev.gethEstag().equals("")){
					errorMsg += "Campo Horas Estágio é Obrigatório\n";
				}
			}
			
			
			
			if(errorMsg.length()>0){
				throw new Exception(errorMsg);
			}
			
			response.setStatus(HttpServletResponse.SC_OK);
			writer.append("Desenvolvedor Cadastrado com Sucesso");
			devService.save(dev);
			
		} catch (Exception e) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append(e.getMessage());
		}
	}

}
