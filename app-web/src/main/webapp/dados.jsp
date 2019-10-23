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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>

        <header class="login100-form-title" style="padding-top: 25px !important; position: relative !important">
            <span style="text-align: right !important;">
                <a href="home.jsp">
                    <p style="margin: 0px 10px !important; color: white !important">
                        ${sessionScope.nome} - ${sessionScope.email}
                    </p>
                </a>
            </span>
            <h1>SD-ProfilingLITE</h1>
            <br/>
            <h4>Aplicação: app-teste</h4>
        </header>

        <c:forEach items="${sessionScope.dadosTarefas}" var="tarefa">

            <div style="width: 100% !important; padding: 1% !important" class="title-dropdown">

                <div>
                    <a data-toggle="collapse" href="#collapseExample${tarefa.nome}">
                        <h2 style="color: white; background: #57b846; width: 100% !important; display: block !important; float: left; padding: 0.5% !important;">
                            ${tarefa.nome} : ${tarefa.qtda_execucao} execuções
                        </h2>
                    </a>
                </div>

                <br />

                <div class="collapse" id="collapseExample${tarefa.nome}">
                    <c:forEach items="${tarefa.listExecucoes}" var="execucao">

                        <div style="width: 100% !important">

                            <h4 style="display: block !important; float: left !important; margin: 1% !important">Codigo de execução : ${execucao.id}</h4>

                            <div style="width: 48% !important; float: left !important; margin: 1% !important">

                                <table class="table">
                                    <tr><th colspan="4" style="background: #57b846; color: white">Memória</th></tr>
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
                            </div>

                            <div style="width: 48% !important; float: left !important; margin: 1% !important">

                                <table class="table">
                                    <tr><th colspan="4"style="background: #57b846; color: white">Threads</th></tr>
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
                            </div>

                            <div style="width: 68% !important; float: left !important; margin: 1% !important">

                                <table class="table">
                                    <tr><th colspan="5" style="background: #57b846; color: white"> Tempo</th></tr>
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
                            </div>

                            <div style="width: 28% !important; float: left !important; margin: 1% !important">

                                <table class="table">
                                    <tr><th colspan="4" style="background: #57b846; color: white">Pacote de Dados</th></tr>
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
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>
            <br><br>
        </c:forEach>

        <footer style="width: 100%; background-color: #57b846; margin: auto !important; text-align: center; min-height: 10% !important; padding: 1% !important; position: fixed !important; bottom: 0 !important">
            <p style="color: white !important">Alann Rodrigues Ferreira</p>
        </footer>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
