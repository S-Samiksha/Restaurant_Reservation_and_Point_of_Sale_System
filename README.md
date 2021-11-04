# Restaurant_Reservation_and_Point_of_Sale_System
CZ2002 Group Project Lab SS3

### Delegations 
> Menuitems + Set package : Shreya

> Staff +  price : Samiksha 

> Table + reservation: XK

> Order: Melise and Arushi


### Stuff to discuss if we got errors while coding / issues while coding 

1. staff contact number changed to int. int is 4 bytes, 32 bits long. +- 2^32/2 ish long. Additionally contact number has to be positive. However, since java only allows signed data types, the closest is int. If we are going to this detail, should we standardize everything?

2. All the class parameters are flipped??? like when you declare the class the parameters instead of string name its name string. The class diagram does not match? So which is correct?

3. public float calculatePrice(Order OrderedFood[]) so is order for one table or multiple tables?

4. in the order class whats the difference between menuitems and alacarte? 


6. What about page 1 point 4.l `Sale  revenue  report  will  detail  the  period,  individual  sale  items  (either  ala  carte  or  promotional items) and total revenue.` so what do we do about this? editted in fixed version 

7. `A write-up on your design considerations and use of OO concepts.` 
         then what happens if the staff name is the same what if i have two Toms or two Marys account this in the code. 


8. `A detailed UML  Sequence  Diagram  showing  the  flow  of  the “Check/Remove reservation booking” function.`  who do this?

9. `Screen  captures  of  the  testings  done  (those  essential  test  cases  not  covered  in  your  demo).` How to do this? Is it Exception handling? Do we use some software? 

10. `Your  group  is  to  produce  a  video  and audio  recording  to  demonstrate  the  working  of  the  application – presenting ALL the required functionalities of the application and the test cases. It  is  advised  that  you  planned  your  demonstration  in  a  story-boarding  flow  to  facilitate  understanding  of  your  application. Include  a  group  photo  of  your  group  members  and  introduce your members and group number at the start of video.` How to do this? When to do this?


11. `All implementation codes and java documentation (javadoc).` what is a javadoc? how to make one?

