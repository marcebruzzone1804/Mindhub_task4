package com.mindhub.homebanking.controllers;
import com.mindhub.homebanking.dtos.ClientLoanDTO;
import com.mindhub.homebanking.repositories.ClientLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientLoanController {
    @Autowired
    ClientLoanRepository clientLoanRepository;

    @RequestMapping("/loans")
    public List<ClientLoanDTO> getLoan(){
        return clientLoanRepository.findAll().stream()
                .map(ClientLoanDTO::new)
                .collect(Collectors.toList());
    }
    @RequestMapping("loans/{id}")
    public ClientLoanDTO getLoan(@PathVariable Long id){
        return clientLoanRepository.findById(id)
                .map(ClientLoanDTO::new)
                .orElse(null);
    }
}
