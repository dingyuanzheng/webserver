package jili.bean.face;

import java.io.Serializable;

/**
 * Created by test on 2018/5/29.
 */

public class FaceUMyItemBean implements Serializable {

    /** id **/
    private int id;

    /** 名字 **/
    private String name;

    /** 编码 **/
    private String code;

    /** 等级 **/
    private String level;

    /** 等级序号 **/
    private int levelNum;

    /** 种类 **/
    private String category;

    /** 描述 **/
    private String description;

    /** 性别 **/
    private int sex;

    /** 代替编码 **/
    private String substituteCode;

    /** 默认装扮 **/
    private int defaultDress;

    /** 取消装扮 **/
    private int cancelDress;

    /** 下载地址 **/
    private String url;

    /** 版本号 **/
    private String version;

    /** 概率 **/
    private int rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSubstituteCode() {
        return substituteCode;
    }

    public void setSubstituteCode(String substituteCode) {
        this.substituteCode = substituteCode;
    }

    public int getDefaultDress() {
        return defaultDress;
    }

    public void setDefaultDress(int defaultDress) {
        this.defaultDress = defaultDress;
    }

    public int getCancelDress() {
        return cancelDress;
    }

    public void setCancelDress(int cancelDress) {
        this.cancelDress = cancelDress;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
