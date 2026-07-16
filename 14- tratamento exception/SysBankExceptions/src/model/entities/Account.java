package model.entities;

import model.DomainExceptions.DomainExceptions;

public class Account {
private int number;
private String holder;
private Double balance;
private Double withdrawLimit;
public Account(int number, String holder, Double balance, Double withdrawLimit) {
    this.number = number;
    this.holder = holder;
    this.balance = balance;
    this.withdrawLimit = withdrawLimit;
}
public Integer getNumber() {
    return number;
}
public void setNumber(Integer number) {
    this.number = number;
}
public String getHolder() {
    return holder;
}
public void setHolder(String holder) {
    this.holder = holder;
}
public Double getBalance() {
    return balance;
}
public Double getWithdrawLimit() {
    return withdrawLimit;
}
public void deposit(double amount){
    balance += amount;
}
public void withdraw(double amount) throws DomainExceptions{
    if (balance < amount) {
        throw new DomainExceptions("Insufficient funds");
    }
    if (amount > withdrawLimit) {
        throw new DomainExceptions("Error in withdraw: amount exceeds withdraw limit");
    }
    balance -= amount;
}
@Override
public String toString() {
    return "Account [getBalance()=" + getBalance() + "]";
}
}

