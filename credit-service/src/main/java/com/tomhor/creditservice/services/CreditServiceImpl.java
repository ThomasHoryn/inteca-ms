package com.tomhor.creditservice.services;

import com.tomhor.creditservice.commands.CreditCommand;
import com.tomhor.creditservice.model.Credit;
import com.tomhor.creditservice.repositories.CreditRepository;
import com.tomhor.creditservice.converters.CreditCommandToCredit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService{

    private final CreditRepository creditRepository;
    private final CreditCommandToCredit creditCommandToCredit;

    public CreditServiceImpl(CreditRepository creditRepository, CreditCommandToCredit creditCommandToCredit) {
        this.creditRepository = creditRepository;
        this.creditCommandToCredit = creditCommandToCredit;
    }

    @Override
    public Credit saveCredit(Credit credit) {

        return creditRepository.save(credit);

    }

    @Override
    public Credit saveCreditCommand(CreditCommand creditCommand) {

        Credit detachedCredit = creditCommandToCredit.convert(creditCommand);

        return creditRepository.save(detachedCredit);
    }

    @Override
    public List<Credit> getAllCredits() {

        List<Credit> allCredits = new ArrayList<>();

        creditRepository.findAll().iterator().forEachRemaining(allCredits::add);

        return allCredits;
    }
}
