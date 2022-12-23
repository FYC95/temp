package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Admin;

public interface AdminDao extends BaseMapper<Admin> {
    //需要添加特有方法,通用方法被封装在BaseMapper
}
