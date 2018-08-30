package jili.bean.student;

import java.io.Serializable;

public class student_studentInfoBean implements Serializable {
	 /** 头像 **/
    private String avatarUrl;

    /** 金币数量 **/
    private String coinCount;

    /** 当前积分 **/
    private int medalCount;

    /** 姓名 **/
    private String name;

    /** 学校名称 **/
    private String schoolName;

    /** 性别 **/
    private int sex;

    /** 等级 **/
    private int grade;

    private String code;

    /** 是否双师 **/
    private boolean isDoubleTeacher;

    /** 我的形象 **/
    private String fashionUrl;

    /** 是否有免费抽取机会0:没有，1:有 **/
    private int freeExtractingChance;

    /** 获取下一个免费抽取装扮时间的毫秒值 **/
    private int countDown;

    /**  是否确认过性别 **/
    private boolean wheConfirmGender;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(String coinCount) {
        this.coinCount = coinCount;
    }

    public int getMedalCount() {
        return medalCount;
    }

    public void setMedalCount(int medalCount) {
        this.medalCount = medalCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isDoubleTeacher() {
        return isDoubleTeacher;
    }

    public void setDoubleTeacher(boolean doubleTeacher) {
        isDoubleTeacher = doubleTeacher;
    }

    public String getFashionUrl() {
        return fashionUrl;
    }

    public void setFashionUrl(String fashionUrl) {
        this.fashionUrl = fashionUrl;
    }

    public int getFreeExtractingChance() {
        return freeExtractingChance;
    }

    public void setFreeExtractingChance(int freeExtractingChance) {
        this.freeExtractingChance = freeExtractingChance;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public boolean isWheConfirmGender() {
        return wheConfirmGender;
    }

    public void setWheConfirmGender(boolean wheConfirmGender) {
        this.wheConfirmGender = wheConfirmGender;
    }
}
