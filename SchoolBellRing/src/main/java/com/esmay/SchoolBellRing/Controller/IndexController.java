package com.esmay.SchoolBellRing.Controller;


import com.esmay.SchoolBellRing.Model.MemberTable;
import com.esmay.SchoolBellRing.Service.IndexServceImpl;
import com.esmay.SchoolBellRing.Service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    IndexService indexService;


    @GetMapping
    public String index(){

        return "index";
    }

    @PostMapping("/submitMember")
    public String memberRegistration(@ModelAttribute MemberTable memberTable){

        System.out.println("ID: " + memberTable.getId());
        System.out.println("Name: " + memberTable.getMemberName());
        System.out.println("Email: " + memberTable.getMemberMail());
        System.out.println("Password: " + memberTable.getPassword());
        System.out.println("Address: " + memberTable.getAddress());
        System.out.println("Role: " + memberTable.getMemberRole());

        if(indexService.registrationMember(memberTable))
            return "loginPage";

        return "index";
    }


    @PostMapping("/loginPage")
    public String loginButton(){
        System.out.println("hi");
        return "loginPage";
    }
}
