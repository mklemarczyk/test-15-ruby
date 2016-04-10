Scenario: Test delete leaf
When add a number 0
And add a number 10
And delete a number 10
Then root should be equal to 0
And left child should be empty
And right child should be empty

Scenario: Test delete inner node
When add a number 0
And add a number 10
And add a number -10
And add a number -15
And add a number -5
And add a number 15
And add a number 5
And delete a number 10
And navigate to right child
Then root should be equal to 0
And left child should be empty
And right child should be empty


Scenario: Test delete root
When add a number 0
And add a number 10
And add a number -10
And add a number -15
And add a number -5
And add a number 15
And add a number 5
And delete a number 0
And navigate to right child
Then root should be equal to 0
And left child should be empty
And right child should be empty
