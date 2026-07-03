package attributes;

import org.openqa.selenium.By;

public class HomeAttributes {
    protected static final By HeaderSearch = By.id("headerSearch");

    protected static final By LoginBtn = By.cssSelector("button[data-testid='ptz-button-entrar']");

    protected  static final By LoginMouseOver = By.cssSelector(".ptz-header-profile");

    protected static final By CookieButton = By.id("onetrust-accept-btn-handler");

}
