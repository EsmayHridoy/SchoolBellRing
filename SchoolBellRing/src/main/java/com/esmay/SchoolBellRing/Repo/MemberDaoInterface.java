package com.esmay.SchoolBellRing.Repo;

import com.esmay.SchoolBellRing.Model.MemberTable;

public interface MemberDaoInterface{
    public boolean insertMember(MemberTable member);
    public boolean checkMemberMail(MemberTable member);
    public boolean checkMemberCredential(MemberTable member);
    public MemberTable getAllInformationOfMember(MemberTable member);
}
