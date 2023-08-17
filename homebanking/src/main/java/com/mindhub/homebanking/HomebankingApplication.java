package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanrepository, ClientLoanRepository clientLoanRepository){
		return args -> {
			Client cliente1 = new Client("Melba", "Morel", "melba@mindhub.com");
			Client cliente2 = new Client("Marcelo", "Bruzzone", "bruzzone1804@gmail.com");
			clientRepository.save(cliente1);
			clientRepository.save(cliente2);

			Account cuenta1 = new Account("VIN001", LocalDate.now(), 5000.0);
			Account cuenta2 = new Account("VIN002", LocalDate.now().plusDays(1), 7500.0);

			cliente1.addAccount(cuenta1);
			cliente2.addAccount(cuenta2);

			accountRepository.save(cuenta1);
			accountRepository.save(cuenta2);

			Transaction transaction1 = new Transaction(TransactionType.CREDITO, 5000.00, "Transaccion 1", LocalDate.now());
			Transaction transaction2 = new Transaction(TransactionType.DEBITO, -10000.00, "Transaccion 2", LocalDate.now());

			cuenta1.addTransaction(transaction1);
			cuenta1.addTransaction(transaction2);

			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);

			List<Integer> payments1 = new ArrayList<>();
			payments1.add(12);
			payments1.add(24);
			payments1.add(36);
			payments1.add(48);
			payments1.add(60);

			List<Integer> payments2 = new ArrayList<>();
			payments2.add(6);
			payments2.add(12);
			payments2.add(24);

			List<Integer> payments3 = new ArrayList<>();
			payments3.add(6);
			payments3.add(12);
			payments3.add(24);
			payments3.add(36);



			Loan prestamo1 = new Loan("Hipotecario", 500000.00,payments1);
			Loan prestamo2 = new Loan("Personal", 100000.00,payments2);
			Loan prestamo3 = new Loan("Automotriz", 300000.00,payments3);


			loanrepository.save(prestamo1);
			loanrepository.save(prestamo2);
			loanrepository.save(prestamo3);


			ClientLoan clientloan1 = new ClientLoan(400000.00, 60, cliente1, prestamo1);
			ClientLoan clientloan2 = new ClientLoan(50000.00, 12, cliente1, prestamo2);
			ClientLoan clientloan3 = new ClientLoan(100000.00, 24, cliente2, prestamo3);
			ClientLoan clientloan4 = new ClientLoan(200000.00, 36, cliente2, prestamo3);

			clientLoanRepository.save(clientloan1);
			clientLoanRepository.save(clientloan2);
			clientLoanRepository.save(clientloan3);
			clientLoanRepository.save(clientloan4);


		};
	}

}
