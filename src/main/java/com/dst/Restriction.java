package com.dst;

import java.util.Date;

public class Restriction {
    private String name;
    private Date resolvedAt;

    public Restriction(String name, Date resolvedAt) {
        this.name = name;
        this.resolvedAt = resolvedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(Date resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
}
