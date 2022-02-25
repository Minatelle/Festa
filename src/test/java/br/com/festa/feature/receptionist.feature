Feature: Cenário de testes de recepcinista
  Scenario: Cenários de sucesso
    Given um cliente de 21 anos de idade
    And hoje é 25/02/2022
    And está com um convite válido para uma festa que inicia no dia 26/02/2022
    When o recepcionista receber o convite e validá-lo
    Then a seguinte mensagem deve ser exibida: "A festa ainda não foi iniciada"