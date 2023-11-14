package com.prakruthi.ui.ui.productPage;

import java.util.List;

public class ProductModel {
    private int id;
    private int categoryId;
    private int subcategoryId;
    private String name;
    private String description;
    private List<String> attachments;
    private String actualPrice;
    private String customerPrice;
    private String dealerPrice;
    private String martPrice;
    private int isTrending;
    private String youtubeLink;

    private String machine_type;

    private String color;
    private String size;

    private String units;
    private String type;
    private String status;

    private boolean is_review;
    private String rating;
    private String count_rating;

    private boolean in_wishlist;

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIs_review() {
        return is_review;
    }

    public boolean getIs_review() {
        return is_review;
    }

    public void setIs_review(boolean is_review) {
        this.is_review = is_review;
    }



    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCount_rating() {
        return count_rating;
    }

    public void setCount_rating(String count_rating) {
        this.count_rating = count_rating;
    }

    public boolean isIn_wishlist() {
        return in_wishlist;
    }

    public void setIn_wishlist(boolean in_wishlist) {
        this.in_wishlist = in_wishlist;
    }

//    public boolean in_wishlist;

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for categoryId
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    // Getter and Setter for subcategoryId
    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for attachments
    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    // Getter and Setter for actualPrice
    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    // Getter and Setter for customerPrice
    public String getCustomerPrice() {
        return customerPrice;
    }

    public void setCustomerPrice(String customerPrice) {
        this.customerPrice = customerPrice;
    }

    // Getter and Setter for dealerPrice
    public String getDealerPrice() {
        return dealerPrice;
    }

    public void setDealerPrice(String dealerPrice) {
        this.dealerPrice = dealerPrice;
    }

    // Getter and Setter for martPrice
    public String getMartPrice() {
        return martPrice;
    }

    public void setMartPrice(String martPrice) {
        this.martPrice = martPrice;
    }

    // Getter and Setter for isTrending
    public int getIsTrending() {
        return isTrending;
    }

    public void setIsTrending(int isTrending) {
        this.isTrending = isTrending;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMachine_type() {
        return machine_type;
    }

    public void setMachine_type(String machine_type) {
        this.machine_type = machine_type;
    }
}