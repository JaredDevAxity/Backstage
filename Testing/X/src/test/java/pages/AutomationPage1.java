package pages;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.annotation.JsonAppend;

public class AutomationPage1 extends BasePage{

    public String formExample = "//*[@id=\"htmlformtest\"]";
    public String inputUserName = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[1]/td/input";
    public String inputPassword = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[2]/td/input";
    public String tesxtArea = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea";
    public String filePicker = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[4]/td/input[1]";
    public String check1 = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]";
    public String check2 = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]";
    public String check3 = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[3]";
    public String radio1 = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[1]";
    public String radio2 = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[2]";
    public String radio3 = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[3]";
    public String multiple = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select";
    public String dropDown = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[8]/td/select";
    public String cancelBtn = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[1]";
    public String submitBtn = "//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]";


    public AutomationPage1() {
        super(driver);
    }
    public void navigateToWeb() throws InterruptedException {
        navigateTo("https://testpages.herokuapp.com/styled/");
    }
}
