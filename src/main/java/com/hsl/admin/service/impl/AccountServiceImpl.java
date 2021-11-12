package com.hsl.admin.service.impl;

import com.hsl.admin.bean.Account;
import com.hsl.admin.mapper.AccountMapper;
import com.hsl.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;
    public Account getAcctByid(Long id){
        return accountMapper.getAcct(id);
    }
}