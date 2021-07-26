package com.iitpkd.hospitalManagement.App.dto;

import javax.persistence.*;

@Entity
public class Utility {

    @Id
    @Column(nullable = false, updatable = false, name="Item_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer itemId;

    @Column(nullable = false, length = 36, name="Type")
    private String type;

    @Column(nullable = false, length = 36, name="Name")
    private String name;

    @Column(name="Number")
    private Integer number;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(final Integer itemId) {
        this.itemId = itemId;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(final Integer number) {
        this.number = number;
    }

}
