<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Atualização de livros</title>
</head>
<body>
<h1>Atualizar Livro</h1>
<fieldset>
    <legend>Dados basicos</legend>
    <form action="update-livro" method="put">
        <div>
            <input type="hidden" name="id" value="${livro.id}">
        </div>
        <div>
            <label for="idNome">Nome:</label>
            <input type="text" id="idNome" name="nome">
        </div>
        <div>
            <label for="idautor">Autor</label>
            <input type="text" id="idAutor" name="autor">
        </div>
        <input type="submit" value="Enviar">
    </form>
</fieldset>
</html>
