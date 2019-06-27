package com.tomhor.creditservice.converters;

import com.tomhor.creditservice.commands.CreditCommand;
import com.tomhor.creditservice.model.Credit;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CreditCommandToCredit implements Converter<CreditCommand, Credit> {

    @Synchronized
    @Nullable
    @Override
    public Credit convert(CreditCommand source) {
        if (source == null) {
            return null;
        }
        final Credit credit = new Credit();

        credit.setCreditName(source.getCreditName());

        return credit;
    }

}
