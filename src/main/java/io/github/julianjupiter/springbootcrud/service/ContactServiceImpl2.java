package io.github.julianjupiter.springbootcrud.service;
import io.github.julianjupiter.springbootcrud.domain.Contact2;
import io.github.julianjupiter.springbootcrud.repository.ContactRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl2 implements ContactService2 {

    private ContactRepository2 contactRepository2;
    
    @Autowired
    public void setContactRepository(ContactRepository2 contactRepository2) {
        this.contactRepository2 = contactRepository2;
    }
    
    @Override
    public Iterable<Contact2> getAllContacts() {
        return this.contactRepository2.findAll();
    }
    
    @Override
    public Contact2 getContactById(Integer id) {
        return this.contactRepository2.findOne(id);
    }
    
    @Override
    public Contact2 saveContact(Contact2 contact2) {
        return this.contactRepository2.save(contact2);
    }
    
    @Override
    public void deleteContact(Integer id) {
        this.contactRepository2.delete(id);
    }
    
}
