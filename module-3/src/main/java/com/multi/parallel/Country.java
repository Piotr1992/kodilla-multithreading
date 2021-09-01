package com.multi.parallel;

public class Country {
    private final String name;
    private final int peopleQuantity;

    Country(String name, int peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    String getName() {
        return name;
    }

    int getPeopleQuantity() {
        return peopleQuantity;
    }
}
