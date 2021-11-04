### Problems and Fixes (I came up with this version due to the kazillion errors that poped up)

**This is important so please take note**

1. Why is a get function a void function....? A lot of this!! I got like 10 errors just from void our class diagram will confirm be wrong

2. Int vs int --> class diagram 

3. removal of price class, needing for system data time --> all for the total sales revenue. Total Sales revenue must be filtered based on date and time and total price needs to be available in attachment with the order. Basically i should be able to print by date, by order, by food items etc. 


**How to discuss**
1. go through the main class and check one by one 

## Delegations(5 pointers, split according to similarity)

We go by switch cases, and you go into the class stated in the mainapp and edit there. 

1. Order creating (functionality 3) --> order class, the constructor, Check table availability, Allocating Table, Allocating the staff, Date and Time to be stored (functionality 8 is included in here) 

2. View Order(Functionality 4), print order invoice (functionality 9) gst is meant to be done outside the order class, service tax, membership etc. i mean we can have it inside no probs its just design anyway but gst, service member calculate at the end. also view order is not invoice although functionality wise its very similar

3. MenuItems: create the flat file, parse it, create the constructor and switch case 2 (Functionality 5) and SetPackage: Similar to 2 (Functionality 5)


4. Create Reservation (Functionality 6 and 7), allocate staff, allocate table, allocate date and time (functionality 8 is included in here), once they check in then it is added to orders etc. 

5. Functionality 1, 2, and 10 all are within manager access only --> this one technically dont need login and logout so not doing it but as design I really feel these things should be accessible to all.... 


**Documentation + testing**
person 2: Class diagram go fix it write up on design consideration and use of OO concepts --> take class diagram and write one page MAX (best just 3/4 page)
person 1 and 4: UML sequence diagram for reservation too 
person 3 and 5: testing using Junit (please help these people and finish coding early, testing takes time dont give them one day to do)


**Video and Demonstration(one person 3min MAX)**
person 1: Introduction, Design, OO concepts
person 2: Class Diagram  + sequence diagram
person 3: Live Demo part 1 (switch cases 1 to 4)
person 4: Live Demo part 2 (switch cases 5 to 7)
person 5: Testing using Junit 


