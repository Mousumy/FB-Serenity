package facebook.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.KeyStroke;

import jline.internal.Log;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Keyboard;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

import facebook.utils.MyHelperMethods;


public class ProfilePage extends PageObject{

	MyHelperMethods help;
	
    @FindBy(css="[data-tab-key='friends']")
    private WebElementFacade btn_friends;
	
    @FindBy(css="[placeholder='Search for your friends']")
    private WebElementFacade fld_input;
    
    @FindBy(css="[id^='typeahead_list_u_fetchstream'] a.name")
    private WebElementFacade friend_profile;

    @FindBy(css="[id^=u_jsonp_]> li:nth-child(2) > a")
    private WebElementFacade btn_about;
    
    @FindBy(css="a[data-testid='nav_overview']")
    private WebElementFacade btn_overview ;
    
    @FindBy(css="a[data-testid='nav_edu_work']")
    private WebElementFacade btn_nav_edu_work;
    
      
    @FindBy(css="[id^='u_fetchstream'] a > ._5kx5")
    private List<WebElementFacade> about_nav_list;
    
   
    @FindBy(css="#medley_header_about a")
    private WebElementFacade hdr_About;
   
       
    @FindBy(css="[id^='u_fetchstream'] ul > li:nth-child(1) > a > span._5pws._50f8._50f4._5kx5")
    private WebElementFacade test;
    
    @FindBy(css="[id*=u_]> li > a._6-6")
    private List<WebElementFacade> btn_profile_headers;
    
    
    @FindBy (css="._3ubp._sg2 ._5qtp")
    private List<WebElementFacade> btn_timeline_header;
    
    @FindBy (css="[id^=rc\2e]> div._3ubp._sg2 > span:nth-child(4) ._5qtp")
    private WebElementFacade btn_life_event;
    
    @FindBy (css="._40mo")
    private List<WebElementFacade> btn_list_life_event;
    
    @FindBy(css="._40ms")
    private List<WebElementFacade>btn_list_workeducation ;
    
    @FindBy (css="#fbTimelineHeadline a._p i") 
    private WebElementFacade btn_more;
    
    @FindBy (css="[id^='u_'] > div > ul > li:nth-child(7) > a > span > span")
    private List<WebElementFacade> fld_Book;
    
    @FindBy (css="._gx8[href='https://www.facebook.com/bookofmormon/?ref=profile']")
    private WebElementFacade fld_Book_icon;
    
//    need to tak to SAIAKT
    @FindBy(css=" ._40mu > li:nth-child(1)")
    private WebElementFacade btn_newjob;
    
    @FindBy(css="[id*=u_] .inputtext.autofocus.textInput")
    private WebElementFacade btn_employer;
    
    @FindBy (css=" span.text ")
    private List<WebElementFacade> link_employers;
    
    
	public void searchFriends(String name) {
		btn_friends.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible();
    	btn_friends.click();
    	fld_input.waitUntilVisible();
    	fld_input.sendKeys(name);
    	friend_profile.waitUntilPresent();
    	friend_profile.click();
    	Log.info("Searching for friend: " + name);
	}



	public void clickOnAboutTab() {
		System.out.println("about to click");
		btn_about.waitUntilVisible();
		btn_about.click();	
	}




	
	
//	check link is presnt with text
	
	public void linkIsPresent(String name) {	
//		about_nav_list.get(0).waitUntilVisible();		
		help.waitInSeconds(3);
//		System.out.println("---------" + test.getCssValue(getTitle()));		
		String linkName = null;
		for(int i=0; i<about_nav_list.size(); i++){			
			Log.info("Text->"+about_nav_list.get(i).getText());		
			if(about_nav_list.get(i).getText().trim().equalsIgnoreCase(name)){
				linkName = about_nav_list.get(i).getText();
				break;
			}
		}
		Log.info("Link Name is: " + linkName);
//		Assert.assertEquals(name, linkName);
	}

	


	public void clickOnTitle( String name) {
		btn_profile_headers.get(0).waitUntilVisible();		
		help.clickOnElementsByText(btn_profile_headers, name);	
		Log.info("Clicked on link " + name);
	}
	
	
	
//below is one___now
	
		public void ProfileHeader(String name) {
			btn_profile_headers.get(0).waitUntilVisible();
			String actualnam =help.clickOnElementFromListbyText(btn_profile_headers, name);
			Assert.assertEquals(name, actualnam);
			Log.info("header was------" +actualnam );			
		}
//below is two

	public void Timelineheader(String name) {	
		btn_timeline_header.get(0).waitUntilVisible();
		String act = help.clickOnElementFromListbyText(btn_timeline_header, name);		
		Assert.assertEquals(name, act);
		Log.info(" Header was-------"+  act);
	}


	
	

	public void lifeEventFunctionality_Is_Loaded(String name) {
//		waitFor("._40mo");
		btn_list_life_event.get(0).waitUntilVisible();
		help.clickOnElementFromListbyText(btn_list_life_event,name);
		Log.info("clicked on "+ name);
		btn_newjob.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible();
		btn_newjob.click();
		Log.info("I just clicked");
//        btn_employer.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible();
        help.waitInSeconds(3);
		btn_employer.sendKeys("uspto");
		help.waitInSeconds(2);
		
		for(int i=0; i<link_employers.size(); i++){
			String value = link_employers.get(i).getText().trim();
			if (value.equalsIgnoreCase("USPTO")){
				link_employers.get(i).click();
				break;
			}
		}
		
//		btn_employer.sendKeys(Keys.ARROW_DOWN);
//		btn_employer.sendKeys(Keys.ENTER);
		
		
		help.waitInSeconds(5);
		Log.info("I just input");		
	}

	
	

	public void navigateToLink(String name) {	
		help.clickOnElementFromListbyText(btn_profile_headers, name);
		Log.info("here is title------" + name);
		help.waitInSeconds(3);		
	}

	
@SuppressWarnings({ "unchecked", "rawtypes" })
	public void MoreFunctionIsLoaded() {	    
		help.hoverElement(btn_friends);
		help.hoverElement(btn_more);
		help.clickOnElementFromListbyText(fld_Book, "Books");
		Scroll.to(fld_Book_icon);
		fld_Book_icon.click();	
		help.waitInSeconds(3);		
		ArrayList<String> newTab = new ArrayList(getDriver().getWindowHandles());
		getDriver().switchTo().window(newTab.get(1));
		getDriver().close();
		getDriver().switchTo().window(newTab.get(0));
		
		
	
	}




	

}	   
      