package facebook.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import facebook.steps.serenity.steps;

 

public class Profile_page_step_def {
	@Steps
	steps step; 
	
	@Then("^Verify this header \"([^\"]*)\" is present$")
	public void verify_this_header_is_present(String name){
		step.profilpage_header_is_present(name);
		
	   
	}
	
	@When("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String title){
	    step.user_will_navigate(title);
	}
	
	@Given("^About tab has this feature option \"([^\"]*)\"$")
	public void about_tab_has_this_feature_option(String name){
//		step.user_will_go_to_About_tab();	
//		step.verify_link_is_present(name);
		step.WorkAndEducationFrmAbt();
		
	}

	@When("^Verify header \"([^\"]*)\" is present$")
	public void verify_header_is_present(String name){
		step.header_is_present(name);
	    
	}

	@Then("^Verify \"([^\"]*)\" funtionality should work$")
	public void verify_funtionality_should_work(String name){
		step.lifeEventFunctionality_Is_Loaded(name);
	}
	

	@Then("^verify more functionality is working$")
	public void verify_more_functionality_is_working(){
		step.moreFunctionIsWorked();
	    
	}
	
	@When("^User will randomly select post$")
	public void user_will_randomly_select_post(){
	    step.randomlySelectPost();
	}

	@Then("^\"([^\"]*)\" functionality should work$")
	public void functionality_should_work(String func){
	    step.verifyEditPostFunctionality(func);
	}

	@When("^User will make new post$")
	public void user_will_make_new_post(){
		step.MakeAPost();
	    
	}


	@Then("^It wil be visible in timeline$")
	public void it_wil_be_visible_in_timeline(){
		step.PostIsVisible();
	    
	}

}
