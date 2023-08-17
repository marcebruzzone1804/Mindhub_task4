package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;
    private Double max_amount;
    @ElementCollection
    private List<Integer> payments = List.of(6,12, 18, 24, 36, 48, 60);

    // aprtir de aca agrego la relacion con clientloans uno a muchos
    @OneToMany(mappedBy = "loan", fetch = FetchType.EAGER)
    private Set<ClientLoan> clients = new HashSet<>();

    public Loan(){}

    public Loan(String name, Double max_amount, List<Integer> payments) {
        this.name = name;
        this.max_amount = max_amount;
        this.payments = payments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMax_amount() {
        return max_amount;
    }

    public void setMax_amount(Double max_amount) {
        this.max_amount = max_amount;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }

    public void setClients(Set<ClientLoan> clients) {
        this.clients = clients;
    }

    public void addClient(ClientLoan clientLoan) {
        clientLoan.setLoan(this);
        clients.add(clientLoan);
    }
    public List<Client> getClients() {
        return clients.stream().map(ClientLoan::getClient).collect(Collectors.toList());
    }
}
