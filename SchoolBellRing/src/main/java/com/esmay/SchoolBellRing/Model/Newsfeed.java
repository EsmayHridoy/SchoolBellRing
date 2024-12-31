package com.esmay.SchoolBellRing.Model;

import java.time.LocalDateTime;

public class Newsfeed {
    private int newsId;
    private int memberId;
    private String headline;
    private String content;
    private LocalDateTime date;
    private boolean adminApproval;

    public Newsfeed() {
    }

    public Newsfeed(int newsId, int memberId, String headline, String content, LocalDateTime date, boolean adminApproval) {
        this.newsId = newsId;
        this.memberId = memberId;
        this.headline = headline;
        this.content = content;
        this.date = date;
        this.adminApproval = adminApproval;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isAdminApproval() {
        return adminApproval;
    }

    public void setAdminApproval(boolean adminApproval) {
        this.adminApproval = adminApproval;
    }
}
