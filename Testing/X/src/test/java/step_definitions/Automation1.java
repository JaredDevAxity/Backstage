package step_definitions;

import cucumber.api.java.en.*;
import pages.AutomationPage1;

public class Automation1 {
    AutomationPage1 automationPage1 = new AutomationPage1();

    @Given("^Ingresar a https://testpages.herokuapp.com/styled/")
    public void accessToOxxo() throws InterruptedException {
        automationPage1.navigateToWeb();
        Thread.sleep(3000);
    }

    @When("Abrir Basic HTML Form")
    public void openForm() {
        automationPage1.clicElement(automationPage1.formExample);
    }

    @When("Ingresar Usuario")
    public void inputUser() {
        automationPage1.clicElement(automationPage1.inputUserName);
        automationPage1.write(automationPage1.inputUserName, "Test");
    }

    @When("Ingresar Pass")
    public void inputPass() {
        automationPage1.clicElement(automationPage1.inputPassword);
        automationPage1.write(automationPage1.inputPassword, "Test123");
    }

    @When("Ingresar Comment")
    public void inputComment() {
        automationPage1.clicElement(automationPage1.tesxtArea);
        automationPage1.write(automationPage1.tesxtArea, "Comentario de Prueba");
    }

    @When("Seleccionar Checks")
    public void selectChecks() {
        automationPage1.clicElement(automationPage1.check2);
        automationPage1.clicElement(automationPage1.check3);
        automationPage1.clicElement(automationPage1.check1);
    }

    @When("Seleccionar Radio")
    public void selectRadio() {
        automationPage1.clicElement(automationPage1.radio1);
    }

    @When("Seleccionar Multiple")
    public void selectMultiple() {
        automationPage1.clicElement(automationPage1.multiple + "/option[1]");
    }

    @When("Seleccionar Dropdown")
    public void selectDropddown() {
        automationPage1.clicElement(automationPage1.multiple + "/option[1]");
    }

    @When("Submit Form")
    public void submitForm() {
        automationPage1.clicElement(automationPage1.submitBtn);
    }
}
