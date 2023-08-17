package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.*;

import java.time.LocalDate;

public class ClientLoanDTO {
    private Long id;
    private Loan loan;
    private String name;
    public double amount;
    private Integer payments;


    public ClientLoanDTO(ClientLoan clientLoan){
        this.id = clientLoan.getId();
        this.loan = clientLoan.getLoan();
        this.name = clientLoan.getName();
        this.amount = clientLoan.getAmount();
        this.payments = clientLoan.getPayments();
    }
}