package com.tomhor.creditservice.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomerCommand {

    private long creditId;

    private String firstName;

    private String lastName;

    private long pesel;
}
