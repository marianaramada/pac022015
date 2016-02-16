<%-- 
    Document   : atribuirEquipe
    Created on : 12/02/2016, 15:29:25
    Author     : Danillo
--%>

<%@page import="br.ufg.inf.fabrica.pac.negocio.dominio.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:useBean id="beanAtribuir" scope="session" class="br.ufg.inf.fabrica.pac.view.servlets.beans.BeanAtribuirEquipe" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atribuir equipe</title>
    </head>
    <body>
        <div>
            <form>
                <input type="text" value="${beanAtribuir.nome}"/>
            </form>
            <h2>Membros</h2>
            <form action="listarUsuariosEMembros" method="post">
                Usuario<br/>
                <c:forEach var="membro" items="${beanAtribuir.membros}">
                    ${membro.idUsuario} - 
                    GPR <input name="${membro.idUsuario}-${membro.idProjeto}-GPR" type="checkbox" checked="true"> | 
                    MGE <input name="${membro.idUsuario}-${membro.idProjeto}-MGE" type="checkbox"> | 
                    MEM <input name="${membro.idUsuario}-${membro.idProjeto}-MPR" type="checkbox">
                    <br/>
                </c:forEach>
                <p/>
                <h2>Não Membros</h2>
                Usuario<br/>
                <c:forEach var="naoMembro" items="${beanAtribuir.naoMembros}">
                    ${naoMembro.id} - 
                    GPR <input name="${naoMembro.id}-${beanAtribuir.projetoSelecionado.id}-GPR" type="checkbox"> | 
                    MGE <input name="${naoMembro.id}-${beanAtribuir.projetoSelecionado.id}-MGE" type="checkbox"> | 
                    MEM <input name="${naoMembro.id}-${beanAtribuir.projetoSelecionado.id}-MPR" type="checkbox">
                    <br/>
                </c:forEach>
                <input type="submit"/>
            </form>
        </div>
    </body>
</html>
