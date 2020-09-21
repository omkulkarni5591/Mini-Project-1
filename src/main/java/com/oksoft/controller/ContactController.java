package com.oksoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oksoft.binding.Contact;
import com.oksoft.service.ContactService;

@Controller
public class ContactController {
    
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value= {"/","/addContact"})
	public String loadForm(Model model) {
      Contact contact=new Contact();
		System.out.println("this is addForm() method");
       model.addAttribute("contact", contact);
      return "contactInfo";
	}
	@PostMapping(value="/saveContact")
	public String addSubmitBtn(@ModelAttribute("contact")Contact contact, RedirectAttributes attributes) {
		    boolean isSaved = contactService.saveContact(contact);
		    
		    if(isSaved) {
		    	//model.addAttribute("succMsg", "contact saved successfully");
		    	attributes.addFlashAttribute("succMsg", "contact saved successfully");
		    }else {
		    	attributes.addFlashAttribute("errMsg", "Failed to save contact");
		    }
		    return "redirect:/addSubmitBtnSucess";
	}
	@GetMapping(value= {"/addSubmitBtnSucess"})
	public String addSubmitBtnSucess(Model model) {
      
       model.addAttribute("contact", new Contact());
      return "contactInfo";
	}
	@GetMapping(value="/viewContacts")
	public String handleViewContactsLink(Model model) {
		List<Contact> contactList = contactService.getAllContacts();
		   model.addAttribute("contacts", contactList);
		   return "viewContacts";
	}
}
