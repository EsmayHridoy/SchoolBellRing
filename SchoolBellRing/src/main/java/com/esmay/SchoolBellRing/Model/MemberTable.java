package com.esmay.SchoolBellRing.Model;

public class MemberTable {
    int id;
    String memberName;
    String memberMail;
    String password;
    String address;
    String memberRole;

    public MemberTable() {
    }

    public MemberTable(String memberMail, String password) {

        this.memberMail = memberMail;
        this.password = password;
    }
    public MemberTable(int id, String memberName, String memberMail, String password, String address, String memberRole) {
        this.id = id;
        this.memberName = memberName;
        this.memberMail = memberMail;
        this.password = password;
        this.address = address;
        this.memberRole = memberRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberMail() {
        return memberMail;
    }

    public void setMemberMail(String memberMail) {
        this.memberMail = memberMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }
}
