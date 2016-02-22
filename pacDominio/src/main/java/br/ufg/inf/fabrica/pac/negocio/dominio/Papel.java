package br.ufg.inf.fabrica.pac.negocio.dominio;

/**
 *
 * @author Danillo
 */
public enum Papel {
    GPP, // Gerente de Portifólio - Papel não depende de projeto
    GPR, // Gerente de Projetos - Só existe vinculado a projetos
    MEG, // Membro de equipe gerencial - Só existe vinculado a projetos
    MEM  // Membro de equipe - Só existe vinculado a projetos
}
