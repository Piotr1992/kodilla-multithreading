package com.kodilla.terminal.connectanswers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Terminal {

    private static final FlightsProvider flightsProvider = new FlightsProvider();
    private static final CompanyProvider companyProvider = new CompanyProvider();

    public static void main(String[] args) {
        companyProvider.provideCompany().thenCompose(companies -> {
            final List<CompletableFuture<String>> updatedFlights = updateFlights(companies);
            return collectAllFlightsFutures(updatedFlights);
        }).join();
        flightsProvider.provideFlights().thenCompose(flights -> {
            final List<CompletableFuture<String>> updatedFlights = updateFlights(flights);
            return collectAllFlightsFutures(updatedFlights);
        }).thenAccept(Terminal::printResult).join();
    }

/*
* *
        flightsProvider.provideFlights().thenCompose(flights -> {
            final List<CompletableFuture<Flight>> updatedFlights = updateFlights(flights);
            return collectAllFlightsFutures(updatedFlights);
        }).thenAccept(Terminal::printResult).join();
*
* */

    private static List<CompletableFuture<String>> updateFlights(List<String> flights) {
/*          return flights.stream()
                .map(flight -> companyProvider.provideName(flight.getCompanyId())
                        .thenApply(companyName -> {
                            flight.setCompanyName(companyName);
                            return flight;
                        })).collect(Collectors.toList());           */
        return flights.stream()
                .map(flight -> companyProvider.provideCompany()
                    .thenApply(companyProvider -> {
                        return flight;
                    }))
                .collect(Collectors.toList());
    }

    private static CompletableFuture<List<String>> collectAllFlightsFutures(List<CompletableFuture<String>> updatedFlights) {
/*        return CompletableFuture.allOf(updatedFlights.toArray(new CompletableFuture[0]))
                .thenApply(v -> updatedFlights.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));             */
//        return CompletableFuture.supplyAsync(() -> List.of("aaa"));
        return CompletableFuture.allOf(updatedFlights.toArray(new CompletableFuture[0]))
                .thenApply(v -> updatedFlights.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

    private static void printResult(List<String> updatedFlights) {
        System.out.println("");
        System.out.println("----TERMINAL KODILLA----");
        System.out.println(updatedFlights);
    }

}