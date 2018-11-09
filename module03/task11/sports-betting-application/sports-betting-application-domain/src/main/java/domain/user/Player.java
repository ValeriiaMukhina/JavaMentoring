package domain.user;

import domain.betting.Currency;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author  Valeriia Biruk
 * @version 1.0
 */
public class Player extends User{
    private String name;
    private String accountNumber;
    private double balance;
    private Currency currency;
    private LocalDate dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Double.compare(player.balance, balance) == 0 &&
                Objects.equals(name, player.name) &&
                Objects.equals(accountNumber, player.accountNumber) &&
                currency == player.currency &&
                Objects.equals(dateOfBirth, player.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accountNumber, balance, currency, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                ", dateOfBirth=" + dateOfBirth +
                "} " + super.toString();
    }
}
