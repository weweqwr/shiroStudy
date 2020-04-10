package com.goaway.entity;

public class gw_user_group {
    private Integer id;

    private Integer userid;

    private String groupid;

    private String groupnickname;

    private Integer groupidentification;

    private String tempgroupid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getGroupnickname() {
        return groupnickname;
    }

    public void setGroupnickname(String groupnickname) {
        this.groupnickname = groupnickname == null ? null : groupnickname.trim();
    }

    public Integer getGroupidentification() {
        return groupidentification;
    }

    public void setGroupidentification(Integer groupidentification) {
        this.groupidentification = groupidentification;
    }

    public String getTempgroupid() {
        return tempgroupid;
    }

    public void setTempgroupid(String tempgroupid) {
        this.tempgroupid = tempgroupid == null ? null : tempgroupid.trim();
    }
}