package com.rafaeldeluca.services;

import com.rafaeldeluca.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    private TaxService taxService;
    private PensionService pensionService;

    // inversão de controle e injeção de dependência com um construtor
    public SalaryService(TaxService taxService, PensionService pensionService) {
        this.taxService= taxService;
        this.pensionService = pensionService;
    }

    public double netSalary (Employee employee) {

        // salário líquido = salário líquido - imposto - previdência
        return employee.getGrossSalary()- taxService.tax(employee.getGrossSalary()) - pensionService.pensionDiscount(employee.getGrossSalary());
    }
}
