<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link type="text/css" href="resources/css/tasks.css" rel="stylesheet">
</head>
<body>
	<h2>Editar task - ${task.id}</h2>
	<form  action="editatask" method=post>
		<h3>Descrição</h3><br />
		<form:errors path="task.descricao" cssStyle="color:red"/><br />
		<fmt:message key="teste.mensagem" /><br />
		
		<input name="id" type="hidden"  value="${task.id}">
		<textarea name="descricao" rows="5" cols="100">${task.descricao}</textarea><br />
		Finalizada? <input type="checkbox" name="finalizada" value="true" ${task.finalizada? 'checked' : ''} /><br/>
		DataFinalização<br/>
		<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${task.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>" />
		<input type="submit" value="Editar">
	</form>
</body>
</html>