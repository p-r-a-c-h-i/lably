package com.xfactor.lably.repository;

import com.xfactor.lably.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}