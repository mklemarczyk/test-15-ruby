Scenario: Test add
When add a number 2
Then root should be equal to 2
And left child should be empty
And right child should be empty

Scenario: Test add equals
When add a number 2
And add a number 2
Then root should be equal to 2
And left child should be equal to 2
And right child should be empty

Scenario: Test add greater
When add a number 2
And add a number 5
Then root should be equal to 2
And left child should be empty
And right child should be equal to 5

Scenario: Test add lower
When add a number 2
And add a number -3
Then root should be equal to 2
And left child should be equal to -3
And right child should be empty

Scenario: Test add lower x2
When add a number 2
And add a number -6
And add a number -12
And navigate to left child
Then root should be equal to -6
And left child should be equal to -12
And right child should be empty

Scenario: Test add lower, greater
When add a number 2
And add a number -30
And add a number -10
And navigate to left child
Then root should be equal to -30
And left child should be empty
And right child should be equal to -10

Scenario: Test add greater, lower
When add a number 2
And add a number 50
And add a number 20
And navigate to right child
Then root should be equal to 50
And left child should be equal to 20
And right child should be empty

Scenario: Test add greater x2
When add a number 2
And add a number 5
And add a number 15
And navigate to right child
Then root should be equal to 5
And left child should be empty
And right child should be equal to 15

