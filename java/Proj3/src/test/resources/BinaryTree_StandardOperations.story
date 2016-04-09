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
