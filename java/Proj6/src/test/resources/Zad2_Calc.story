Scenario: Divide int
When open calc page
Given numbers <x> to divide
Then result is <data>

Examples:
|x|data|
|4|4e0|
|7;1|7|
|8;2|4|

Scenario: Divide float
When open calc page
Given numbers <x> to divide
Then result is <data>

Examples:
|x|data|
|7;0.5|14|
|9;2|4.5|
|8;3|2.6666666666666667|
|9,8;2|4.9|
|8;3|2.6666666666666667|

Scenario: Divide error
When open calc page
Given numbers <x> to divide
Then result is <data>

Examples:
|x|data|
|7;0|Error: DivByZero|
