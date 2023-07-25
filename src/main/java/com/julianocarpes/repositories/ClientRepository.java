package com.julianocarpes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocarpes.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
