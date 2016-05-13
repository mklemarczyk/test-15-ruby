Scenario: Open login page
When open login page
Then login page is shown

Scenario: Open reciver page
When open temp mail page
Then 0 messages are present

Scenario: Login with valid credentials
When open login page
And username is given mklemarczyk
And password is given <password>
And login button pressed
Then user is logged

Scenario: Send email
When open new mail page
And subject is given My simple test email
And body is given Hello my buddy
And send button pressed
Then email is send

Scenario: Check email
When open temp mail page
Then 1 message is present
And email subject is My simple test email
And email body contains Hello my buddy
