package com.hsl.admin.service;

import com.hsl.admin.bean.City;

public interface CityService {

    public City getById(Long id);
    public void insert(City city);
}
