package tests.services;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.LocatorUtils.getLocator;

import setup.Context;
import tests.locators.HomePageComponents;
import tests.locators.LoginPageComponents;

public class LoginPageServices {

    public void launchApplication() {
        Context.getSession().navigate("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        getLocator(LoginPageComponents.USERNAME).fill(username);
        getLocator(LoginPageComponents.PASSWORD).fill(password);
        getLocator(LoginPageComponents.LOGIN_BUTTON).click();
    }

    public void verifyHomePage() {
        assertThat(getLocator(HomePageComponents.HEADER)).isVisible();
    }

    public void verifyNotHomePage() {
        assertThat(getLocator(HomePageComponents.HEADER)).not().isVisible();
    }
}