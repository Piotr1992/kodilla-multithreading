package com.kodilla.terminal.connectanswers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompanyProvider {

    public CompletableFuture<List<String>> provideCompany() {
        System.out.println("Providing company");
        return CompletableFuture.supplyAsync(() -> List.of(
                "Jan m",
                "Ala m"
        ));
    }

}