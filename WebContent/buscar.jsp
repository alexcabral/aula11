<jsp:include page="top.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<body>

   <div class="container container-fluid">
      <div class="col-xs-12">
         <jsp:include page="menu.jsp" />  
      </div>
   </div>   
    

	<div class="container container-fluid">
		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
               CONSULTA DE FUNCIONARIOS
				</div>
			</div>
				
        <!-- Formulario de consulta -->
           <div class="panel-body">
				<form method="post" action="BuscarFuncionario.html" class="form-inline">
					<div class="form-group">
						<label for="busca">Nome :</label> 
						<input type="text" name="busca" value=""
							class="form-control" id="busca">
					</div>
					
					<!-- <input type="submit" value="Buscar" class="btn btn-primary"> -->
					<button type="submit" class="btn btn-info btn-md" >
                    <span class="glyphicon glyphicon-search"></span> Buscar 
               </button>
					
				</form>
          </div>
         
				
				
				<!-- Dados na tabela -->
       <div class="panel-body">
       	<c:if test="${fn:length(lista) <= 0 }">
				<div class='alert alert-warning'>Sem itens para exibir.Execute uma consulta.</div>
			</c:if>  

			<c:if test="${fn:length(lista) > 0 }">
				<div ${tipo}>${msg }</div>
	           	<div class="table-responsive">				
						<table class="table table-bordered table-striped table-hover">
							<tr>
								<th>Nome</th>
								<th>Email</th>
								<th>Admissao</th>
								<th>CEP</th>
								<th>Rua</th>
								<th>Cidade</th>
								<th></th>
							</tr>
							<c:forEach items="${lista}" var="func">
							<tr>
								<td>${func.nome }</td>
								<td>${func.email }</td>
								<td>${func.admissao}</td>
								<td>${func.endereco.cep}</td>
								<td>${func.endereco.rua }</td>
								<td>${func.endereco.cidade }</td>
								<td>
								   <a href="#">
									<span class="glyphicon glyphicon-pencil" title="Editar"></span>
									</a>
									<a href="ExcluirFuncionario.html?id=${func.idFuncionario}"
									   onclick="return confirm('Deseja excluir o produto?')">
									<span class="glyphicon glyphicon-trash" title="Excluir"></span>
									</a>
									<a href="#">
                             <span class="glyphicon glyphicon-list-alt" title="Detalhes"></span>
                             </a>
								</td>
							</tr>
							</c:forEach>
						</table>
	                 </div>
					</c:if>
            </div>
         </div>
     </div>
     
     <div class="container container-fluid">
      <div class="col-xs-12">
         <jsp:include page="botton.jsp" />  
      </div>
   </div>
     
         

				
</body>

