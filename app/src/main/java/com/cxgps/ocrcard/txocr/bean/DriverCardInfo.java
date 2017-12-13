package com.cxgps.ocrcard.txocr.bean;

import java.io.Serializable;

/**
 * Created by taosong on 2017/12/13.
 */

public class DriverCardInfo implements Serializable {

    private String driverName;   // 用户名

    private String driverIdCard;   // 身份证号码

    private String driverNational;  // 国籍

    private String driverAddress;  // 家庭地址

    private String driverBirth;  // 出生年月日

    private String driverSignDate; // 领证日期

    private String driverType;  // 准驾车型

    private String driverValiDate;  // 有效日期

    private String driverStartDate;  // 起始日期

    private String imageUrl; //截图保存地址，预留


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverIdCard() {
        return driverIdCard;
    }

    public void setDriverIdCard(String driverIdCard) {
        this.driverIdCard = driverIdCard;
    }

    public String getDriverNational() {
        return driverNational;
    }

    public void setDriverNational(String driverNational) {
        this.driverNational = driverNational;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public String getDriverBirth() {
        return driverBirth;
    }

    public void setDriverBirth(String driverBirth) {
        this.driverBirth = driverBirth;
    }

    public String getDriverSignDate() {
        return driverSignDate;
    }

    public void setDriverSignDate(String driverSignDate) {
        this.driverSignDate = driverSignDate;
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public String getDriverValiDate() {
        return driverValiDate;
    }

    public void setDriverValiDate(String driverValiDate) {
        this.driverValiDate = driverValiDate;
    }

    public String getDriverStartDate() {
        return driverStartDate;
    }

    public void setDriverStartDate(String driverStartDate) {
        this.driverStartDate = driverStartDate;
    }
}
