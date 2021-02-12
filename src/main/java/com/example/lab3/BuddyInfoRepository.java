package com.example.lab3;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Ajfoster

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String name);

    BuddyInfo findById(long id);
}