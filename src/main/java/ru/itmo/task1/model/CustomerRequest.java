package ru.itmo.task1.model;

import java.time.LocalDate;

public final class CustomerRequest {

    private final long id;
    private final LocalDate birthDate;
    private final Purchase[] purchases;
    private Integer points = 0;

    public CustomerRequest(long id, String birthDate, Purchase[] purchases) {
        this.id = id;
        this.birthDate = LocalDate.parse(birthDate);
        this.purchases = purchases;
    }

    public long getId() {
        return id;
    }

    public Purchase[] getPurchases() {
        return purchases;
    }

    public boolean isBirthdayToday() {
        LocalDate today = LocalDate.now();
        if ((today.getMonthValue() == this.birthDate.getMonthValue())&(today.getDayOfMonth() == this.birthDate.getDayOfMonth())) {
            return true;
        }
        return false;
    }

    public Double getPurchasesAmount() {
        Double amount = 0d;
        for (Purchase purchase: purchases) {
            amount += purchase.price;
        }
        return amount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points += points;
    }
}
