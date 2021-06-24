### Kazdy user ma jeden koszyk
User 1:1 Cart
### User ma wiele historycznych orderow
User 1:m Order
### Z jednego koszyka zostanie stworzony jeden order (np. jak klient kliknie 'Zrealizuj zamowienie')
Cart 1:1 Order
### W koszyku jest wiele produktow
Cart 1:m Product
### W orderze jest wiele produktow
Order 1:m Product
### Do grupy nalezy wiele produktow
Group 1:m Product