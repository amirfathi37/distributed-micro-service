package com.amigoscode.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CusomerRepository extends JpaRepository<Customer, Integer> {
}
