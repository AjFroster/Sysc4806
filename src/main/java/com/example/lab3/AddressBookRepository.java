package com.example.lab3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Ajfoster

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface AddressBookRepository extends CrudRepository <AddressBook, Long>{

    AddressBook findById (long id);
}