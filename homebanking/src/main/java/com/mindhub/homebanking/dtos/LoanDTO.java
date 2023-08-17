package com.mindhub.homebanking.dtos;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.ClientLoan;
import com.mindhub.homebanking.models.Loan;

import java.util.List;

public class LoanDTO {

    public Long id;
    public String name;
    public List<Integer> payments;
    public double max_amount;

    public Client client;

    public LoanDTO(Loan loan){
        this.id = loan.getId();
        this.name = loan.getName();
        this.payments = loan.getPayments();
        this.max_amount = loan.getMax_amount();

    }
}
