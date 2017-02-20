package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import business.Business;

@WebServlet({"/ControleFuncionario","/CadastrarFuncionario.html","/BuscarFuncionario.html",
	"/ExcluirFuncionario.html"})

public class ControleFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControleFuncionario() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path=request.getServletPath();
		String choice=path.replace("/","").replaceAll(".html","");
		choice="business."+choice;
		
		String retorno=null;
		
		try {
			
		
			Class <?> classe=Class.forName(choice);
			Business executar=(Business) classe.newInstance();
			
			retorno=executar.execute(request, response);

		} catch (ClassNotFoundException e){
			System.err.println("Nome de classe nao econtrada.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	

		
		/*
		if (choice.equalsIgnoreCase("/cadastrar.html")){
			CadastrarFuncionario cf=new CadastrarFuncionario();
			retorno=cf.execute(request, response);

		} else if (choice.equalsIgnoreCase("/buscar.html")){
			BuscarFuncionario bf=new BuscarFuncionario();
			retorno=bf.execute(request, response);
			
		} else {
			System.out.println("Caminho nao encontrado");
		} */

		request.getRequestDispatcher(retorno).forward(request, response);
		
	}

}
