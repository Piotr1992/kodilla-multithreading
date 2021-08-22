package com.kodilla.multi.parallel;

import java.util.ArrayList;
import java.util.List;

public class Countries {
    private Countries() {
    }

    public static List<Country> randomCountries(int number) {
        List<Country> countries = new ArrayList<>();
        int peopleQuantity = 1000000;
        for (int n = 0; n < number; n++) {
            if(n > 0) peopleQuantity = peopleQuantity * n;
            countries.add(new Country("Country number " + n, peopleQuantity));
        }
        return countries;
    }
}
