package com.devsuperior.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.desafio.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
