package business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Endereco;
import model.Funcionario;
import persistence.FuncionarioDao;
import util.DateUtil;

public class CadastrarFuncionario implements Business {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo="class='alert alert-info'";
		String msg="Funcionario cadastrado com sucesso.";
		
		try{
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String dtadmissao = request.getParameter("dtadmissao");
			
			String cidade = request.getParameter("cidade");
			String cep = request.getParameter("cep");
			String rua = request.getParameter("rua");
			
			/*
			 * 
			String[] dt = dtadmissao.split("/");
			
			
			Calendar cal = Calendar.getInstance();
			cal.set(new Integer(dt[2]), new Integer(dt[1]) - 1,
					new Integer(dt[0]));
			*/
			
			
			Funcionario f = new Funcionario();
			f.setNome(nome);
			f.setEmail(email);
			f.setAdmissao(DateUtil.StrToDate(dtadmissao));
			
			Endereco end = new Endereco();
			end.setCep(cep);
			end.setCidade(cidade);
			end.setRua(rua);
			
			//relacionamento
			f.setEndereco(end);
			
			FuncionarioDao fd = new FuncionarioDao();
			fd.cadastrar(f);
			
			tipo="class='alert alert-success'";
			msg="Funcionario cadastrado com sucesso.";
			return "index.jsp";
			
		} catch(Exception e){

			tipo="alert alert-warning";
			msg="Ocorreu um erro ao tentar cadastrar o funcionario."+e.getCause();
			e.printStackTrace();
			return "index.jsp";
			
		} finally {
			request.setAttribute("msg", msg);
			request.setAttribute("tipo", tipo);
		}
	
	} //execute
} //class
