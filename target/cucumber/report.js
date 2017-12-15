$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/consult_dictionary/ProfilePageVerification.feature");
formatter.feature({
  "name": "I need to check all Headers",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User can log in to facebook using userid as \"asmenterprise.llc@gmail.com\" and password as \"ctg310306\"",
  "keyword": "Given "
});
formatter.match({
  "location": "FindFriendFromListStepDef.user_can_log_in_to_facebook_using_userid_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User profile has been loaded successfully",
  "keyword": "And "
});
formatter.match({
  "location": "FindFriendFromListStepDef.user_profile_has_been_loaded_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Timeline functionality verification",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@quicktest"
    }
  ]
});
formatter.step({
  "name": "Navigate to \"Timeline\"",
  "keyword": "When "
});
formatter.match({
  "location": "Profile_page_step_def.navigate_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify header \"Life Event\" is present",
  "keyword": "And "
});
formatter.match({
  "location": "Profile_page_step_def.verify_header_is_present(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify \"Work \u0026 Education\" funtionality should work",
  "keyword": "Then "
});
formatter.match({
  "location": "Profile_page_step_def.verify_funtionality_should_work(String)"
});
formatter.result({
  "status": "passed"
});
});