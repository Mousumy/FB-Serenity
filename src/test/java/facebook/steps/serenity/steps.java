package facebook.steps.serenity;

import facebook.pages.LandingPage;
import facebook.pages.LoginPage;
import facebook.pages.ProfilePage;
import net.thucydides.core.annotations.Step;


public class steps {

	LoginPage loginpage;
	ProfilePage profilepage;
	LandingPage landingpage;

    @Step
    public void enters(String keyword) {
        
    }

    @Step
	public void go_to_facebook_url() {
    	loginpage.open();
	}

    @Step
	public void login_to_facebook_using_userid_and_password(String username,
			String password) {
    	loginpage.loginToFacebook(username, password);
	}

    @Step
	public void login_page_has_been_loaded() {
		loginpage.verifyLoginPageIsLoaded();
	}
    
    @Step
    public void profilpage_header_is_present(String name) {
 	profilepage.ProfileHeader(name);
 	
 }

   
   @Step
   public void user_will_go_to_profile() {
	   landingpage.clickOnprofile();
   }

   public void landing_page_has_been_loaded_successfully() {
	   landingpage.landingpageIsLoaded();
	
   }
   
   @Step
   public void user_search_for_friend(String name) {
	   profilepage.searchFriends(name);
   }
   
   @Step
	public void user_will_go_to_About_tab() {
	   profilepage.clickOnAboutTab();

	
}
//   @Step
//   public void user_will_navigate_link() {
//	   profilepage.navigateToLink();
//	
//}
//   
   @Step
   public void verify_link_is_present(String link) {
	   profilepage.linkIsPresent(link);
   }
   @Step
   public void header_is_present(String name) {
	profilepage.Timelineheader(name);
	
}
   @Step
   public void user_will_navigate(String name) {
	profilepage.navigateToLink(name);
	
}

   @Step
   public void moreFunctionIsWorked() {
	   profilepage.MoreFunctionIsLoaded();
   }

   
   @Step
   public void lifeEventFunctionality_Is_Loaded(String name) {
	profilepage.lifeEventFunctionality_Is_Loaded(name);
	
   }


	
}



