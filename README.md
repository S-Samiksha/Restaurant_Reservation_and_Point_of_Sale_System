### Problems and Fixes (I came up with this version due to the kazillion errors that poped up)

**This is important so please take note**

https://www.w3schools.com/java/java_date.asp 

https://discord.gg/CUcEMQc4 

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


## Delegations(5 pointers, split according to similarity)--> 7 NOV SUNDAY 2359

We go by switch cases, and you go into the class stated in the mainapp and edit there. 

**Flat file parsing:**
Staff: Samiksha
order: Shreya
MenuItems: Arushi
SetPackage: Melise 
Reservation: XK


1. Order creating (functionality 3) --> order class, the constructor, Check table availability, Allocating Table, Allocating the staff, Date and Time to be stored (functionality 8 is included in here) **(SHREYA)**

2. View Order(Functionality 4), print order invoice (functionality 9) gst is meant to be done outside the order class, service tax, membership etc. i mean we can have it inside no probs its just design anyway but gst, service member calculate at the end. also view order is not invoice although functionality wise its very similar **(MELISE)**

3. MenuItems: create the flat file, parse it, create the constructor and switch case 2 (Functionality 5) and SetPackage: Similar to 2 (Functionality 5) **(ARUSHI)**

4. Create Reservation (Functionality 6 and 7), allocate staff, allocate table, allocate date and time (functionality 8 is included in here), once they check in then it is added to orders etc. --> including parsing file **(XK)**

5. Functionality 1, 2, and 10 all are within manager access only --> this one technically dont need login and logout so not doing it but as design I really feel these things should be accessible to all.... **(SAMIKSHA)**

6. Close Shop, add orders into text file --> can one non testing person do?

**Documentation + testing** --> 9 NOV Tuesday 2359
person 2: Class diagram go fix it write up on design consideration and use of OO concepts --> take class diagram and write one page MAX (best just 3/4 page)**(ARUSHI)**
person 1 and 4: UML sequence diagram for reservation too **(MELISE)&(SHREYA)**
person 3 and 5: testing using Junit (please help these people and finish coding early, testing takes time dont give them one day to do) 
**(SAMIKSHA) (XING KUN)**


**Video and Demonstration(one person 3min MAX)** --> 13 SATURDAY 2PM (ZOOM to record)
person 1: Introduction, Design, OO concepts  **(ARUSHI)**
person 2: Class Diagram  + sequence diagram  **(MELISE)**
person 3: Live Demo part 1 (switch cases 1 to 4) **(SHREYA)**
person 4: Live Demo part 2 (switch cases 5 to 7) **(XINGKUN)**
person 5: Testing using Junit **(SAMIKSHA)** 


**Things to note**

1. boundary: Restuarant App(MainApp Class)  --> NOT IN CLASS DIAGRAM --> email 
2. Entity: Class of objects + getter setter (eg. getTableCapacity())
3. Control: using the getter + setter for functions (eg. reservetable())


**To email**
Is it boundary cannot be in class diagram?
Are there any test cases given?
