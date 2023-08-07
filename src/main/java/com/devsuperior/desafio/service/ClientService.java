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
	
	@Transactional
	public Client insert(Client client) {
		return repository.save(client);
	}
	
	@Transactional
	public Client update(Long id, Client obj) {
		Client entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
		entity.setIncome(obj.getIncome());
		entity.setBirthDate(obj.getBirthDate());
		entity.setChildren(obj.getChildren());
	}
}
