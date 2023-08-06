package com.devsuperior.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.desafio.entity.Client;
import com.devsuperior.desafio.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity <Page<Client>> findAll(Pageable pageable) {
		Page<Client> client = service.findAll(pageable);
		return ResponseEntity.ok().body(client);
	}
	
}
