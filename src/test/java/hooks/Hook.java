package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import setup.Context;

public class Hook {
    @Before
    public void setup() {
        Context.getSession().createFirefoxInstance();
    }

    @After
    public void close() {
        Context.getSession().finishSession();
    }
}
