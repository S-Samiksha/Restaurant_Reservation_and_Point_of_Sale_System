# Restaurant_Reservation_and_Point_of_Sale_System
CZ2002 Group Project Lab SS3

### Delegations 
> Menuitems + Set package : Shreya

> Staff +  price : Samiksha 

> Table + reservation: XK

> Order: Melise and Arushi


### Stuff to discuss if we got errors while coding / issues while coding 
1. staff contact number changed to int. int is 4 bytes, 32 bits long. +- 2^32/2 ish long. Additionally contact number has to be positive. However, since java only allows signed data types, the closest is int. 
2. All the class parameters are flipped so is the class diagram correct 
3. public float calculatePrice(Order OrderedFood[]) changed to public float calculatePrice(Order OrderedFood) because orderedFood is one order. if you have an array of ordered food. i have an array of orders for the whole restaurant with an array of menuitem and an array of setpackage. 
4. in order class whats the difference between menuitems and alacarte?
