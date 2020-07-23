package com.wipro.ccbill.entity;
import java.util.Date;

import com.wipro.ccbill.exception.InputValidationException;

public class CreditCardBill {
private String creditCardNo;
private String customerId;
private Date billDate;
private Transaction monthTransactions[];

public CreditCardBill () {
}
public CreditCardBill (String creditCardNo, String customerId, Date BillDate, Transaction monthTransactions[]) {
this.creditCardNo=creditCardNo;
this.customerId=customerId;
this.billDate=BillDate;
this.monthTransactions=monthTransactions;
}
double a=0.0;
public double getTotalAmount(String transactionType) {
if(!(transactionType.equals("CR") && transactionType.equals("DB"))) {
a=0.0;
}
for(int i=0;i<monthTransactions.length;i++) {
if(monthTransactions[i].getTransactionType().equals(transactionType)) {
a+=monthTransactions[i].getTransactionAmount();
}
}
return a;
}
public double validateData() throws InputValidationException{
try {
if(creditCardNo==null) {
throw new InputValidationException("Incorrect Card Number");
}
if(creditCardNo.length()!=16) {
throw new InputValidationException("Incorrect Card Number");
}
if(customerId==null) {
throw new InputValidationException("Incorrect Customer ID");
}
if(customerId.length()>6) {
throw new InputValidationException("Id must contain minimum of 6");
}
double valid = 0;
return valid;
}
catch(InputValidationException i) {
double Invalid = 0;
return Invalid;
}
}
public double calculateBillAmount() throws InputValidationException {
double validateFlag=validateData();
double x=getTotalAmount("DB");
double y=getTotalAmount("CR");
double z=Math.abs(y-x);
double ic=(z*(19.9/100))/12;
double p=ic+z;
return p;
}
}