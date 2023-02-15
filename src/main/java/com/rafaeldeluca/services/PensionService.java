package com.rafaeldeluca.services;

import org.springframework.stereotype.Service;

@Service
public class PensionService {

    public double pensionDiscount (double amount) {
        return 0.08 * amount;
    }
}
