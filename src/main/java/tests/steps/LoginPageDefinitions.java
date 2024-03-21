package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import setup.Context;
import tests.services.LoginPageServices;

public class LoginPageDefinitions {

    private final LoginPageServices loginPageServices = new LoginPageServices();

    @Given("that the user launched SwagLabs application")
    public void launch() {
        loginPageServices.launchApplication();
    }

    @When("try to login with credentials username: {string} and password: {string}")
    public void login(String username, String password) {
        loginPageServices.login(username, password);
    }

    @Then("must visualize the home page")
    public void visualizeHome() {
        loginPageServices.verifyHomePage();
    }

    @Then("must not visualize the home page")
    public void notVisualiseHome() {
        loginPageServices.verifyNotHomePage();
    }
}