package com.bowerstechnologies.seamstress.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bowerstechnologies.seamstress.entities.Client;
import com.bowerstechnologies.seamstress.entities.ClientOrder;
import com.bowerstechnologies.seamstress.repositories.ClientOrderRepository;
import com.bowerstechnologies.seamstress.repositories.ClientRepository;

@Controller
public class SeamstressController {
    
    private final ClientRepository clientRepository;
    private final ClientOrderRepository clientOrderRepository;

    @Autowired
    public SeamstressController(ClientRepository clientRepository, ClientOrderRepository clientOrderRepository) {
        this.clientRepository = clientRepository;
        this.clientOrderRepository = clientOrderRepository;
    }
    
    @GetMapping("/index")
    public String showHomePage(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "index";
    }

    @GetMapping("/clients")
    public String showClientList(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }

    @GetMapping("/orders")
    public String showClientOrderList(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("clientsOrders", clientOrderRepository.findAll());
        return "orders";
    }
    
    @GetMapping("/addclient")
    public String showAddClientForm(Client client) {
        return "add-client";
    }
    
    @PostMapping("/addclient")
    public String addClient(@Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-client";
        }
        
        clientRepository.save(client);
        return "redirect:/index";
    }
    
    @GetMapping("/addorder")
    public String showAddOrderForm(ClientOrder clientOrder, Model model) {
        Map<Long, String> map = new HashMap<Long, String>();
        
        for (Client c : clientRepository.findAll()) {
            map.put(c.getId(), c.getName());
        }
        
    	model.addAttribute("map", map);
        return "add-order";
    }
    
    @PostMapping("/addorder")
    public String addOrder(@Valid ClientOrder clientOrder, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-order";
        }
        
        clientOrderRepository.save(clientOrder);
        return "redirect:/index";
    }
    
    
    
    
    @GetMapping("/editclient/{id}")
    public String showUpdateClientForm(@PathVariable("id") long id, Model model) {
    	Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        
        return "update-client";
    }
    
    @PostMapping("/updateclient/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	client.setId(id);
            return "update-client";
        }
        
        clientRepository.save(client);

        return "redirect:/index";
    }
    
    @GetMapping("/editorder/{id}")
    public String showUpdateOrderForm(@PathVariable("id") long id, Model model) {
    	ClientOrder clientOrder = clientOrderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client order Id:" + id));
        model.addAttribute("clientOrder", clientOrder);
        
        return "update-order";
    }
    
    @PostMapping("/updateorder/{id}")
    public String updateClientOrder(@PathVariable("id") long id, @Valid ClientOrder clientOrder, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	clientOrder.setId(id);
            return "update-order";
        }
        
        clientOrderRepository.save(clientOrder);

        return "redirect:/index";
    }
    
    
    
    
    @GetMapping("/deleteclient/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
    	Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
    	clientRepository.delete(client);
        
        return "redirect:/clients";
    }
    
    @GetMapping("/deleteorder/{id}")
    public String deleteClientOrder(@PathVariable("id") long id, Model model) {
    	ClientOrder clientOrder = clientOrderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client order Id:" + id));
    	clientOrderRepository.delete(clientOrder);
        
        return "redirect:/orders";
    }
    
}

