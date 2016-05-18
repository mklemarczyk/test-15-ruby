Scenario: Open home page
When open home page
Then home page is shown

Scenario: Login with empty
When open login page
And username is empty
And password is empty
And login button pressed
Then blank username error shown
And blank password error shown

Scenario: Login with wrong credentials
When open login page
And username is given test1
And password is given test1
And login button pressed
Then invalid username or password error shown

Scenario: Login with valid credentials
When open login page
And username is given admin
And password is given admin
And login button pressed
Then user is logged

Scenario: Empty index page
When open login page
And username is given admin
And password is given admin
And login button pressed
And open info types page
Then no results found on index page

Scenario: Add empty item
When open login page
And username is given admin
And password is given admin
And login button pressed
And open info types page
And create info type button pressed
And create button pressed
Then blank name error shown

Scenario: Add valid item
When open login page
And username is given admin
And password is given admin
And login button pressed
And open info types page
And create info type button pressed
And name is given Procesor speed
And create button pressed
Then info type was created
