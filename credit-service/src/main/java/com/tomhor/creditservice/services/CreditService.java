package com.tomhor.creditservice.services;

import com.tomhor.creditservice.commands.CreditCommand;
import com.tomhor.creditservice.model.Credit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditService {
    Credit saveCredit(Credit credit);

    Credit saveCreditCommand(CreditCommand creditCommand);

    List<Credit> getAllCredits();
}
