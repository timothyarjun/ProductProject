package com.spring.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pro.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
