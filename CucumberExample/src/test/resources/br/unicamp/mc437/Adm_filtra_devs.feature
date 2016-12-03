Feature: Adm filtra Devs
  Como um usuario Adm
  Eu quero filtrar os desenvolvedores listados na tela
  
  Background:
  	Given desenvolvedores "Airi Satou" e "Ashton Cox"

  Scenario: Adm edita informações do filtro
     Given a pagina de listagem de desenvolvedores esta aberta
     When eu edito as informações do filtro com detalhes pertencentes a Airi Satou e nao a Ashton Cox
     Then a lista de usuarios e atualizada, contendo Airi Satou e nao contendo Ashton Cox