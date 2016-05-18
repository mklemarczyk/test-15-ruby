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
