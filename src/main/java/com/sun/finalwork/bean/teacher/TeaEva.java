package com.sun.finalwork.bean.teacher;

public class TeaEva {
    private String userNo;
    private String teacherRoomNo;
    private String userName;
    private String img;
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TeaEva{" +
                "userNo='" + userNo + '\'' +
                ", teacherRoomNo='" + teacherRoomNo + '\'' +
                ", userName='" + userName + '\'' +
                ", img='" + img + '\'' +
                ", flag=" + flag +
                '}';
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getTeacherRoomNo() {
        return teacherRoomNo;
    }

    public void setTeacherRoomNo(String teacherRoomNo) {
        this.teacherRoomNo = teacherRoomNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
