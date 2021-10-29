# AccountTransfer

Java Case Study
Design and implement a RESTful API for doing transfers between accounts. That should include data
models and service implementation.
Minimum model definition
o
o
Account
▪ Account number
▪ Balance
Transaction
▪ Source account number
▪ Destination account number
▪ Amount
Requirements
•
•
•
•
•
•
You are required to provide an implementation of a TransferService API. The service API
should accept as input source account number, destination account number and the
amount. It returns the appropriate response.
Data should run in-memory
You can use any framework you fancy, but please stick to Java8+ as the programming
language
Authentication is not required for this case study
Use tests to prove that the endpoints work as expected
Ensure that code is always failsafe