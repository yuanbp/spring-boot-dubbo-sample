package com.sbtdubbo.api.domain;

import java.io.Serializable;

/**
 * Created by Richard on 2017/10/25 0025.
 */
public class CityInfo implements Serializable {

    private static final long serialVersionUID = -1206754629311685463L;

    public CityInfo(){

    }

    public CityInfo(String zipCode, String cityName) {
        this.zipCode = zipCode;
        this.cityName = cityName;
    }

    private String zipCode;
    private String cityName;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
