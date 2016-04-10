Scenario: Test empty tree
When getting number
Then operation should throw an exception

Scenario: Test empty tree
When navigate to left child
Then operation should return false

Scenario: Test empty tree
When navigate to right child
Then operation should return false

Scenario: Test empty tree
When navigate to parent
Then operation should return false

Scenario: Test single node tree
When add a number -20
And getting number
Then operation should not throw an exception

Scenario: Test single node tree
When add a number -20
And navigate to left child
Then operation should return false

Scenario: Test single node tree
When add a number -20
And navigate to right child
Then operation should return false

Scenario: Test single node tree
When add a number -20
And navigate to parent
Then operation should return false
