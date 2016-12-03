# encoding: UTF-8
Feature: dev cadastra dev
  Como novo usuario
  Quero cadastrar como desenvolvedor
  Para poder desenvolver software para a conpec
  
  Background:
     Given Estou na pagina de cadastrar dev

  Scenario: cadastro novo dev com sucesso
     Given Nenhum usuario esta cadastrado
     When Eu preencho o campo usuario como "dev123"
     And Preencho o restante dos campos com dados validos 
     Then Devo ir para a pagina confirmando cadastro de "dev123"
     
  Scenario: falha no cadastro com campos invalidos
     Given Nenhum usuario esta cadastrado
     When Preencho os campos de registro com dados invalidos 
     Then Nao devo conseguir cadastrar
     
  Scenario: falha no cadastro por conflito com os outros usuarios
     Given existem usuarios cadastrados
     When tento cadastrar com dados conflitantes com usuarios cadastrados
     Then Sou informado dos dados conflitantes 
      
  
     
      
     		
      
     		
