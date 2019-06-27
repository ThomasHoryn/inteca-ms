package com.tomhor.creditservice.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreditCommand {

    private long id;

    private String creditHolderFirstName;

    private String creditHolderLastName;

    private String creditName;

    private long creditHolderId;

    private long creditHolderPesel;

    private String productName;

    private BigDecimal productQuantity;

    private BigDecimal productValue;


}
