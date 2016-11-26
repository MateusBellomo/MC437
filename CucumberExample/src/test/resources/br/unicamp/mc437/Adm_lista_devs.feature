# encoding: UTF-8
Feature: Administrador lista desenvolvedores

  Scenario Outline: Administrador verifica desenvolvedores
   	Given Existem <devs> cadastrados
 	When Administrador abre pagina de listar desenvolvedores
  	Then Devem ter <devs> listados

   	Examples:
	    |  devs  |
	    |   10   |
	    |   20   |
		|   1    |
	    |   5    |
	    |   3    |
	    |   0    |