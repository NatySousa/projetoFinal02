#language: pt
#encoding: iso-8859-1

Funcionalidade: Saber o tipo de contratação de Funcionários
	como um usuário do sistema
	eu quero saber o tipo de contratação de um funcionário
	para que eu possa gerenciar funcionários
	
Cenário: Cadastro de Tipo de Contratação com sucesso
	Preencher todos os campos e verificar se o sistema 
realiza o cadastro do funcionário com sucesso.
	
	Dado Acessar a página de cadastro de tipo de contratação
  E Selecionar o funcionário "Ana Paula dos Santos"
	E Selecionar o tipo de contratação "CLT"
	Quando solicitar a realização do cadastro
	Então Sistema exibe a mensagem "Dados atualizados com sucesso"
	
Cenário: Validação de campos obrigatórios
	Deixar os campos em branco e verificar se o formulário 
valida cada campo como obrigatório.
	
	Dado Acessar a página de cadastro de tipo de contratação
	Quando solicitar a realização do cadastro
	Então Sistema informa que o nome do funcionário é obrigatório
	E Sistema informa que o tipo de contratação é obrigatório
