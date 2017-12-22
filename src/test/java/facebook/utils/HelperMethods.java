//package facebook.utils;
//
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import net.serenitybdd.core.Serenity;
//import net.serenitybdd.core.SerenitySystemProperties;
//import net.serenitybdd.core.annotations.findby.By;
//import net.serenitybdd.core.pages.WebElementFacade;
//import net.thucydides.core.ThucydidesSystemProperty;
//import net.thucydides.core.pages.PageObject;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.LocalFileDetector;
//import org.openqa.selenium.remote.RemoteWebElement;
//
//import facebook.pages.LoginPage;
//
//public class HelperMethods extends PageObject {
//	public final static Logger log = LogManager.getLogger(LoginPage.class);
//	public Utility utility = new Utility();
//	
////	--------------------------PRIDE
//	
//	public void clickOnElement(WebElementFacade webelement) {
//		webelement.waitUntilClickable();
//		webelement.click();
//		log.info("Element "+ webelement.getText() + "has been clicked on.");
//	}
//	
//	public void navigateURL() {
//		getDriver().manage().window().maximize();
//		getDriver().navigate().to("https://uxvnwg001a1281.sat.cbp.dhs.gov:9400/");
//		utility.waitInSeconds(4);
//	}
//	
////	--------------------------PRIDE
//	
//
//	/*
//	 * Generic Method to Input Data
//	 */
//	public void inputData(String logmessage, String inputtext, WebElementFacade inputelement) {
//		log.info(logmessage + ":" + inputtext);
//		inputelement.withTimeoutOf(2, TimeUnit.SECONDS).waitUntilVisible().click();
//		inputelement.clear();
//		inputelement.sendKeys(inputtext);
//		inputelement.sendKeys(Keys.DOWN);
//		inputelement.sendKeys(Keys.TAB);
//	}
//
//	/*
//	 * Select Input type
//	 */
//	public void selectInputType(String logmessage, String inputtext, WebElementFacade inputelement) {
//		log.info(logmessage + ":" + inputtext);
//		inputelement.withTimeoutOf(2, TimeUnit.SECONDS).waitUntilVisible();
//		inputelement.selectByVisibleText(inputtext);
//
//	}
//
//	/*
//	 * Generic Method For Navigation To TAB or Menu Item
//	 */
//
//	public void navigateToTabOrMenu(String logmessage, WebElementFacade navelement) {
//		log.info(logmessage);
//		navelement.waitUntilVisible();
//		navelement.click();
//
//	}
//
//	public void clickElement(String logmessage, WebElementFacade inputelement) {
//		log.info(logmessage);
//		inputelement.waitUntilVisible();
//		inputelement.click();
//
//	}
//
//	public void switchToChildWindow() throws Exception {
//		log.debug("Switch to Popup Window");
//		String childWindow = null, mainwindow = null;
//		int counter = 1;
//		for (String popup : getDriver().getWindowHandles()) {
//			log.debug("WindowHandles " + counter + ":" + popup + "Window Title:" + getDriver().getTitle());
//			getDriver().switchTo().window(popup);
//
//			if (getDriver().getTitle().equals("Biometric Dashboard")) {
//				mainwindow = getDriver().getWindowHandle();
//				Serenity.setSessionVariable("mainwindowhandle").to(mainwindow);
//				log.debug("Main Window handle Saved : " + mainwindow);
//
//			} else {
//				childWindow = getDriver().getWindowHandle();
//				Serenity.setSessionVariable("childWindow").to(childWindow);
//				log.debug("Child Window handle Saved : " + childWindow);
//			}
//			counter++;
//		}
//
//		log.debug("Windows Present are mainwindow:" + mainwindow + " childWindow :" + childWindow);
//
//		getDriver().switchTo().window(childWindow);
//
//	}
//
//
//	public void getWindowHandle(String windowTitle) throws Exception {
//		Thread.sleep(5000);
//		log.info("Capture Window Handle:" + windowTitle);
//
//		for (String windowHandle : getDriver().getWindowHandles()) {
//			log.debug(getDriver().getWindowHandles());
//			getDriver().switchTo().window(windowHandle);
//			log.debug("Window:" + getDriver().getTitle() + ":" + windowHandle);
//			if (getDriver().getTitle().equals(windowTitle)) {
//						Serenity.setSessionVariable("childwindow").to(windowHandle);
//			} else {
//				Serenity.setSessionVariable("parentwindow").to(windowHandle);
//			}
//		}
//	}
//
//	public void switchToWindow(String windowTitle) throws Exception {
//		log.info("Switch to Window:" + windowTitle);
//		String propkey = windowTitle.trim().replace(" ", "");
//		getDriver().switchTo().window(Serenity.sessionVariableCalled("childwindow"));
//		// getDriver().switchTo().window(props.get("childwindow"));
//		log.info("Switched to Window:" + getDriver().getTitle());
//		Thread.sleep(2000);
//		getDriver().manage().window().maximize();
//	}
//
//	public void uploadImages(String inputString, String element) throws Exception {
//		try {
//
//			WebElement upload = getDriver().findElement(By.xpath(element));
//			// String use_hub = page.app.cfg.gets("use_hub");
//			String use_hub = SerenitySystemProperties.getProperties()
//					.getValue(ThucydidesSystemProperty.WEBDRIVER_REMOTE_DRIVER);
//
//			log.info("use_hub set to >" + use_hub + "<");
//			if (use_hub != null && !use_hub.isEmpty()) {
//				((RemoteWebElement) upload).setFileDetector(new LocalFileDetector());
//				log.info("Remote Hub");
//
//			} else {
//				inputString = inputString.replaceAll("/", "\\\\");
//			}
//			Thread.sleep(2000);
//			((JavascriptExecutor) getDriver()).executeScript(
//					"arguments[0].style.display='block'; arguments[0].style.visibility='visible'; "
//							+ "arguments[0].style.height='1px'; arguments[0].style.width='1px'; arguments[0].style.opacity=1",
//					upload);
//
//			log.info("Java Script Executed");
//			log.info("File Path is :" + inputString);
//
//			upload.sendKeys(inputString);
//			Thread.sleep(2000);
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			log.info("Could'nt upload data !" + ex.getMessage());
//		}
//
//	}
//
//
//	
//	  public boolean checkElementPresent(org.openqa.selenium.By by) throws InterruptedException {
//	        return checkElementPresent(by, 60);
//	        
//	    }
//
//	public boolean checkElementPresent(org.openqa.selenium.By by, int time) throws InterruptedException {
//		log.debug("Check Element Present :" + by);
//
//		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//
//		List<WebElement> popupElem = getDriver().findElements(by);
//		log.debug("Pop:" + popupElem);
//		boolean isElementPresent;
//		long endTime = 0;
//		if (popupElem.size() != 0) {
//			isElementPresent = true;
//			log.debug("Popup Element : " + popupElem + ":" + isElementPresent);
//
//		} else {
//			isElementPresent = false;
//			endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(time);
//			log.debug("End Time : " + endTime);
//		}
//
//		while (isElementPresent == false) {
//			Thread.sleep(1);
//			List<WebElement> popupAfter = getDriver().findElements(by);
//			if (!popupAfter.isEmpty()) {
//				isElementPresent = true;
//				log.debug("Popup Element : " + popupElem + ":" + isElementPresent);
//				break;
//			}
//			if (System.currentTimeMillis() > endTime) {
//				break;
//			}
//
//		}
//		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		log.debug("Check Element Present Ended");
//		return isElementPresent;
//
//	}
//}
//
//
