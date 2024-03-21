Online Pharmacy
1.1. CRUD for medication: id, name, manufacturer, price, requires prescription. The price must be strictly positive.
1.2. CRUD for customer card: id, name, surname, CNP (Personal Numeric Code), date of birth (dd.mm.yyyy), registration date (dd.mm.yyyy). The CNP must be unique.
1.3. CRUD for transaction: id, medication_id, customer_card_id (can be null), number of pieces, date and time (dd.mm.yyyy HH:mm). If a customer card exists, then apply a discount of 10% if the medication does not require a prescription and 15% if it does. Print the paid price and the discounts granted.
1.4. Search for medications and customers. Full-text search.
1.5. Displaying all transactions within a given day range.
1.6. Displaying medications in descending order by sales number.
1.7. Displaying customer cards in descending order by the value of discounts obtained.
1.8. Deleting all transactions within a specific day range.
1.9. Increasing the price by a given percentage for all medications priced below a given value.
