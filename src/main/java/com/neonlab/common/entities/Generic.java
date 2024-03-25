package com.neonlab.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class Generic {

    public Generic(){
        this.createdAt = new Date();
        this.modifiedAt = new Date();
        this.deleted = false;
    }

    @Column(name = "created_at")
    private Date createdAt; // != null

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_at")
    private Date modifiedAt;  //!= null

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "deleted")
    private boolean deleted;


}
