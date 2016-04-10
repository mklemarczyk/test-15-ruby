Scenario: Test delete from empty tree
When delete a number 0
Then operation should return a boolean false

Scenario: Test delete root (leaf)
When add a number 0
And delete a number 0
And getting number
Then operation should throw an exception

Scenario: Test delete lower (leaf)
When add a number 0
And add a number -10
And delete a number -10
Then root should be equal to 0
And left child should be empty
And right child should be empty

Scenario: Test delete greather (leaf)
When add a number 0
And add a number 10
And delete a number 10
Then root should be equal to 0
And left child should be empty
And right child should be empty

Scenario: Test delete lower (leaf, not exists)
When add a number 0
And add a number -10
And delete a number -11
Then operation should return a boolean false

Scenario: Test delete greather (leaf, not exists)
When add a number 0
And add a number 10
And delete a number 11
Then operation should return a boolean $value

Scenario: Test delete root without left child
When add a number 0
And add a number 10
And add a number 5
And add a number 15
And delete a number 0
Then root should be equal to 10
And left child should be equal to 5
And right child should be equal to 15

Scenario: Test delete lower inner node without left child
When add a number 0
And add a number 10
And add a number -10
And add a number -5
And add a number 5
And add a number 15
And delete a number -10
And navigate to left child
Then root should be equal to -5
And left child should be empty
And right child should be empty

Scenario: Test delete greather inner node without left child
When add a number 0
And add a number 10
And add a number -10
And add a number -15
And add a number -5
And add a number 15
And delete a number 10
And navigate to right child
Then root should be equal to 15
And left child should be empty
And right child should be empty
