package com.oksoft.service;


import java.util.List;

import com.oksoft.binding.Contact;

public interface ContactService {

	boolean saveContact(Contact contact);
	
	List<Contact> getAllContacts();
	
	Contact getContactById(Integer contactId);
	
	boolean updateContact(Contact contact);
	
	boolean deleteContact(Integer contactId);
}
