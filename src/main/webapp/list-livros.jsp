<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<html>
<head>
    <title>Lista de Livros</title>
</head>
<body>

<c:if test="${idLivroCreated != null}">
    <h3>Livro de id: ${idLivroCreated} , cadastrado com sucesso!</h3>
</c:if>
<c:if test="${idLivroUpdated != null}">
    <h3>Livro de id: ${idLivroUpdated} , alterado com sucesso!</h3>
</c:if>
    <h1>Lista de lirvos cadastrados</h1>

    <table border="solid">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Autor</th>
            <th>Editar</th>
            <th>Deletar</th>
        </tr>
        <c:forEach var="livro" items="${listaLivros}" varStatus="id">
            <tr>
                <td>${livro.id}</td>
                <td>${livro.nome}</td>
                <td>${livro.autor}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/api/update-jsp?id=<c:out value='${livro.id}'/>">Edit</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/api/delete-livro?id=<c:out value='${livro.id}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/cadastro-livro.jsp">Cadastre um novo Livro</a>
</body>
</html>
