package sports.domain.user;

import sports.domain.betting.Currency;

import java.time.LocalDate;

public class Player extends User{
    private String name;
    private String accountNumber;
    private double balance;
    private Currency currency;
    private LocalDate DateOfBirth;
}
