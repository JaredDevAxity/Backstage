package step_definitions;

import java.util.logging.Logger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.PrincipalPage;

public class AccesoLoginSteps {
	private static Logger log = Logger.getLogger("stepDef.AccesoLoginSteps");
	PrincipalPage principalPage = new PrincipalPage();

	@Given("^Se ingresa al sitio https://www.acomerclub.com.mx/home")
	public void accessAsite() throws InterruptedException {
		principalPage.navigateToWeb();
		Thread.sleep(3000);
	}

	@When("Se hace click en login")
	public void login() throws InterruptedException {
		principalPage.clicSignIn();
		Thread.sleep(3000);
	}

}
