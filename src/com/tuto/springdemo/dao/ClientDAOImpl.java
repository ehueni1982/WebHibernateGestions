package com.tuto.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.*;

import com.tuto.springdemo.entity.Client;

@Repository
public class ClientDAOImpl implements ClientDAO {
	
	@Autowired
	//Permet d'établir des connexions via Hibernate d'exécuter des requêtes
	private SessionFactory sessionFactory;

	@Override
	public List<Client> getClient() {

		//Récupération de la session d'hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Création de la requête de la liste de tous les users le tri par nom
		Query<Client> theQuery = currentSession.createQuery("from Client order by nom", Client.class);
		
		List<Client> clients= theQuery.getResultList();
		
		
		return clients;
	}
	
	@Override
	public void saveClient(Client leClient) {
		
		//Recupération de session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Sauvegarder le client
		currentSession.saveOrUpdate(leClient);
	}
	
	@Override
	public Client getClient(int theId) {

		//Recupération de session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Client leClient = currentSession.get(Client.class, theId);
		
		return leClient;
		
	}

	@Override
	public void deleteClient(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		//On a utilisé le HQL pour la suppression
		Query theQuery = currentSession.createQuery("delete from Client where id=:leClientId");
		theQuery.setParameter("leClientId", theId);
		theQuery.executeUpdate();
		
	}

}
