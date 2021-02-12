package com.example.lab3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Ajfoster

@Entity
public class AddressBook {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany
    List<BuddyInfo> buddyCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<BuddyInfo> getBuddy() {
        return buddyCollection;
    }

    public void setBuddy(Collection<BuddyInfo> buddies){
        this.buddyCollection = (List<BuddyInfo>) buddies;
    }

    public void addBuddy(BuddyInfo aBuddyInfo) {
        if (aBuddyInfo != null) {
            this.buddyCollection.add(aBuddyInfo);
        }

    }

    public AddressBook() {
        // TODO Auto-generated constructor stub
        buddyCollection = new ArrayList<BuddyInfo>();
    }


}
