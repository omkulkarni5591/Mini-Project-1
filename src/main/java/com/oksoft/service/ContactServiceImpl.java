package com.oksoft.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.oksoft.binding.Contact;
import com.oksoft.entities.ContactEntity;
import com.oksoft.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		ContactEntity contactEntity = new ContactEntity();
		BeanUtils.copyProperties(contact, contactEntity);
		ContactEntity saveEntity = contactRepository.save(contactEntity);
		return saveEntity.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities = contactRepository.findAll();

		/*
		 * ArrayList<Contact> contacts = new ArrayList<Contact>(); for (ContactEntity
		 * entity : entities) { Contact contact = new Contact();
		 * BeanUtils.copyProperties(entity, contact); contacts.add(contact); } return
		 * contacts;
		 */
	      return entities.stream().map(entity->{
	    	  Contact contact=new Contact();
	    	  BeanUtils.copyProperties(entity, contact);
	    	  return contact;
	      }).collect(Collectors.toList());
	      
	      
	}

	@Override
	public Contact getContactById(Integer contactId) {
        Optional<ContactEntity> findById = contactRepository.findById(contactId);
        if(findById.isPresent()) {
        	ContactEntity contactEntity = findById.get();
        	Contact contact=new Contact();
        	BeanUtils.copyProperties(contactEntity, contact);
        	return contact;
        }
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(@RequestParam("cid")Integer contactId) {
             contactRepository.deleteById(contactId);
		return true;
	}

}
