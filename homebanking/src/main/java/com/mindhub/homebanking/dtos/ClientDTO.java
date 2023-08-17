package com.mindhub.homebanking.dtos;
import com.mindhub.homebanking.models.Client;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    private Set<AccountDTO> cuentas;
    private List<LoanDTO> prestamos;

    public ClientDTO(Client client){
        this.id = client.getId();
        this.firstName= client.getFirstName();
        this.lastName = client.getLastName();
        this.email=client.getEmail();
        this.cuentas = client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());
        this.prestamos = client.getLoans().stream().map(LoanDTO::new).collect(Collectors.toList());
    }
}