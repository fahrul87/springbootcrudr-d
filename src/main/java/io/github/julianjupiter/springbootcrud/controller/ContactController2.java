package io.github.julianjupiter.springbootcrud.controller;


import io.github.julianjupiter.springbootcrud.domain.Contact2;

import io.github.julianjupiter.springbootcrud.service.ContactService2;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contacts2")
public class ContactController2 {
    private ContactService2 contactService2;

    @Autowired
    public void setContactService(ContactService2 contactService2) {
        this.contactService2 = contactService2;
    }
    
    @RequestMapping(value = { "", "/" })
    public String index(Model model) {
        model.addAttribute("activePage", "contacts2");
        model.addAttribute("contacts2", this.contactService2.getAllContacts());
        return "contacts2/index";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addContactForm(Contact2 contact2, Model model) {
        model.addAttribute("activePage", "contacts2");
        return "contacts2/add";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@Valid Contact2 contact2, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("activePage", "contacts2");
            return "contacts2/add";
        }
        
        this.contactService2.saveContact(contact2);
        return "redirect:/contacts2";
    }
    
    @RequestMapping(value = "/view/{id}")
    public String viewContact(@PathVariable Integer id, Model model) {
        model.addAttribute("contact2", this.contactService2.getContactById(id));
        model.addAttribute("activePage", "contacts2");
        return "contacts2/view";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editContact(@PathVariable Integer id, Model model) {
        model.addAttribute("contact2", this.contactService2.getContactById(id));
        model.addAttribute("activePage", "contacts2");
        return "contacts2/edit";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateContact(Contact2 contact2) {
        System.out.println("Contact ID: " + contact2.getId());
        this.contactService2.saveContact(contact2);
        return "redirect:/contacts2/view/" + contact2.getId();
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable Integer id) {
        this.contactService2.deleteContact(id);
        return "redirect:/contacts2";
    }
    
}
