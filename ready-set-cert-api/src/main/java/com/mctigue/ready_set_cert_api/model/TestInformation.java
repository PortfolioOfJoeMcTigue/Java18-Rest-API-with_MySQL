package com.mctigue.ready_set_cert_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "test_information")
public class TestInformation {

    @Id
    @Column
    private Integer id;
    @Column
    private String examName;
    @Column
    private Integer examCost;
    @Column
    private Integer passPercentage;
    @Column
    private String infoAddress;
    @Column
    private Integer active;
    @Column
    private String subcategory;
    @Column
    private String category;
    @Column
    private String gotoPage;
    @Column
    private String bgColor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getExamCost() {
        return examCost;
    }

    public void setExamCost(Integer examCost) {
        this.examCost = examCost;
    }

    public Integer getPassPercentage() {
        return passPercentage;
    }

    public void setPassPercentage(Integer passPercentage) {
        this.passPercentage = passPercentage;
    }

    public String getInfoAddress() {
        return infoAddress;
    }

    public void setInfoAddress(String infoAddress) {
        this.infoAddress = infoAddress;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGotoPage() {
        return gotoPage;
    }

    public void setGotoPage(String gotoPage) {
        this.gotoPage = gotoPage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    @Override
    public String toString() {
        return "TestInformation{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", examCost='" + examCost + '\'' +
                ", passPercentage='" + passPercentage + '\'' +
                ", infoAddress='" + infoAddress + '\'' +
                ", active='" + active + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", category='" + category + '\'' +
                ", gotoPage='" + gotoPage + '\'' +
                ", bgColor='" + bgColor + '\'' +
                '}';
    }
}
