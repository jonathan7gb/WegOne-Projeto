create database wegone_db;
use wegone_db;

create table orientacoesPortugues(
	codigo_orientacaoPT int auto_increment primary key,
    titulo_orientacaoPT longtext not null,
    tipo_orientacaoPT enum('Manual de operação', 'Procedimento de segurança', 'Manutenção e Reparos', 'Testes e Diagnósticos', 'Manual de Conduta e Operações Setoriais'),
    conteudo_orientacaoPT longtext not null
);

-- INSERE UMA NOVA ORIENTACAO NA TABELA
insert into orientacoesPortugues(titulo_orientacaoPT, tipo_orientacaoPT, conteudo_orientacaoPT)
values('Orientação 01', 'Manual de operação', 'Conteúdo da orientação 01'),
('Orientação 02', 'Manutenção e Reparos', 'Conteúdo da orientação 02'),
('Orientação 03', 'Testes e Diagnósticos', 'Conteúdo da orientação 03'),
('Orientação 04', 'Procedimento de segurança', 'Conteúdo da orientação 04'),
('Orientação 05', 'Manual de Conduta e Operações Setoriais', 'Conteúdo da orientação 05'),
('Orientação 06', 'Manual de operação', 'Conteúdo da orientação 06'),
('Orientação 07', 'Testes e Diagnósticos', 'Conteúdo da orientação 07'),
('Orientação 08', 'Manual de Conduta e Operações Setoriais', 'Conteúdo da orientação 08'),
('Orientação 09', 'Procedimento de segurança', 'Conteúdo da orientação 09'),
('Orientação 10', 'Manutenção e Reparos', 'Conteúdo da orientação 10');

-- RETORNA TODAS AS ORIENTAÇÕES CONTIDAS NA TABELAS
select * from orientacoesPortugues; 

-- RETORNA ALGUMA ORIENTAÇÃO ESPECÍFICA
select * from orientacoesPortugues where codigo_orientacaoPT = 1; 

-- EDITA O CONTEUDO DE UMA ORIENTAÇÃO ESPECÍFICA
update orientacoesPortugues 
set conteudo_orientacaoPT = 'aaa' 
where codigo_orientacaoPT = 1;

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table orientacoesEnglish(
	codigo_orientacaoEN int auto_increment primary key,
    titulo_orientacaoEN longtext not null,
    tipo_orientacaoEN enum('Operation manual', 'Safety procedure', 'Maintenance and Repairs', 'Tests and Diagnostics', 'Sectoral Conduct and Operations Manual'),
    conteudo_orientacaoEN longtext not null
);

-- INSERE UMA NOVA ORIENTACAO NA TABELA
insert into orientacoesEnglish(titulo_orientacaoEN, tipo_orientacaoEN, conteudo_orientacaoEN)
values('Orientation 01', 'Operation manual', 'Content of Orientation 01'),
('Orientation 02', 'Maintenance and Repairs', 'Content of Orientation 02'),
('Orientation 03', 'Tests and Diagnostics', 'Content of Orientation 03'),
('Orientation 04', 'Safety procedure', 'Content of Orientation 04'),
('Orientation 05', 'Sectoral Conduct and Operations Manual', 'Content of Orientation 05'),
('Orientation 06', 'Operation manual', 'Content of Orientation 06'),
('Orientation 07', 'Tests and Diagnostics', 'Content of Orientation 07'),
('Orientation 08', 'Sectoral Conduct and Operations Manual', 'Content of Orientation 08'),
('Orientation 09', 'Safety procedure', 'Content of Orientation 09'),
('Orientation 10', 'Maintenance and Repairs', 'Content of Orientation 10');

-- RETORNA TODAS AS ORIENTAÇÕES CONTIDAS NA TABELAS
select * from orientacoesEnglish; 

-- RETORNA ALGUMA ORIENTAÇÃO ESPECÍFICA
select * from orientacoesEnglish where codigo_orientacaoEN = 1; 

-- EDITA O CONTEUDO DE UMA ORIENTAÇÃO ESPECÍFICA
update orientacoesEnglish 
set conteudo_orientacaoEN = 'aaa' 
where codigo_orientacaoEN = 1;

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table orientacoesEspanhol(
	codigo_orientacaoES int auto_increment primary key,
    titulo_orientacaoES longtext not null,
    tipo_orientacaoES enum('Manual de Operación', 'Procedimiento de Seguridad', 'Mantenimiento y Reparaciones', 'Pruebas y Diagnósticos', 'Manual de Conducta y Operaciones del Sector'),
    conteudo_orientacaoES longtext not null
);

-- INSERE UMA NOVA ORIENTACAO NA TABELA
insert into orientacoesEspanhol(titulo_orientacaoES, tipo_orientacaoES, conteudo_orientacaoES)
values('Orientación 01', 'Manual de Operación', 'Contenido de la orientacion 01'),
('Orientación 02', 'Mantenimiento y Reparaciones', 'Contenido de la orientacion 02'),
('Orientación 03', 'Pruebas y Diagnósticos', 'Contenido de la orientacion 03'),
('Orientación 04', 'Procedimiento de Seguridad', 'Contenido de la orientacion 04'),
('Orientación 05', 'Manual de Conducta y Operaciones del Sector', 'Contenido de la orientacion 05'),
('Orientación 06', 'Manual de Operación', 'Contenido de la orientacion 06'),
('Orientación 07', 'Pruebas y Diagnósticos', 'Contenido de la orientacion 07'),
('Orientación 08', 'Manual de Conducta y Operaciones del Sector', 'Contenido de la orientacion 08'),
('Orientación 09', 'Procedimiento de Seguridad', 'Contenido de la orientacion 09'),
('Orientación 10', 'Mantenimiento y Reparaciones', 'Contenido de la orientacion 10');

