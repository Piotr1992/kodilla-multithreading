package com.multi.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CountryProcessTask extends RecursiveTask<Long> {

    private List<Country> countries = new ArrayList<Country>();

    CountryProcessTask(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    protected Long compute() {
        if (countries.size() <= 10) {
            return countries
                    .stream()
                    .mapToLong(CountryProcessTask::processCountry)
                    .sum();
        } else {
            int middle = countries.size() / 2;
            CountryProcessTask left = new CountryProcessTask(countries.subList(0, middle));
            CountryProcessTask right = new CountryProcessTask(countries.subList(middle, countries.size()));

            left.fork();

            long rightResult = right.compute();
            long leftResult = left.join();


            return leftResult + rightResult;
        }
    }

    private static long processCountry(Country b) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (long) (b.getPeopleQuantity() * 2 + b.getPeopleQuantity() / 2 + Math.floor(
                Math.sqrt(b.getPeopleQuantity())));
    }
}