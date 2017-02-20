package business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.FuncionarioDao;

public class ExcluirFuncionario implements Business {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer id=new Integer(request.getParameter("id"));
		new FuncionarioDao().excluir(id);
		
		return "buscar.jsp";
	}
	
	

}
