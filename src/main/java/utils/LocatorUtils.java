package utils;

import com.microsoft.playwright.Locator;

import setup.Context;

public final class LocatorUtils {
    private LocatorUtils() {
    }

    public static Locator getLocator(String locatorString) {
        return Context.getSession().getPage().locator(locatorString);
    }
}