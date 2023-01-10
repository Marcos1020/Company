create table TB_TAREFAS(
    ID_TAREFA   NUMERIC(100)NOT NULL,
    TITULO      VARCHAR(150),
    DESCRICAO   VARCHAR(200),
    PRAZO       VARCHAR(10),
    ID_DEPARTAMENTO NUMERIC(30),
    DURACAO         NUMERIC(60),
    ID_FUNCIONARIO NUMERIC(100),
    STATUS_TAREFA      VARCHAR(100),
    DT_REGISTRO        timestamp without time zone,
    DT_FINALIZACAO     timestamp without time zone,
    DT_ALOCACAO       timestamp without time zone,
primary key (ID_TAREFA));
create sequence sq_tb_tarefas;