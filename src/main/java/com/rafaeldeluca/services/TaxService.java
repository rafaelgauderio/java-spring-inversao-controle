package com.rafaeldeluca.services;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

    public double tax(double amount) {
        return 0.15 * amount;
    }
}
