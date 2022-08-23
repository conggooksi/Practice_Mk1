package com.kuki.Practice_Mk1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubCable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subCableName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubCableName() {
        return subCableName;
    }

    public void setSubCableName(String subCableName) {
        this.subCableName = subCableName;
    }
}
