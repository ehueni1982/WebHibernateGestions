package com.tuto.springdemo.dao;

import java.util.List;

import com.tuto.springdemo.entity.Client;

public interface ClientDAO {
	
	public List<Client> getClient();
	
	public void saveClient(Client leClient);
	
	public Client getClient(int theId);
	
	public void deleteClient(int theId);

}
