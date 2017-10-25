package com.sbtdubbo.api.interfaces;

import com.sbtdubbo.api.domain.CityInfo;

/**
 * Created by Richard on 2017/10/25 0025.
 */
public interface CityService {

    /**
     * 根据邮编查询城市
     * @param zipCode
     */
    CityInfo findCityByZipCode(String zipCode) throws Exception;
}
