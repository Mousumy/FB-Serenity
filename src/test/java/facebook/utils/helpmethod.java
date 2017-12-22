package facebook.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//import gov.cbp.dhs.pride.pages.EntitlementPage;
import jline.internal.Log;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.pages.PageObject;

	public class helpmethod extends PageObject {
//	public final static Logger log = LogManager.getLogger(EntitlementPage.class);
	public Utility util = new Utility();
	
	public void ignoreStaleElementError(WebElementFacade webElement, long timeOutInSeconds ) {
//		new WebDriverWait(getDriver(), timeoutInSeconds).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
	
		long time1  = System.currentTimeMillis();
		try {
			webElement.isCurrentlyEnabled();
		}catch(Exception t){
			new WebDriverWait(getDriver(), timeOutInSeconds).ignoring(RuntimeException.class).until(ExpectedConditions.elementToBeClickable(webElement));
			boolean value = webElement.isCurrentlyEnabled();
			Log.info("Ignored Exception and current element enability is: " + value);
			long time2  = System.currentTimeMillis();
			Log.info("Total time taken to Ignore Error is = " + (time2-time1)/1000 + " Seconds");
		}
	}
	
    public void scrollIntoViewJS(WebElementFacade webElement) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        Log.info("Scrolled in to Element using JavaScript: " + webElement);
    }
//CLICK + SCROLL
    public void clickOnElementJS(WebElementFacade webElement) {
        scrollIntoViewJS(webElement);
        ignoreStaleElementError(webElement, 15);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", webElement);
        Log.info("Clicked on Element using JavaScript: " + webElement);
    }

	public void switchToChildWindow() throws Exception {
		Log.debug("Switch to Popup Window");
		String childWindow = null, mainwindow = null;
		int counter = 1;
		for (String popup : getDriver().getWindowHandles()) {
			Log.debug("WindowHandles " + counter + ":" + popup + "Window Title:" + getDriver().getTitle());
			getDriver().switchTo().window(popup);

			if (getDriver().getTitle().equals("Biometric Dashboard")) {
				mainwindow = getDriver().getWindowHandle();
				Serenity.setSessionVariable("mainwindowhandle").to(mainwindow);
				Log.debug("Main Window handle Saved : " + mainwindow);

			} else {
				childWindow = getDriver().getWindowHandle();
				Serenity.setSessionVariable("childWindow").to(childWindow);
				Log.debug("Child Window handle Saved : " + childWindow);
			}
			counter++;
		}

		Log.debug("Windows Present are mainwindow:" + mainwindow + " childWindow :" + childWindow);

		getDriver().switchTo().window(childWindow);

	}


	public void getWindowHandle(String windowTitle) throws Exception {
		Thread.sleep(5000);
		Log.info("Capture Window Handle:" + windowTitle);
		Log.info("");

		for (String windowHandle : getDriver().getWindowHandles()) {
			Log.debug(getDriver().getWindowHandles());
			getDriver().switchTo().window(windowHandle);
			Log.debug("Window:" + getDriver().getTitle() + ":" + windowHandle);
			if (getDriver().getTitle().equals(windowTitle)) {
						Serenity.setSessionVariable("childwindow").to(windowHandle);
			} else {
				Serenity.setSessionVariable("parentwindow").to(windowHandle);
			}
		}
	}

	public void switchToWindow(String windowTitle) throws Exception {
		Log.info("Switch to Window:" + windowTitle);
//		String propkey = windowTitle.trim().replace(" ", "");
		getDriver().switchTo().window(Serenity.sessionVariableCalled("childwindow"));
		// getDriver().switchTo().window(props.get("childwindow"));
		Log.info("Switched to Window:" + getDriver().getTitle());
		Thread.sleep(2000);
		getDriver().manage().window().maximize();
	}

	public void uploadImages(String inputString, String element) throws Exception {
		try {

			WebElement upload = getDriver().findElement(By.xpath(element));
			// String use_hub = page.app.cfg.gets("use_hub");
			String use_hub = SerenitySystemProperties.getProperties()
					.getValue(ThucydidesSystemProperty.WEBDRIVER_REMOTE_DRIVER);

			Log.info("use_hub set to >" + use_hub + "<");
			if (use_hub != null && !use_hub.isEmpty()) {
				((RemoteWebElement) upload).setFileDetector(new LocalFileDetector());
//				log.info("Remote Hub");

			} else {
				inputString = inputString.replaceAll("/", "\\\\");
			}
			Thread.sleep(2000);
			((JavascriptExecutor) getDriver()).executeScript(
					"arguments[0].style.display='block'; arguments[0].style.visibility='visible'; "
							+ "arguments[0].style.height='1px'; arguments[0].style.width='1px'; arguments[0].style.opacity=1",
					upload);

			Log.info("Java Script Executed");
			Log.info("File Path is :" + inputString);

			upload.sendKeys(inputString);
			Thread.sleep(2000);

		} catch (Exception ex) {
			ex.printStackTrace();
			Log.info("Could'nt upload data !" + ex.getMessage());
		}

	}

	public boolean checkElementPresent(org.openqa.selenium.By by) throws InterruptedException {
	        return checkElementPresent(by, 60);
	        
	    }

	public boolean checkElementPresent(org.openqa.selenium.By by, int time) throws InterruptedException {
		Log.debug("Check Element Present :" + by);

		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		List<WebElement> popupElem = getDriver().findElements(by);
		Log.debug("Pop:" + popupElem);
		boolean isElementPresent;
		long endTime = 0;
		if (popupElem.size() != 0) {
			isElementPresent = true;
			Log.debug("Popup Element : " + popupElem + ":" + isElementPresent);

		} else {
			isElementPresent = false;
			endTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(time);
			Log.debug("End Time : " + endTime);
		}

		while (isElementPresent == false) {
			Thread.sleep(1);
			List<WebElement> popupAfter = getDriver().findElements(by);
			if (!popupAfter.isEmpty()) {
				isElementPresent = true;
				Log.debug("Popup Element : " + popupElem + ":" + isElementPresent);
				break;
			}
			if (System.currentTimeMillis() > endTime) {
				break;
			}

		}
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Log.debug("Check Element Present Ended");
		return isElementPresent;

	}
	
}
