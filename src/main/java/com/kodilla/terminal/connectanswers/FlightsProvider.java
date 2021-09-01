package com.kodilla.terminal.connectanswers;

import com.kodilla.terminal.Flight;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FlightsProvider {

    public CompletableFuture<List<String>> provideFlights() {
        System.out.println("Providing flights");
        return CompletableFuture.supplyAsync(() -> List.of(
                "a psa",
                "a kota"
        ));
    }

}