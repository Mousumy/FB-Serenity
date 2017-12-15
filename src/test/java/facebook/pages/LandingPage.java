package facebook.pages;

import jline.internal.Log;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class LandingPage extends PageObject{

    @FindBy(css="#u_0_a > div:nth-child(1) > div:nth-child(1)>div > a > span > span")
    private WebElementFacade btn_profile;
	
    @FindBy(css="[data-testid='left_nav_item_Enter Asm']")
    private WebElementFacade fld_Enter_Asm;
    
public void clickOnprofile(){
	 btn_profile.waitUntilVisible();
	 btn_profile.click();
	 Log.info("I just clicked on profile");
 	}

public void landingpageIsLoaded() {
	fld_Enter_Asm.waitUntilVisible();
	String value = fld_Enter_Asm.getText().trim();
	Log.info("Landing Page title = " + value);
	Assert.assertEquals("Enter Asm", value);
}

 
}