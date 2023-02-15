package com.rafaeldeluca.application;

import com.rafaeldeluca.entities.Employee;
import com.rafaeldeluca.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.rafaeldeluca"})
public class SalarioApplication implements CommandLineRunner {

	// declarando dependência do salary Service
	@Autowired
	private SalaryService salaryService;

	/*
	public SalarioApplication(SalaryService salaryService) {
		this.salaryService = salaryService;
	}
	*/

	public static void main(String[] args) {

		SpringApplication.run(SalarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\nNecessário 2 passos para trabalhar com injeção de dependência em frameworks\n" +
				"\t1.Registrar os componentes\n" +
				"\t2.Indicar quais componetes dependem de quais componentes\n" +
				"Annotations fazem um pré processamento da Classe quando a aplicação for executada.\n");

		Employee employee01 = new Employee("Rafael de Luca", 15000.00);
		double salarioLiquido = salaryService.netSalary(employee01);
		System.out.println("Salário Líquido: " + salarioLiquido);
	}
}
