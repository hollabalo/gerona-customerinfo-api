package com.recruitit.customerinfo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recruitit.customerinfo.model.Customer;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
