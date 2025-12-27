package com.offcamplife.model;

import java.time.LocalDate;

public class PantryItem {

    private Long id;
    private String name;
    private String category;
    private String storageType;
    private LocalDate expiryDate;

    // No-arg constructor (required for DAO + JSP)
    public PantryItem() {
    }

    // Optional full constructor (useful later)
    public PantryItem(Long id, String name, String category,
                      String storageType, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.storageType = storageType;
        this.expiryDate = expiryDate;
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
