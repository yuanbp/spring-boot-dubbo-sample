package com.sbtdubbo.api.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecPermission implements Serializable {
    private static final long serialVersionUID = 1L;

    private String permissionId;

    private String permissionName;

    private Date createdTime;


    private Date updateTime;

    //private List<SecRole> roles = new ArrayList<>();

}