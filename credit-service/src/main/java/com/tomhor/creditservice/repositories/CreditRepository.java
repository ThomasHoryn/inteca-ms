package com.tomhor.creditservice.repositories;

import com.tomhor.creditservice.model.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
}
