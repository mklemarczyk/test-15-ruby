Scenario: Tree parametrized
Given numbers <x> to insert
Then tree should <data>

Examples:
|x|data|
|2,3,4,-1|[2, -1, 3, null, null, null, 4]|
|3|[3]|
|4|[4]|
