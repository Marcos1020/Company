create table TB_FUNCIONARIO(
  ID_FUNCIONARIO			numeric(100) not null,
  ID_DEPARTAMENTO           numeric(30)not null,
  NOME                   varchar(60) not null,
  TAREFAS		        varchar(200),
  CPF                   varchar(12) not null,
  DT_REGISTRO                  timestamp without time zone,
  DT_ALTERACAO     timestamp without time zone,
primary key (ID_FUNCIONARIO));
create sequence sq_tb_funcionario;