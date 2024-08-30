@Test
Feature: Form Test
  Llenar Formularo y Mandarlo

  Scenario: Acceso a https://testpages.herokuapp.com/styled/
    Given Ingresar a https://testpages.herokuapp.com/styled/
    When Abrir Basic HTML Form
    When Ingresar Usuario
    When Ingresar Pass
    When Ingresar Comment
    When Seleccionar Checks
    When Seleccionar Radio
    When Seleccionar Multiple
    When Seleccionar Dropdown
    Then Submit Form