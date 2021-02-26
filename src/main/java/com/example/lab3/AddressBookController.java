package com.example.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressBookController {
    @Autowired
    AddressBookRepository repo;
    @Autowired
    BuddyInfoRepository buddyRepo;

    @GetMapping("/createAD")
    public String createAddressBook(Model model) {
        model.addAttribute("AddressBook", new AddressBook());
        return "AddressBook";
    }

    @PostMapping("/createAD")
    public String display(@ModelAttribute AddressBook ad, Model model){
        repo.save(ad);
        List<String> adrbooks = new ArrayList<>();

        for(AddressBook b: repo.findAll()){
            adrbooks.add("AddressBook Id: " + b.getId());
        }
        model.addAttribute("list",adrbooks);

        return "AddressBook";
    }

    @GetMapping("/createBud")
    public String createBuddy(Model model){

        model.addAttribute("newBuddyInfo", new BuddyInfo());

        //buddyRepo.findAll();
        return "BuddyInfo";
    }

    @PostMapping("/createBud")
    public String newBuddy(@RequestParam(value="name") String name,
                         @RequestParam(value="age") int age,
                         @RequestParam(value="bookId") int bid){
        BuddyInfo b = new BuddyInfo(name, age);
        AddressBook a = repo.findById(bid);
        a.addBuddy(b);
        buddyRepo.save(b);
        return "ViewBuddyInfos";
    }




}
