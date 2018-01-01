package com.sbtdubbo.api.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;

    private String userName;

    private String password;

    private Date createdTime;

    private Date updateTime;

    //private List<SecRole> roles = new ArrayList<>();

}