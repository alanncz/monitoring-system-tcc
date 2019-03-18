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

    <c:forEach items="${sessionScope.dadosTarefas}" var="tarefa">
        <fieldset>
            <legend> ${tarefa.nome} : ${tarefa.qtda_execucao} execucoes"</legend>
            <c:forEach items="${tarefa.listExecucoes}" var="execucao">

                <fieldset>

                    <h4>Codigo de execução : ${execucao.id}</h4>

                    <table style="float: left; margin: 10px" border="1">
                        <tr><th colspan="4" style="background: #495057">Memória</th></tr>
                        <tr>
                            <th> Host de Execução </th>
                            <th> Inicial </th>
                            <th> Final</th>
                            <th> Memória Usada</th>
                        </tr>

                        <c:forEach items="${execucao.collectMemoryInfo.collections}" var="data">
                            <tr>
                                <td>${data.ip}</td>
                                <td>${data.initMemory}</td>
                                <td>${data.endMemory}</td>
                                <td>${data.memoryUsada}</td>
                            </tr>
                        </c:forEach>
                    </table>

                    <table style="float: left; margin: 10px" border="1">
                        <tr><th colspan="4"style="background: #495057">Threads</th></tr>
                        <tr>
                            <th> Host de Execução </th>
                            <th> Iniciais </th>
                            <th> Finais</th>
                            <th> Instanciadas</th>
                        </tr>

                        <c:forEach items="${execucao.collectThreadInfo.collections}" var="data">
                            <tr>
                                <td>${data.ip}</td>
                                <td>${data.initThreads}</td>
                                <td>${data.endThreads}</td>
                                <td>${data.instanceThreads}</td>
                            </tr>
                        </c:forEach>
                    </table>

                    <table style="float: left; margin: 10px" border="1">
                        <tr><th colspan="4" style="background: #495057">Pacote de Dados</th></tr>
                        <tr>
                            <th> Host de Execução </th>
                            <th> Entrada de Dados </th>
                            <th> Saida de Dados</th>
                        </tr>

                        <c:forEach items="${execucao.tCollectSizePacketInfo.collections}" var="data">
                            <tr>
                                <td>${data.ip}</td>
                                <td>${data.dataInput}</td>
                                <td>${data.dataOutput}</td>
                            </tr>
                        </c:forEach>
                    </table>

                    <table style="float: left; margin: 10px" border="1">
                        <tr><th colspan="4" style="background: #495057"> Tempo</th></tr>
                        <tr>
                            <th> Host Inicial </th>
                            <th> Host Final </th>
                            <th> Inicial</th>
                            <th> Final </th>
                            <th> Milisegundos </th>
                        </tr>

                        <tr>
                            <td>${execucao.collectTimeInfo.ips[0]}</td>
                            <td>${execucao.collectTimeInfo.ips[1]}</td>
                            <td>${execucao.collectTimeInfo.initTime}</td>
                            <td>${execucao.collectTimeInfo.endTime}</td>
                            <td>${execucao.collectTimeInfo.milisegundos}</td>
                        </tr>
                    </table>
                </fieldset>
            </c:forEach>
        </c:forEach>
    </fieldset>

    <br><br>
