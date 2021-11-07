### Problems and Fixes (I came up with this version due to the kazillion errors that poped up)
**Updates (7/11/21)**
Caes 1,2,3,5 can work! I haven't really looked at Use Case 6 or 7 but for reservation, I wou;d say one of the key problems is the data and the constructor.
Data: 1|2021-10-17 15:24:00|2|XXXXX|99999999|123456|
Constructor: public Reservation( String staffID, String customerName, Timestamp timestamp , int contactNumber, int numPeople, int table, String reservationID)

I am not sure what each value in the data stands for. We need to standardise this part. Also, let's standardse that all IDs are strings. It's kinda weird that some functions are calling int IDs and some are calling string IDs. I have alr chnaged reservation ID attributes to string. I'll see if I can work on reservation tomorrow!


**This is important so please take note**

1. Why is a get function a void function....? Our class diagram will confirm be wrong

2. Int vs int --> class diagram 

3. removal of price class, needing for system data time --> all for the total sales revenue. Total Sales revenue must be filtered based on date and time and total price needs to be available in attachment with the order. Basically i should be able to print by date, by order, by food items etc. 

4. double to float for price: we dont need 8 bytes

5. table size reduced to short (if i remember correctly)

6. in fact in java byte stores from -128 to 127 table can reduce further because maximum is 10. in fact, variables can be altered to reduce space usage. Like number of people, quantity etc 

7. usage of arraylist --> i think is a super efficient way of reducing for loops and counting frequency or even finding things. 

8. flat file --> use to construct etc. --> need a separate java file --> DataAdapter library I already made partial flat file not a proper one to test how it works, we can have the "split" as in the seperator / deliminator  as | or , or space or tab etc. safe is we use a symbol. 

9. Stereotypes are needed in assignment although I am not sure how to show / add

10. Is set package price +++ menu items or like a lower value that we set in flat file? if promo then must additionally reduce price...? 

11. Exception handling 

12. Lunch dinner, drinks split (remember manual says main course, drinks, and desert is a must) --> it is add another variable or just change the itemID, cuz when we display menu must account for the time (KIV)


**How to discuss**
1. go through the main class and check one by one (functionality, if there are any mistakes, class diagram issues bound to have) + check against manual 
2. make flat file tgt would be faster (we need staff, table, menu, set package, reservation also exactly 5 do tgt can finish very fast, order is during run time) + the coding in JAVA --> this is quite new so maybe we can do tgt? 
3. decide a date to finish the coding by OR everyday from 4 pm to 7pm we do coding tgt on discord/zoom


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

Javadoc is missing 

**NEW DELEGATIONS**
Person 1 and 2: debugging --> need to get the code up and working! (within these few days) + live demo
Person 3,4,5: DO the rest--> javadoc, Diagrams(class diagram, sequence diagram etc) and prepare for video

**Video and Demonstration(one person 3min MAX)**

person 1: Introduction, Design, OO concepts
person 2: Class Diagram  + sequence diagram
person 3: Live Demo part 1 (switch cases 1 to 4)
person 4: Live Demo part 2 (switch cases 5 to 7)
person 5: Testing but need to show lah screenshot see manual


**Things to note**

1. boundary: Restuarant App(MainApp Class)  --> NOT IN CLASS DIAGRAM --> email 
2. Entity: Class of objects + getter setter (eg. getTableCapacity())
3. Control: using the getter + setter for functions (eg. reservetable())


**To email**
Is it boundary cannot be in class diagram?
