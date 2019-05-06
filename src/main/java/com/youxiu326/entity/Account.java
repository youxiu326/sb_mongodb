package com.youxiu326.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 账户
 */
@Document
public class Account {

    @Id
    private ObjectId id;

    private Float total;

    public Account(){}

    public Account(ObjectId id, Float total) {
        this.id = id;
        this.total = total;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}