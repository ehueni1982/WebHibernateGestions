package com.tuto.springdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.*;

import com.tuto.springdemo.entity.Client;
import com.tuto.springdemo.service.ClientService;

@Controller
//http://localhost:8080/WebHibernateGestions/client/list
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/list")
	public String ListClients(Model theModel) {
		//Obtention list des clients
		List<Client> lesClients = clientService.getClient();
		
		theModel.addAttribute("clients",lesClients);
		
		//list-Clients pour le jsp
		return "list-Clients";
	}
	
	@GetMapping("/afficherformAjouter")
	public String afficherformAjouter(Model theModel) {
		
		Client leClient = new Client();
		theModel.addAttribute("client", leClient);
		
		
		
		return "client-form";
		
		
	}
	
	@PostMapping("/saveClient")
	public String saveClient(@ModelAttribute("client") Client leClient) {
		//Sauvegarder un client en utilisant le service
	   clientService.saveClient(leClient);
		
		return "redirect:/client/list";
	}
	
	@GetMapping("/afficherFormModifier")
	public String afficherFormModifier(@RequestParam("clientId") int theId, Model theModel){
		
		//Récuperation du client 
		Client leclient = clientService.getClient(theId);
		//Définir le client comme model attribute
		theModel.addAttribute("client",leclient);
		
		return "client-form";
		
	}
	
	@GetMapping("/suppression")
	public String suppression(@RequestParam("clientId") int theId) {
		
		clientService.deleteClient(theId);	
		
		return "redirect:/client/list";
		
		
	
		
	}

}
