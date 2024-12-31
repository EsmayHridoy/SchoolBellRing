package com.esmay.SchoolBellRing.Controller;

import com.esmay.SchoolBellRing.Model.MemberTable;
import com.esmay.SchoolBellRing.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String GetCredintial(@ModelAttribute MemberTable member, Model model) {
        if(loginService.checkCredential(member)){

            member = loginService.getAllInfo(member);
            model.addAttribute("userName", member.getMemberName());
            model.addAttribute("userRole", member.getMemberRole());
            model.addAttribute("userAddress", member.getAddress());
            return "newsfeed";
        }

        return "index";
    }
}
