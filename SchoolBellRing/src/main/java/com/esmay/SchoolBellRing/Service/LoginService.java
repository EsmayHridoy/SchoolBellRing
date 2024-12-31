package com.esmay.SchoolBellRing.Service;

import com.esmay.SchoolBellRing.Model.MemberTable;

public interface LoginService {
    public boolean checkCredential(MemberTable member);
    public MemberTable getAllInfo(MemberTable member);
}
