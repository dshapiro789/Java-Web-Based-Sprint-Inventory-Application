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
@DiscriminatorValue("1")
public class InhousePart extends Part{
    int partId;

    public InhousePart() {
        super(); // Calls the protected no-argument constructor in Part
    }

    // Initializes all fields, including inherited ones
    public InhousePart(String name, double price, int inv, int minInv, int maxInv, int partId) {
        super(name, price, inv, minInv, maxInv);
        this.partId = partId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