-- RETORNA TODAS AS ORIENTAÇÕES CONTIDAS NA TABELAS
select * from orientacoesEspanhol; 

-- RETORNA ALGUMA ORIENTAÇÃO ESPECÍFICA
select * from orientacoesEspanhol where codigo_orientacaoES = 1; 

-- EDITA O CONTEUDO DE UMA ORIENTAÇÃO ESPECÍFICA
update orientacoesEspanhol 
set conteudo_orientacaoES = 'aaa' 
where codigo_orientacaoES = 1;

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table orientacoesAlemao(
	codigo_orientacaoAL int auto_increment primary key,
    titulo_orientacaoAL longtext not null,
    tipo_orientacaoAL enum('Bedienungsanleitung', 'Sicherheitsverfahren', 'Wartung und Reparaturen', 'Tests und Diagnose', 'Sektorverhaltens- und Betriebshandbuch'),
    conteudo_orientacaoAL longtext not null
);

-- INSERE UMA NOVA ORIENTACAO NA TABELA
insert into orientacoesAlemao(titulo_orientacaoAL, tipo_orientacaoAL, conteudo_orientacaoAL)
values('Anleitung 01', 'Bedienungsanleitung', 'Inhalt der Anleitung 01'),
('Anleitung 02', 'Wartung und Reparaturen', 'Inhalt der Anleitung 02'),
('Anleitung 03', 'Tests und Diagnose', 'Inhalt der Anleitung 03'),
('Anleitung 04', 'Sicherheitsverfahren', 'Inhalt der Anleitung 04'),
('Anleitung 05', 'Sektorverhaltens- und Betriebshandbuch', 'Inhalt der Anleitung 05'),
('Anleitung 06', 'Bedienungsanleitung', 'Inhalt der Anleitung 06'),
('Anleitung 07', 'Tests und Diagnose', 'Inhalt der Anleitung 07'),
('Anleitung 08', 'Sektorverhaltens- und Betriebshandbuch', 'Inhalt der Anleitung 08'),
('Anleitung 09', 'Sicherheitsverfahren', 'Inhalt der Anleitung 09'),
('Anleitung 10', 'Wartung und Reparaturen', 'Inhalt der Anleitung 10');

-- RETORNA TODAS AS ORIENTAÇÕES CONTIDAS NA TABELAS
select * from orientacoesAlemao; 

-- RETORNA ALGUMA ORIENTAÇÃO ESPECÍFICA
select * from orientacoesAlemao where codigo_orientacaoAL = 1; 

-- EDITA O CONTEUDO DE UMA ORIENTAÇÃO ESPECÍFICA
update orientacoesAlemao 
set conteudo_orientacaoAL = 'aaa' 
where codigo_orientacaoAL = 1;

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table orientacoesFrances(
	codigo_orientacaoFR int auto_increment primary key,
    titulo_orientacaoFR longtext not null,
    tipo_orientacaoFR enum('Manuel d`exploitation', 'Procédure de sécurité', 'Maintenance et réparations', 'Tests et diagnostics', 'Manuel de conduite et d`exploitation du secteur'),
    conteudo_orientacaoFR longtext not null
);

-- INSERE UMA NOVA ORIENTACAO NA TABELA
insert into orientacoesFrances(titulo_orientacaoFR, tipo_orientacaoFR, conteudo_orientacaoFR)
values('Conseils 01', 'Manuel d`exploitation', 'Contenu du conseils 01'),
('Conseils 02', 'Maintenance et réparations', 'Contenu du conseils 02'),
('Conseils 03', 'Tests et diagnostics', 'Contenu du conseils 03'),
('Conseils 04', 'Procédure de sécurité', 'Contenu du conseils 04'),
('Conseils 05', 'Manuel de conduite et d`exploitation du secteur', 'Contenu du conseils 05'),
('Conseils 06', 'Manuel d`exploitation', 'Contenu du conseils 06'),
('Conseils 07', 'Tests et diagnostics', 'Contenu du conseils 07'),
('Conseils 08', 'Manuel de conduite et d`exploitation du secteur', 'Contenu du conseils 08'),
('Conseils 09', 'Procédure de sécurité', 'Contenu du conseils 09'),
('Conseils 10', 'Maintenance et réparations', 'Contenu du conseils 10');

-- RETORNA TODAS AS ORIENTAÇÕES CONTIDAS NA TABELAS
select * from orientacoesFrances; 

-- RETORNA ALGUMA ORIENTAÇÃO ESPECÍFICA
select * from orientacoesFrances where codigo_orientacaoFR = 1; 

-- EDITA O CONTEUDO DE UMA ORIENTAÇÃO ESPECÍFICA
update orientacoesFrances 
set conteudo_orientacaoFR = 'aaa' 
where codigo_orientacaoFR = 1;

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table usuarios(
	id_usuario int auto_increment primary key,
    nome_usuario longtext not null,
    senha_usuario longtext not null,
    tipo_usuario enum ('usuario', 'admin')
);

-- INSERE UMA NOVA ORIENTACAO NA TABELA
insert into usuarios(nome_usuario, senha_usuario, tipo_usuario)
values('admin', 'admin123', 'admin'), ('usuario', 'usuario123', 'usuario'), ('jonathan', 'jonathan123', 'usuario');

select * from usuarios;
