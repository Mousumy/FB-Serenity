package facebook.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import jline.internal.Log;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.pages.PageObject;


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
    
    @FindBy(css="#pagelet_edit_eduwork ._21ok._50f5")
    private List<WebElementFacade> btn_wrk_edu;
    
    @FindBy(css="[class='inputtext textInput']")
    private List<WebElementFacade> flds_input_w_E;
    
    
   
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
    
//    need to tak to SAIkaT
    @FindBy(css=" ._40mu > li:nth-child(1)")
    private WebElementFacade btn_newjob;
    
    @FindBy(css="[id*=u_] .inputtext.autofocus.textInput")
    private WebElementFacade btn_employer;
    
    @FindBy (css=" span.text ")
    private List<WebElementFacade> link_employers;
    
    @FindBy (css=" [id*=u_]._4xev ")
    private List<WebElementFacade> lnk_editposts;
    
    @FindBy (css="[id*=u_] ._52jv .pts ")
    private WebElementFacade btn_footer;
    
    @FindBy(css="span._54nh")
    private List<WebElementFacade> lnk_prostitems;
    
    @FindBy(css="._5a8u > button")
    private WebElementFacade btn_hide;
    
    @FindBy(css="._5a8u > button")
    private WebElementFacade btn_deltpost;
    
    @FindBy(css="[id*=u_fetchstream] ._5lum ._ohe")
    private WebElementFacade lnk_notify;
//    MAkeAPost_OBJECT
    
    @FindBy(css="[data-tooltip-content='Make Post']")
    private WebElementFacade btn_makepost;
    
    @FindBy(css="[id*=js] > ._1j2v ._16ve ._2aha")
    private List<WebElementFacade> btns_postinfo;
    
    @FindBy(css="[id*=js] ._4-u3._4-u8   button ")
    private WebElementFacade btn_post;
    
    @FindBy(css="[data-tooltip-content='Feeling/Activity']")
    private WebElementFacade btn_feeing_act;
    
    @FindBy(css="[data-tooltip-content='Check in']")
    private WebElementFacade btn_checkin;
    
    @FindBy(css="[id*=js_] > input")
    private WebElementFacade input_fld;
    
    @FindBy(css="[class='currentCheckbox uiInputLabelInput uiInputLabelCheckbox']")
    private WebElementFacade chk_box;
     
    @FindBy(css="[aria-label='Story']")
    private WebElementFacade txt_story;
    
    @FindBy(css="[name='cancel']")
    private WebElementFacade btn_cancl;
    
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
		chk_box.waitUntilPresent().click();
		txt_story.sendKeys("I am very happy");
		help.waitInSeconds(2);
		btn_cancl.waitUntilVisible().click();
		help.waitInSeconds(2);
		
		
		
		
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



public void randomlySelectPost() {
	help.waitInSeconds(3);
	lnk_editposts.get(0).waitUntilPresent().click();
//	int postCt = lnk_editposts.size();	
	
}



public void verifyEditPostFunctionality(String func) {
	help.waitInSeconds(2);
	lnk_prostitems.get(0).waitUntilVisible();
	int postItemsCt = lnk_prostitems.size();
	String value1 = "Remove tag";
	String value2 = "Edit Tag";
	String value3 = "Hide From TimeLine";
	String value4 = "Turn off notifications for this post";
	
	for(int i = 0; i<postItemsCt ; i ++ ){
		if (lnk_prostitems.get(i).getText().equalsIgnoreCase(value1) && func.equalsIgnoreCase(value1)){
			lnk_prostitems.get(i).click();
			help.waitInSeconds(2);
			btn_deltpost.click();
			help.waitInSeconds(2);
			Log.info(value1 + " Has been clicked");
//			code
			
			break;
			
		}else if (lnk_prostitems.get(i).getText().equalsIgnoreCase(value2) && func.equalsIgnoreCase(value2)){
			lnk_prostitems.get(i).click();
			Log.info(value2 + " Has been clicked");
//			code
			
			break;
			
		}else if (lnk_prostitems.get(i).getText().equalsIgnoreCase(value3) && func.equalsIgnoreCase(value3)){
			lnk_prostitems.get(i).click();
			Log.info(value3 + " Has been clicked");
			help.waitInSeconds(2);
			btn_hide.click();
			Log.info("clicked on hide");
			
//			code			
			break;
			
		}else if (lnk_prostitems.get(i).getText().equalsIgnoreCase(value4) && func.equalsIgnoreCase(value4)){
			lnk_prostitems.get(i).click();
			Log.info(value4 + " Has been clicked");
//			lnk_notify.waitUntilPresent();
			help.waitInSeconds(2);
			String lnkname=lnk_notify.getText().trim();
			Assert.assertEquals(lnkname, "You'll no longer get notifications about this post."); 
//			code			
			break;
			
		}
	}
	
}



