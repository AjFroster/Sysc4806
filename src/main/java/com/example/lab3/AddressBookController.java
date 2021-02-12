package com.example.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        //AddressBook aBook = new AddressBook();

       /* for (BuddyInfo buddy:
                buddyRepo.findAll()) {
            aBook.addBuddy(buddy);

        }*/
        repo.save(ad);

        model.addAttribute("newAddressBook",ad);
        return "AddressBook";
    }

    @GetMapping("/createBud")
    public Iterable<BuddyInfo> findBuddy(){
        return buddyRepo.findAll();
    }

    @PostMapping("/createBud")
    public void newBuddy(@RequestParam(value="name") String name,
                         @RequestParam(value="age") int age,
                         @RequestParam(value="bookid") int bid){
        BuddyInfo b = new BuddyInfo(name, age);
        AddressBook a = repo.findById(bid);
        a.addBuddy(b);
        buddyRepo.save(b);
    }




}
