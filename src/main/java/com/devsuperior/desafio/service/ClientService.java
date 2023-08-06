package com.devsuperior.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio.entity.Client;
import com.devsuperior.desafio.repository.ClientRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<Client> findAll(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new Client(x.getId(), x.getName(), x.getCpf(), x.getIncome(), x.getBirthDate(), x.getChildren()));
	}
	
	@Transactional(readOnly = true)
	public Client findById(Long id) {
		Client client =  repository.findById(id).get();
		return client;
	}

}
