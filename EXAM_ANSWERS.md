# LICEO RIDE - Semi-Final Laboratory Exam Answers

Name: Gail Isabelle A. Abas
Section: BSIT 2-1

## Question 1

Why is the list in RideManager typed ArrayList<Ride> and not ArrayList<Jeepney>?

Your answer:
`ArrayList<Ride>` can store different types of rides, such as Jeepney, Tricycle, and Taxi, because they all inherit from Ride. This allows RideManager to handle all ride types using polymorphism without needing a separate list for each vehicle.

## Question 2

In showStudentDiscounts(), why must you check instanceof before the cast?

Your answer:
We must check `instanceof` before casting because not every Ride implements `StudentDiscount`. A Taxi, for example, does not provide a student discount, so casting it to `StudentDiscount` without checking would cause a `ClassCastException`.
