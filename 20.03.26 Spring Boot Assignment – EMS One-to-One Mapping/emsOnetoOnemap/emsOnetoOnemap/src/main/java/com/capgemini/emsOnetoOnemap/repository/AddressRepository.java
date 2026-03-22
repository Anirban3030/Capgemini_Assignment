package com.capgemini.emsOnetoOnemap.repository;

import com.capgemini.emsOnetoOnemap.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}