<%-- 
    Document   : home
    Created on : 04/01/2019, 14:46:35
    Author     : alann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina Principal</h1>
        <h2>${sessionScope.nome}</h2>
        <h2>${sessionScope.email}</h2>

        <fieldset>
            <legend>Formulário de cadastro de Aplicações</legend>
            <form action="CadastroApp" method="post">
                <label>Nome da Aplicação</label>
                <input type="text" name="nomeApp" />
                <button>Criar</button>
            </form>
        </fieldset>

        <br><br>

        <table border="1">
            <tr>
                <th>Aplicação</th>
                <th>Indentificador</th>
                <th>Registro de Dados</th>
            </tr>
            <c:if test="${sessionScope.tamanhoListApps > 0}">
                <c:forEach items="${sessionScope.apps}" var="app">
                    <tr>
                        <td>${app.nome}</td>
                        <td>${app.id}</td>
                        <td>
                            <center>
                                <form action="DadosApp" method="post">
                                    <input type="hidden" name="idApp" VALUE="${app.id}">
                                    <button>Dados</button>
                                </form>

                            </center>
                    </td>
                </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
