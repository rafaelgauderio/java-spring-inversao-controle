package com.rafaeldeluca.services;

import com.rafaeldeluca.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private TaxService taxService;
    @Autowired
    private PensionService pensionService;

    public SalaryService(BrazilianTaxService brazilianTaxService, PensionService pensionService) {
        this.pensionService = pensionService;
        this.taxService = brazilianTaxService;
    }

    // inversão de controle e injeção de dependência com um construtor
    /*
    public SalaryService(TaxService taxService, PensionService pensionService) {
        this.taxService= taxService;
        this.pensionService = pensionService;
    }
    */

    public double netSalary (Employee employee) {

        // salário líquido = salário líquido - imposto - previdência
        return employee.getGrossSalary()- taxService.tax(employee.getGrossSalary()) - pensionService.pensionDiscount(employee.getGrossSalary());
    }
}
