package com.cgpanda.EasyInvestServer.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "equities")
@Entity
public class Equity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "short_name")
    private String shortName;
    @Column(name = "code_name")
    private String codeName;
    @Column(name = "price")
    private double price;
    @Column(name = "close_price")
    private double closePrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }
}
