#language: pt
#encoding: iso-8859-1

Funcionalidade: Saber o tipo de contrata��o de Funcion�rios
	como um usu�rio do sistema
	eu quero saber o tipo de contrata��o de um funcion�rio
	para que eu possa gerenciar funcion�rios
	
Cen�rio: Cadastro de Tipo de Contrata��o com sucesso
	Preencher todos os campos e verificar se o sistema 
realiza o cadastro do funcion�rio com sucesso.
	
	Dado Acessar a p�gina de cadastro de tipo de contrata��o
  E Selecionar o funcion�rio "Ana Paula dos Santos"
	E Selecionar o tipo de contrata��o "CLT"
	Quando solicitar a realiza��o do cadastro
	Ent�o Sistema exibe a mensagem "Dados atualizados com sucesso"
	
Cen�rio: Valida��o de campos obrigat�rios
	Deixar os campos em branco e verificar se o formul�rio 
valida cada campo como obrigat�rio.
	
	Dado Acessar a p�gina de cadastro de tipo de contrata��o
	Quando solicitar a realiza��o do cadastro
	Ent�o Sistema informa que o nome do funcion�rio � obrigat�rio
	E Sistema informa que o tipo de contrata��o � obrigat�rio
