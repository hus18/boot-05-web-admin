package com.hsl.admin.mapper;

import com.hsl.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public Account getAcct(Long id);
}
