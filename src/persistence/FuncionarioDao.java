package persistence;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Funcionario;
import util.DateUtil;

public class FuncionarioDao extends Dao {

	public boolean cadastrar(Funcionario f)throws Exception{
		try{
			//abrir a conexao com o banco
			open();
			//cancelar o auto commit do banco
			con.setAutoCommit(false);
			
			stmt = con.prepareStatement("insert into funcionario values(null, ?,?,?)", 
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getEmail());
			stmt.setDate(3, DateUtil.dateToSqlDate(f.getAdmissao()));
			
			/*
			stmt.setDate(3, new Date(f.getAdmissao().getTime()));
			*/
			
			
			
			//Gravar o funcionario
			stmt.execute();
			
			//pegar o id do funcionario
			rs = stmt.getGeneratedKeys();
			rs.next();
			int idfuncionario = rs.getInt(1);
			
			//gravar o endereco
			stmt = con.prepareStatement("insert into endereco values(null, ?,?,?,?)");
			stmt.setString(1, f.getEndereco().getCep());
			stmt.setString(2, f.getEndereco().getRua());
			stmt.setString(3, f.getEndereco().getCidade());
			stmt.setInt(4, idfuncionario);
			
			stmt.execute();
			
			con.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			con.rollback();
			return false;
		}finally{
			close();
		}
	}
	
	public List<Funcionario> buscar(String nome)throws Exception{
		open();
		
		stmt = con.prepareStatement("select * from funcionario as f inner join endereco as e "
				+ "  on f.idfuncionario = e.idfuncionario "
				+ "  where f.nome like ? ");
		stmt.setString(1, nome + "%");
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		rs = stmt.executeQuery();
		while(rs.next()){
			Funcionario f = new Funcionario(rs.getInt("idfuncionario"), rs.getString("nome"),
					rs.getString("email"), rs.getDate("admissao"));
			
			Endereco end = new Endereco(rs.getInt("idendereco"), rs.getString("rua"), 
					rs.getString("cidade"), rs.getString("cep"));
			
			f.setEndereco(end);
			lista.add(f);
		}
		close();
		return lista;
	}
	
	public void excluir(Integer id) throws Exception{
		
		open();
		stmt = con.prepareStatement("delete from funcionario where idfuncionario = ?");
		stmt.setInt(1, id);
		stmt.execute();
		close();
		
	}
	
}
