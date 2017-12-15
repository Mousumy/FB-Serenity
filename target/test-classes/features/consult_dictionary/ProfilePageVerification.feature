Feature:	I need to check all Headers
#			After logging in Profile Page 
      
Background: 
	Given User can log in to facebook using userid as "asmenterprise.llc@gmail.com" and password as "ctg310306"
	And User profile has been loaded successfully 

#@regression       
#Scenario: profilepage header verification
#	Then Verify this header "Photos" is present
#
#
@quicktest
Scenario: Timeline functionality verification
	When Navigate to "Timeline"	
	And Verify header "Life Event" is present
	Then Verify "Work & Education" funtionality should work
#	
#@regression
#Scenario: More functionality verification
#	And Navigate to "more"
#	Then verify more functionality is working
#	
#@regression
#Scenario: Friends functionality verification
#	And Navigate to "Friends"
#	And User will search for "Sunil C Patel"
		




