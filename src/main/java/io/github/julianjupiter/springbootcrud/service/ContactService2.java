package io.github.julianjupiter.springbootcrud.service;


import io.github.julianjupiter.springbootcrud.domain.Contact2;

public interface ContactService2 {
    Iterable<Contact2> getAllContacts();
    Contact2 getContactById(Integer id);
    Contact2 saveContact(Contact2 contact2);
    void deleteContact(Integer id);
}
