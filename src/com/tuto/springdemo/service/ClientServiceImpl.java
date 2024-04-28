package com.tuto.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import com.tuto.springdemo.dao.ClientDAO;
import com.tuto.springdemo.dao.ClientDAOImpl;
import com.tuto.springdemo.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	public ClientDAO clientDAO;

	@Override
	@Transactional
	public List<Client> getClient() {
		
		
		return clientDAO.getClient();
	}
	
	@Override
	@Transactional
	public void saveClient(Client leClient) {
		
		clientDAO.saveClient(leClient);
	}

	@Override
	@Transactional
	public Client getClient(int theId) {
		
		
		return clientDAO.getClient(theId);
	}

	@Override
	@Transactional
	public void deleteClient(int theId) {

		clientDAO.deleteClient(theId);		
		
	}

}
