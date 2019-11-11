## Illumio Coding Challenge:
This is the source code for Illimio Coding Challenge authored by Wei-Ting Chen. I completed this solution in 75 minutes.

## How I tested my solution
The main function under Firewall class contains several test cases that test my solution due to time constraints. 
Ideally, I should have utilized JUnit, the unit testing framework for Java, for more edge test cases. Although
the coding challenge page says the input is always valid, in real scenario, invalid inputs are always given. Therefore,
I should still handle these situations and write test cases for them.

## How I structured my code
In general, the main Firewall class keeps a set of rules that are retrieved from the CSV file during initialization. 
Each individual rule is initialized as a "Rule" object, which is one of my classes. Each Rule object contains a string 
of the protocol, a string of the direction, a Port object and a InternetProtocol Object. The equals method is overridden in
the Rule class for comparison. The Port and InternetProtocol class are very similar. Each of the instance of Port and InternetProtocol
either represents a single value or a range. A match method (return boolean) is defined to check a given port or IP is allowed by 
this Port or  InternetProtocol. Therefore, the overridden "equals" method is Rule Class just checks if the match methods in Port and
InternetProtocal return true and the direction / protocol are the same.

In the actual "accept_packet" method in Firewall Class, the method first creates a new rule from the paramters and loops through
the set and check if any rule "equals" to the new rule. If there is, return true.

Initially, when I created the "equals" method in Rule Class, I thought when calling "set.contains" (which is an O(1) operation), the method
will internally do comparisons based on the overridden "equals" method in Rule Class. However, it turned out it did not work and I went
online and looked for explanations. The answer I got was that I might need to implement the HashCode method in addition to the "equals"
method. But due to the time constraints, I decided to use a relatively simple method to check.

## To Improve If More Time Allowed
As I mentioned in the previous section, one thing to improve is to figure out "set.contains" method using the "equals" method I defined and 
this would reduce time complexity from O(n) to O(1).

In addition, I may also implement a B+ tree to store my Rules taken from my database class. This can reduce the time of adding rules and 
verifying incoming rule in comparison to my current method as well.

Furthermore, in terms of storage, it is always not a good idea to store these rules in the memory. Ideally, I might have to think of a way to store
rules in the disk and retrieve them when we need to verify. This is because we might have so many rules that can't fit in the memory. However,
this leads to a new problem that retrieving from disks is a very slow process. So ideally, we might need to store common rules that have been used in
a cache and if we can't find the rule in the cache, we then choose to look up in the disk. To store in the disk, one way is to use serialization and
deserialization. 

In terms of design pattern, my code creates only two classes for the subrule (InternetProtocol and Port). To make code clean, I should also implement a 
subRule abstract class and implemented all four sub rules using this abstract class. So in our actual rule classes, we only need to define a list of subRules.
One advantage is that if we want to add more subrules in a rule, this can be achieved easily.

## Team of Interest
I am very interested in joining Platform Team as an intern in 2020 Summer. However, if you find myself a good fit for Data team or Policy team, please don't
hesitate to contact me.



