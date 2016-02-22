

insert into USUARIO (ID, ATIVO, NOME, EMAIL) values(1, true, 'Usuario1', 'usu@dominio1'),(2, true, 'Usuario1', 'usu@dominio1'),(3, true, 'Usuario3', 'usu@dominio3'),(4, true, 'Usuario4', 'usu@dominio4'),(5, true, 'Usuario5', 'usu@dominio5'),(6, true, 'Usuario6', 'usu@dominio6'),(7, true, 'Usuario7', 'usu@dominio7'),(8, true, 'Usuario8', 'usu@dominio8'),(9, true, 'Usuario9', 'usu@dominio9'),(10, true, 'Usuario10', 'usu@dominio10');
insert into PROJETO (NOME, DESCRICAO, DATAINICIO, DATATERMINO, PATROCINADOR, STAKEHOLDERS) values ('pac','controle de projeto', '01/01/2016', '01/01/2016', 'Juliano', 'INF');
insert into MEMBRO_PROJETO (IDUSUARIO, IDPROJETO, PAPEL) values (1,1,'GPP'),(2,1,'GPR'),(2,1,'MEG'),(3,1,'MEM'),(4,1,'MEM')
