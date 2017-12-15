package facebook.utils;

import java.util.List;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;

public class MyHelperMethods extends PageObject{
	
	
	
	@SuppressWarnings("unused")
	public void clickOnElementsByText(List<WebElementFacade> elements ,String name) {
			for(int i = 0;i < elements.size(); i++){
				elements.get(i).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 break;
			}	
		}
	
	public void waitInSeconds(int seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void goToWindowAndClose(int num, String YesNo){
		
		
	}
	
	public String clickOnElementFromListbyText(List<WebElementFacade> elements ,String name) {		
		String actual_name=null;
		for(int i=0; i<elements.size(); i++){					
			if(elements.get(i).getText().trim().equalsIgnoreCase(name)){
				actual_name=elements.get(i).getText().trim();
				elements.get(i).click();
				break;
			}
		}
		return actual_name;
	}

	
//	public String clickOnElementsAndAssert( List<WebElementFacade>linksname, String name){
//		String actualname = null;
//		for(int i=0;i<linksname.size();i++){
//			if(linksname.get(i).getText().trim().equalsIgnoreCase(name)){
//				actualname=linksname.get(i).getText().trim();
//				linksname.get(i).click();
//				break;
//			}
//		}
//		return actualname;
//		
//	}
	
	public boolean verifyPageIsLoaded(String name){
		
		return false;
		
		
	}
//	MOUSEHOVER OVER ELEMENT
	
	public void hoverElement(WebElementFacade element) {
	    Actions builder = new Actions(getDriver());
	    Actions hoverOverLocationSelector = builder.moveToElement(element);
	    hoverOverLocationSelector.perform();
	}
	
	public void scrollIntoView(WebElementFacade element){
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
public void All_tabs_are_present(){
	
//	List<String> names = table.asList(String.class);
//	System.out.println(**************);
//	for(int i=0; i<names.size();i++);
//	Assert.assertTrue("Element not found in menu" +names.get(i),selenium.isElementpresent(object));
//	
//	Assert.assertTrue(message, condition);
	
	
}
//below method and background should be common util class.and username and password in config file
//You cannot parameterize the background rather scenario
	public void Runmode_is(String runmode){
		if(runmode.equalsIgnoreCase("N"))
			throw new PendingException("Skipping the test as Runmode is No");
	}
	
}





////just navigate to all link loopwise
//
//	public void navigateToLink() {
//	 List<WebElementFacade>links = about_nav_list;	
//		for(int i = 0;i < links.size(); i++){
//			links = about_nav_list;
//			links.get(i).click();
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
////		 break;
//		}	
//	}