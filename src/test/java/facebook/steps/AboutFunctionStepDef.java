package facebook.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import facebook.steps.serenity.steps;

public class AboutFunctionStepDef {
	 @Steps
	 steps step;

	
//	@Given("^User will navigate to About tab$")
//	public void user_will_navigate_to_About_tab(){
//	   step.user_will_go_to_About_tab();	   
//	  }
	 
	
	
	
	
	
	
	
	
//	@Given("^User will navigate to all links$")
//	public void user_will_navigate_to_all_links(){
//		step.user_will_navigate_link();
//	    
//	}
	
	@Given("^About tab has this feature option \"([^\"]*)\"$")
	public void about_tab_has_this_feature_option(String name){
		step.user_will_go_to_About_tab();	
		step.verify_link_is_present(name);
	}


//	@Given("^ User will click on overview$")
//	public void User_will_click_on_overview(){
//		step.user_will_navigate_link();
//	}
	    
	
}
