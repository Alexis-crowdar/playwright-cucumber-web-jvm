package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import setup.Context;

import tests.locators.HomePageComponents;
import tests.locators.LoginPageComponents;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.LocatorUtils.getLocator;

public class LoginPageDefinitions {
    @Given("that the user launched SwagLabs application")
    public void launch() {
        Context.getSession().navigate("https://www.saucedemo.com/");
    }

    @When("try to login with credentials username: {string} and password: {string}")
    public void login(String username, String password) {
        getLocator(LoginPageComponents.USERNAME).fill(username);
        getLocator(LoginPageComponents.PASSWORD).fill(password);
        getLocator(LoginPageComponents.LOGIN_BUTTON).click();
    }

    @Then("must visualize the home page")
    public void visualizeHome() {
        assertThat(getLocator(HomePageComponents.HEADER)).isVisible();
    }

    @Then("must not visualize the home page")
    public void notVisualiseHome() {
        assertThat(getLocator(HomePageComponents.HEADER)).not().isVisible();
    }
}