# ATM_API_Java_Code

This code implements the backend operations for ATM service. 
The main file is App.java that needs to be run to start the service.
The call is handled by AtmController.java file
The operations performed are:
1) Check Balance: http://localhost:8080/atm/checkbalance/{accountNumber}
   The user needs to provide the atm number as a url parameter to return the balance of the account.

2) Withdraw Amount:  http://localhost:8080/atm/withdraw/{accountNumber}/{amount}
 This api is used to withdraw the required amount by providing the account number and amount.
 
3) Deposit Amount: https://localhost:8080/atm/deposit/{accountNumber}/{amount}
 This api is used to deposit the required amount by providing the account number and amount.
 
4) Create Account: https://localhost:8080/atm/addaccount
  The request is sent as json to the rest api to insert the new entry. The fields required are account number(Long), Account name(String), Pin(int), Balance(double)
  
Database Details:
1) Database-: MySQL
2) Table name-: AccountInfo(Columns-: Id(AutoIncrement), accountName,accountNum,pin,balance)

