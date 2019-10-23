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
        <title>Página Inicial</title>
        <meta charset="UTF-8">
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

        <style>

        </style>

    </head>
    <body class='limiter'>
        <header class="login100-form-title" style="padding-top: 25px !important; position: relative !important">
            <span style="text-align: right !important;">
                <p style="margin: 0px 10px !important; color: white !important">
                    ${sessionScope.nome} - ${sessionScope.email}
                </p>
            </span>
            <h1>SD-ProfilingLITE</h1>
        </header>

        <br/>

        <div style='display: inline !important; max-width: 100% !important;'>
            <div style='width: 50% !important; float: left'>
                <fieldset style="margin: 1% !important; padding: 0.5% !important;">
                    <legend>Formulário de cadastro de Aplicações</legend>
                    <form action="CadastroApp" method="post">
                        <input class="input100" style="width: 90% !important" placeholder="Nome da Aplicação" type="text" name="nomeApp" />
                        <br/>
                        <button class="login100-form-btn" style="width: 90% !important">Criar</button>
                    </form>
                </fieldset>        
            </div>

            <div class="width: 50% !important; float: left; margin: 1% !important; padding: 1% !important;">

                <table class="table" style="width: 50% !important">
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
                                    <input type="hidden" name="idApp" value=${app.id} >
                                    <input class="login100-form-btn" style="width: auto !important" type="submit" value="Dados">
                                </form>

                            </center>
                            </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>

            </div>    
        </div>

        <br/>

        <footer style="width: 100%; background-color: #57b846; margin: auto !important; text-align: center; min-height: 10% !important; padding: 1% !important; position: fixed !important; bottom: 0 !important">
            <p style="color: white !important">TCC II</p>
        </footer>

</html>
