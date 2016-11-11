Feature: Adm filtra Devs
  Como um usuário Adm
  Eu quero filtrar os desenvolvedores listados na tela
  
  Background:
  	Given desenvolvedores "João" e "Pedro"

  Scenario: Adm edita informações do filtro
     Given a página de listagem de desenvolvedores está aberta
     And eu editei as informações do filtro com detalhes pertencentes à João e não à Pedro
     When eu Clico no botão "Pesquisar"
     Then a lista de usuários é atualizada, contendo João e não contendo Pedro
