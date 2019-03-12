<%-- 
    Document   : dados
    Created on : 12/03/2019, 12:03:31
    Author     : alann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados</title>
    </head>
    <body>
        
        <h1>Pagina Principal</h1>
        <h2>${sessionScope.nome}</h2>
        <h2>${sessionScope.email}</h2>
    <center> <h2>Nome da aplicação</h2></center>

    <fieldset>

        <legend> "Nome da tarefa : 356 execuçoes"</legend>

        <center>
            <h3>Codigo de execucao</h3>
            <table style="float: left; margin: 20px"  border="1">
                <tr>
                    <th> Codigo de execução </th>
                    <th> Host de execução </th>
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

            <table style="float: left; margin: 20px " border="1">
                <tr>
                    <th> Codigo de execução </th>
                    <th> Host de execução </th>
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

            <table style="float: left; margin: 20px" border="1">
                <tr>
                    <th> Codigo de execução </th>
                    <th> Host de execução </th>
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

            <table style="float: left; margin: 20px" border="1">
                <tr>
                    <th> Codigo de execução </th>
                    <th> Host de execução </th>
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
        </center>

    </fieldset>
    
    
    <br><br>
    
    <fieldset>

        <legend> "Nome da tarefa : 356 execuçoes"</legend>

        <center>
            <h3>Codigo de execucao</h3>
            <table style="float: left; margin: 20px"  border="1">
                <tr>
                    <th> Codigo de execução </th>
                    <th> Host de execução </th>
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

            <table style="float: left; margin: 20px " border="1">
                <tr>
                    <th> Codigo de execução </th>
                    <th> Host de execução </th>
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

            <table style="float: left; margin: 20px" border="1">
                <tr>
                    <th> Codigo de execução </th>
                    <th> Host de execução </th>
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

            <table style="float: left; margin: 20px" border="1">
                <tr>
                    <th> Codigo de execução </th>
                    <th> Host de execução </th>
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
        </center>

    </fieldset>

    <br><br>
