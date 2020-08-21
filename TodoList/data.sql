drop sequence sq_tarefa;
drop table tb_tarefa;

create table tb_tarefa (
	id number not null primary key,
	descricao varchar2(100) not null,
	data_limite date not null,
	feita number(1) default 0
);

create sequence sq_tarefa increment by 1 start with 1 nocycle order;

insert into tb_tarefa(id, descricao, data_limite) 
	values (sq_tarefa.nextval, 'Assistir CONFLOSS', to_date('21/08/2020', 'dd/mm/yyyy'));
insert into tb_tarefa(id, descricao, data_limite) 
	values (sq_tarefa.nextval, 'Assistir CONFLOSS parte 2', to_date('22/08/2020', 'dd/mm/yyyy'));
insert into tb_tarefa(id, descricao, data_limite) 
	values (sq_tarefa.nextval, 'Fazer hamburguer de grao bico', to_date('21/08/2020', 'dd/mm/yyyy'));
insert into tb_tarefa(id, descricao, data_limite) 
	values (sq_tarefa.nextval, 'Ir ao mercado', to_date('22/08/2020', 'dd/mm/yyyy'));
	
select * from tb_tarefa;