package utils;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import setup.Context;
import com.microsoft.playwright.Page;

import java.util.List;


public final class LocatorUtils {
    private LocatorUtils() {
    }

    public static Locator getLocator(String locatorString) {
        return Context.getSession().getPage().locator(locatorString);
    }

    // Click with explicit waiting for presence and clickability
    public static void click(String locatorString) {
        getLocator(locatorString).click();
    }

    // Fill with explicit waiting for presence
    public static void fill(String locatorString, String value) {
        getLocator(locatorString).fill(value);
    }

    public static String getText(String locatorString) {
        return getLocator(locatorString).textContent();
    }

    public static boolean isVisible(String locatorString) {
        return getLocator(locatorString).isVisible();
    }


    // Additional methods inspired by the provided code

    public static String getAttribute(String locatorString, String attribute) {
        return getLocator(locatorString).getAttribute(attribute);
    }

    public static List<Locator> getLocators(String locatorString) {
        return getLocator(locatorString).queryAllSelectors(locatorString);
    }

    public static boolean isEnabled(String locatorString) {
        return getLocator(locatorString).isEnabled();
    }

    public static boolean isSelected(String locatorString) {
        Locator element = getLocator(locatorString);
        return (boolean) element.evaluate("el => el.selected");
    }

    public static void scrollIntoView(String locatorString) {
        getLocator(locatorString).scrollIntoViewIfNeeded();
    }

    // You can add more methods for common interactions or specific needs

    public static void selectByValue(String locatorString, String value) {
        getLocator(locatorString).selectOption(value);
    }

    public static void clear(String locatorString) {
        getLocator(locatorString).fill("");
    }

    public static void hover(String locatorString) {
        getLocator(locatorString).hover();
    }

    // Wait for element to be not visible
    public static void waitForNotVisible(String locatorString) {
        Locator elementLocator = getLocator(locatorString);
        elementLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }

    // Wait for element to be disabled
    public static void waitForDisabled(String locatorString) {
        Locator elementLocator = getLocator(locatorString);
        elementLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.DETACHED));
    }
    public static void waitForVisible(String locatorString) {
        Locator elementLocator = getLocator(locatorString);
        elementLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

}