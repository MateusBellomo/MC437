Feature: Register on Bodgeit
  As an user
  I want to register on Bodgeit
  So that I am registered

  Scenario: register is done
     Given the page is open "http://localhost:8080/bodgeit/register.jsp"
     When I introduce my username "student@unicamp.br" and password "student"
     Then a page should show the message "You have successfully registered with the BodgeIt Store."
