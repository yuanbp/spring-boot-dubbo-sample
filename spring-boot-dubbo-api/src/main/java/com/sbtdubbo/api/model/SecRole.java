package com.sbtdubbo.api.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecRole implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roleId;

    private String roleName;

    private Date createdTime;

    private Date updateTime;

    //private List<SecPermission> permissions = new ArrayList<>();

}