public void MakeAPost() {
	help.waitInSeconds(2);
	btn_makepost.click();
//	without this stale element error
	help.waitInSeconds(2); 
	btn_feeing_act.click();
	help.waitInSeconds(2);
	input_fld.waitUntilPresent().sendKeys("Celebrating...");
	input_fld.sendKeys(Keys.ENTER);
	help.waitInSeconds(1);
	input_fld.sendKeys("a birthdy");
	input_fld.sendKeys(Keys.ENTER);	
	help.waitInSeconds(2);
//	Scroll.to(btn_post);
	btn_post.waitUntilVisible().click();
	help.waitInSeconds(2);
	Log.info("make a post");
	
	
	
	

//	Assert.assertEquals("", "");
	
	
	
//	btn_feel.click();
//	help.waitInSeconds(3);
//	help.hoverElement(btn_postinfo.get(btn_postinfo.size()-1));
//	help.waitInSeconds(1);
//	Log.info("SCROLLED DOWN");
//	Scroll.to(btns_postinfo.get(2));
//	
//	try {
//		btn_postinfo.wait(3);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	help.clickOnElementsByText(btn_postinfo, "Feeling/Activity");
//	help.waitInSeconds(3);
		
//	Scroll.to(lnk_editposts.get(lnk_editposts.size()-1));
	
}

	public void PostIsVisible() {
	}



	
	public void WorkAndEducationFrmAbt() {
		System.out.println("------------JUST CAME__________");
		btn_nav_edu_work.waitUntilVisible();
		btn_nav_edu_work.click();
		Log.info("clicked on work--->" );
		int count= btn_wrk_edu.size();
		for(int i=0;i<count;i++){
		if (btn_wrk_edu.get(i).getText().equalsIgnoreCase("Add a workplace")){
			btn_wrk_edu.get(i).click();
			help.waitInSeconds(2);
			Log.info("clicked on add a workplace");
			flds_input_w_E.get(0).waitUntilVisible().sendKeys("Self-Employed");
			flds_input_w_E.get(0).sendKeys(Keys.ARROW_DOWN);
			help.waitInSeconds(1);
			flds_input_w_E.get(0).sendKeys(Keys.ENTER);
			help.waitInSeconds(2);
			flds_input_w_E.get(1).waitUntilVisible().sendKeys("IT assistant");
			flds_input_w_E.get(1).sendKeys(Keys.ENTER);
			help.waitInSeconds(1);
			flds_input_w_E.get(2).waitUntilVisible().sendKeys("Burke, Virginia");		
			flds_input_w_E.get(2).sendKeys(Keys.ENTER);
			help.waitInSeconds(3);
//			save
//			boolean value1= css.getText().contains("self-employed");
//			Assert.assertTrue("is not present", value1==value2==value3==true);
//			Assert.assertTrue("is not present", value1);
//			Assert.assertTrue("is not present", value2;
//			Assert.assertTrue("is not present", value3);
			break;
			
		}
	
			
		else if (btn_wrk_edu.get(i).getText().equalsIgnoreCase("Add a school")){
			btn_wrk_edu.get(i).click();
		}
			
		else if (btn_wrk_edu.get(i).getText().equalsIgnoreCase("Add a college")){
			btn_wrk_edu.get(i).click();
		}
		else if(btn_wrk_edu.get(1).getText().equalsIgnoreCase("Add a high school")){
			btn_wrk_edu.get(i).click();
		}
	
		
	}
//		save
//		assert
	
	}	
	
	
	
	
	
	
	
	
}


      