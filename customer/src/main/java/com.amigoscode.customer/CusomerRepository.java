package com.amigoscode.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CusomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> getByFamilyLike(String family);
}
