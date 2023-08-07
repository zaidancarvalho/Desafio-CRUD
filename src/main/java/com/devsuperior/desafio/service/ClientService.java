package com.devsuperior.desafio.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafio.entity.Client;
import com.devsuperior.desafio.repository.ClientRepository;
import com.devsuperior.desafio.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<Client> findAll(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result.map(
				x -> new Client(x.getId(), x.getName(), x.getCpf(), x.getIncome(), x.getBirthDate(), x.getChildren()));
	}

	@Transactional(readOnly = true)
	public Client findById(Long id) {
		try {
			Client client = repository.findById(id).get();
			return client;
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Resource not found");
		}
	}

	@Transactional
	public Client insert(Client client) {
		return repository.save(client);
	}

	@Transactional
	public Client update(Long id, Client obj) {
	    try {
	        Client entity = repository.getReferenceById(id);
	        updateData(entity, obj); 
	        return repository.save(entity); 
	    } catch (EntityNotFoundException e) {
	        throw new ResourceNotFoundException("id " + id + " not found");
	    }
	}

	/*No meu log não aparece o tipo de exceção, então, 
	adaptei a forma de tratar a exceção usando o if*/
	@Transactional
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("id " + id + " not found");
		}
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
