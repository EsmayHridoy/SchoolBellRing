package com.esmay.SchoolBellRing.Service;

import com.esmay.SchoolBellRing.Model.MemberTable;
import com.esmay.SchoolBellRing.Repo.MemberDao;
import com.esmay.SchoolBellRing.Utils.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class IndexServceImpl implements IndexService{

    @Autowired
    HashPassword hashPassword;
    @Autowired
    MemberDao memberDao;


    public boolean registrationMember(MemberTable member){
        boolean flag=false;
        if(memberDao.checkMemberMail(member))return flag;
        member.setPassword(HashPassword.hashPassword(member.getPassword()));
        flag = memberDao.insertMember(member);
        return flag;
    }

}
