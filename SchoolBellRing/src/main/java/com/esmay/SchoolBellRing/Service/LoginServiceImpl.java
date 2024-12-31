package com.esmay.SchoolBellRing.Service;

import com.esmay.SchoolBellRing.Model.MemberTable;
import com.esmay.SchoolBellRing.Repo.MemberDao;
import com.esmay.SchoolBellRing.Utils.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginServiceImpl implements LoginService{
    @Autowired
    MemberDao memberDao;
    @Autowired
    HashPassword hashPassword;

    public boolean checkCredential(MemberTable member){
        boolean flag = false;

        System.out.println(member.getPassword());
        member.setPassword(HashPassword.hashPassword(member.getPassword()));
        System.out.println(member.getPassword());

        if(memberDao.checkMemberCredential(member)){
            flag=true;
        }


        return flag;
    }

    public MemberTable getAllInfo(MemberTable member){
        return memberDao.getAllInformationOfMember(member);
    }
}
