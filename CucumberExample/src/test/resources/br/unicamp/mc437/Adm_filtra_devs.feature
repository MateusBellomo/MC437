Feature: Adm filtra Devs
  Como um usuario Adm
  Eu quero filtrar os desenvolvedores listados na tela
  
  Background:
  	Given desenvolvedores "Joao" e "Pedro"

  Scenario: Adm edita informações do filtro
     Given a pagina de listagem de desenvolvedores esta aberta
     And eu editei as informações do filtro com detalhes pertencentes a Joao e nao a Pedro
     When eu Clico no botão "Pesquisar"
     Then a lista de usuarios e atualizada, contendo Joao e nao contendo Pedro
