Scenario: Sum
When open calc page
Given numbers 2 to insert
Then result is 1

Scenario: Sum
When open calc page
Given numbers <x> to insert
Then result is <data>

Examples:
|x|data|
|2,3,4,-1|2|
|3|2|
|4|2|
