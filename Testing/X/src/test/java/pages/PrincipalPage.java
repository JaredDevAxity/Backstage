package pages;

import org.openqa.selenium.WebDriver;

public class PrincipalPage extends BasePage{
    public PrincipalPage() {
        super(driver);
    }

    private String loginBtn = "/html/body/app-root/mat-sidenav-container/mat-sidenav-content/mat-toolbar/mat-toolbar-row[2]/div[2]/button";

    // load web
    public void navigateToWeb() throws InterruptedException {
       navigateTo("https://www.acomerclub.com.mx/home");
    }


    // boton LOGIN
    public void clicSignIn() {
        clicElement(loginBtn);
    }
}
