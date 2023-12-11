package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import setup.Context;

import utils.PropertyManager;

public class Hook {
    @Before
    public void setup() {
        String browser = PropertyManager.getProperty("browser");
        if (browser == null || browser.isEmpty()) {
            throw new UnsupportedOperationException("The browser property must be not be null or empty.\nPlease, specify a valid profile");
        }

        Context.getSession().createBrowserInstance(browser);
    }

    @After
    public void close() {
        Context.getSession().finishSession();
    }
}
