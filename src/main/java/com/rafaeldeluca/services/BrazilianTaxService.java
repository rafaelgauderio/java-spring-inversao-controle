package com.rafaeldeluca.services;

import org.springframework.stereotype.Service;

@Service
public class BrazilianTaxService  extends  TaxService {

    @Override
    public double tax(double amount) {
        return amount * 0.20;
    }
}
