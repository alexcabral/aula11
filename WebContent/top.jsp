<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" 
   href="${PageContext.request.requestPath}bootstrap/css/bootstrap.min.css">


<script type="text/javascript" src="${PageContext.request.requestPath}jquery-ui/external/jquery/jquery.js">
</script>
<script type="text/javascript" src="${PageContext.request.requestPath}jquery-ui/jquery-ui.js">
</script>
<link rel="stylesheet" href="${PageContext.request.requestPath}jquery-ui/jquery-ui.css">


<script>
$(function(){
   $("#dtadmissao").datepicker({
      dateFormat : 'dd/mm/yy'
   });
   
   $("#cep").on('blur', function(){
      var cep = $(this).val();
      console.log(cep);
      
      $.getJSON('http://api.postmon.com.br/v1/cep/' + cep, 
            function(data){
         if(data != null){
            $("#rua").val(data.logradouro);
            $("#cidade").val(data.cidade);
         }
      });
   })
})
</script>
</head>