package com.devsuperior.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
}
