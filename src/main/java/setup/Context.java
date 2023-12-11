package setup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Context implements BrowserLauncher {
    private static final ThreadLocal<Context> SESSION = new ThreadLocal<>();
    private static final Playwright playwright;
    private Browser browser;
    private Page page;

    static {
        playwright = Playwright.create();
    }

    protected Context() {
    }

    public static Context getSession() {
        if (SESSION.get() == null) {
            SESSION.set(new Context());
        }

        return SESSION.get();
    }

    private synchronized void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public synchronized Browser getBrowser() {
        return this.browser;
    }

    private synchronized void setPage(Page page) {
        this.page = page;
    }

    public synchronized Page getPage() {
        return this.page;
    }

    @Override
    public void createFirefoxInstance() {
        this.launch(playwright.firefox());
    }

    @Override
    public void createChromiumInstance() {
        this.launch(playwright.chromium());
    }

    @Override
    public void createWebKitInstance() {
        this.launch(playwright.webkit());
    }

    public void launch(BrowserType browserType) {
        Browser browser = browserType.launch(
                new BrowserType.LaunchOptions().setHeadless(false));

        setBrowser(browser);
    }

    public void navigate(String url) {
        setPage(getBrowser().newPage());
        getPage().navigate(url);
        getPage().waitForLoadState();
    }

    public void finishSession() {
        if (SESSION.get() != null) {
            this.finishBrowserSession();
            SESSION.remove();
        }
    }

    private void finishBrowserSession() {
        if (SESSION.get().getBrowser() != null) {
            SESSION.get().getBrowser().close();
        }
    }
}