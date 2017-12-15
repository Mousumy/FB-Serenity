package facebook.steps;

import net.thucydides.core.annotations.Steps;
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

	@When("^Verify header \"([^\"]*)\" is present$")
	public void verify_header_is_present(String name){
		step.header_is_present(name);
	    
	}

	@Then("^Verify \"([^\"]*)\" funtionality should work$")
	public void verify_funtionality_should_work(String name){
		step.lifeEventFunctionality_Is_Loaded(name);
	}
	
//	@When("^Go to more$")
//	public void go_to_more(){
//		step.go_to_more();
//
//	}

	@Then("^verify more functionality is working$")
	public void verify_more_functionality_is_working(){
		step.moreFunctionIsWorked();
	    
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
