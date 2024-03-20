package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
String companyName;

    public OutsourcedPart() {
        super(); // Calls the protected no-argument constructor of Part
    }

    // Calls another constructor of Part
    public OutsourcedPart(String name, double price, int inv, int minInv, int maxInv, String companyName) {
        super(name, price, inv, minInv, maxInv);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
