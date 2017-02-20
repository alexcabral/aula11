package business;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcionario;
import persistence.FuncionarioDao;

public class BuscarFuncionario implements Business {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg="Dados dos funcionarios.";
		String tipo="class='alert alert-info'";
		
		try {
			
			FuncionarioDao fd=new FuncionarioDao();
			String nome=request.getParameter("busca");
			List<Funcionario> lista=fd.buscar(nome);
			
			if (lista.size()==0){
				msg="Sem dados para exibição. Tente outra consulta.";
				tipo="class='alert alert-warning'";
			}
			
			request.setAttribute("lista",lista);
			request.setAttribute("msg","");		
					
			return "buscar.jsp";
		} catch (Exception e) {
			msg="Erro: Não foi possivel fazer alguma coisa. Contata o Gambiarraman!!1";
			e.printStackTrace();
		} finally {
			request.setAttribute("msg",msg);
			request.setAttribute("tipo",tipo);
			
		}
		
		return "buscar.jsp";
	}

		
}
