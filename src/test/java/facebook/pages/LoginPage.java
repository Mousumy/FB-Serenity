package facebook.pages;

import java.util.concurrent.TimeUnit;

import jline.internal.Log;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.facebook.com/")
public class LoginPage extends PageObject {

    @FindBy(css="#blueBarDOMInspector i")
    private WebElementFacade lgo_facebook;

    @FindBy(css="#email")
    private WebElementFacade fld_email;

    @FindBy(css="#pass")
    private WebElementFacade fld_password;
    
    @FindBy(css="[data-testid='royal_login_button']")
    private WebElementFacade btn_login;
    
    @FindBy(css="#content ._8wm ._ihd._3ma._6s")
    private WebElementFacade fld_recent_login;
    



public void loginToFacebook(String username, String password){
	getDriver().manage().window().maximize();
	fld_email.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible();
	fld_email.sendKeys(username);
	fld_password.sendKeys(password);
	btn_login.waitUntilVisible();
	btn_login.click();	
	Log.info("Facebook login has been succesful");
}

public void verifyLoginPageIsLoaded(){
	fld_recent_login.waitUntilVisible();
	String value = fld_recent_login.getText().trim();
	Assert.assertEquals("Recent Logins", value);
}
    


}