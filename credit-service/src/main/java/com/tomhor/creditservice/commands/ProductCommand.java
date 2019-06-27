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
public class ProductCommand {

    private long Id;

    private long creditId;

    private String productName;

    private BigDecimal value;

    private BigDecimal quantity;

}
