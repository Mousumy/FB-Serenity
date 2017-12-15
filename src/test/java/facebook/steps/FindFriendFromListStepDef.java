package facebook.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import facebook.steps.serenity.steps;

public class FindFriendFromListStepDef {

    @Steps
    steps step;

    @Given("^User can log in to facebook using userid as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_can_log_in_to_facebook_using_userid_as_and_password_as(String username, String password){
    	step.go_to_facebook_url();
    	step.login_to_facebook_using_userid_and_password(username,password);
    	step.landing_page_has_been_loaded_successfully(); 
    }
    
    @Then("^User profile has been loaded successfully$")
    public void user_profile_has_been_loaded_successfully(){
    	
    	step.user_will_go_to_profile(); 
    }

    @When("^User will search for \"([^\"]*)\"$")
    public void user_will_search_for(String name){
    	step.user_search_for_friend(name);  

    
    }
}