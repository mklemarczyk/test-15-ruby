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
