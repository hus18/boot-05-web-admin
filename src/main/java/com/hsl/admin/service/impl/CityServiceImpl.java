package com.hsl.admin.service.impl;

import com.hsl.admin.bean.City;
import com.hsl.admin.mapper.CityMapper;
import com.hsl.admin.service.CityService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl  implements CityService {
    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getById(id);
    }
    public void insert(City city){
        cityMapper.insert(city);
    }
}
