<%-- 
    Document   : atribuirEquipe
    Created on : 12/02/2016, 15:29:25
    Author     : Danillo
--%>

<%@page import="br.ufg.inf.fabrica.pac.negocio.dominio.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.ufg.inf.fabrica.pac.negocio.dominio.MembroProjeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:useBean id="beanAtribuir" scope="session" class="br.ufg.inf.fabrica.pac.view.servlets.beans.BeanAtribuirEquipe" />
<jsp:setProperty name="beanAtribuir" param="usuarioPesquisado" property="usuarioPesquisado" />
<jsp:setProperty name="beanAtribuir" param="usuarioEmAlteracao" property="usuarioEmAlteracao" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atribuir equipe</title>
    </head>
    <body>
        <div>

            <h2>Membros</h2>

            <c:forEach var="usuario" items="${beanAtribuir.usuariosMembros}">
                <c:if test="${beanAtribuir.usuarioEmAlteracao!=usuario.id}">
                    <form method="post" action="atribuirEquipe.jsp">
                        <input type="hidden" name="usuarioEmAlteracao" value="${usuario.id}"/>
                        ${usuario.nome} - ${usuario.papeis} 
                        <input type="submit" value="Alterar"/>
                        <br/>
                    </form>
                </c:if>
                <c:if test="${beanAtribuir.usuarioEmAlteracao==usuario.id}">
                    <form method="post" action="atualizarPermissoesMembro">
                        <p/>
                        ${usuario.nome}
                        <br/>
                        <label for="papelGPR">GPR</label>
                        <input type="checkbox" value="GPR" name="papeis" id="papelGPR"
                               <c:if test="${usuario.GPR}">checked</c:if> />
                        <br/>
                        <label for="papelMEG">MEG</label>
                        <input type="checkbox" value="MEG" name="papeis" id="papelMEG"
                               <c:if test="${usuario.MEG}">checked</c:if> />
                        <br/>
                        <label for="papelMEM">MEM</label>
                        <input type="checkbox" value="MEM" name="papeis" id="papelMEM"
                               <c:if test="${usuario.MEM}">checked</c:if> />
                        <br/>
                        <input type="submit" value="Atualizar papéis"/>
                        <p/>
                    </form>
                </c:if>
            </c:forEach>




            <p/> 
            <h2>Não Membros</h2>
            <form method="post" action="atribuirEquipe.jsp">
                <input type="text" size="20" name="usuarioPesquisado" 
                       placeholder="Informe usuário para pesquisa"
                       value="${beanAtribuir.usuarioPesquisado}"/>
                <input type="submit" value="Pesquisar"/>
            </form>
            <c:if test="${!beanAtribuir.usuarioPesquisado.isEmpty()}">
                <form method="post" action="adicionarMembro">
                    <c:forEach var="naoMembro" items="${beanAtribuir.naoMembros}">
                        <label for="nomeNaoMembro">${naoMembro.nome}</label>
                        <input type="checkbox" value="${naoMembro.id}" 
                               id="nomeNaoMembro" name="nomeNaoMembro"/>
                        <br/>
                    </c:forEach>

                    <div>
                        <h2>Papéis</h2>
                        <label for="papelGPR">GPR</label>
                        <input type="checkbox" value="GPR" name="papeis"
                               id="papelGPR"/>
                        <br>
                        <label for="papelMGG">MGG</label>
                        <input type="checkbox" value="MGG" name="papeis"
                               id="papelMGG"/>
                        <br>
                        <label for="papelGPR">GPR</label>
                        <input type="checkbox" value="MEM" name="papeis"
                               id="papelMEM"/>
                    </div>

                    <input type="submit" value="Cadastrar"/>
                </form>
            </c:if>
        </div>
    </body>
</html>
