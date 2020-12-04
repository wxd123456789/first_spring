package com.wxd.my_mall.services.impl;

import com.wxd.my_mall.mbg.mapper.UmsMemberLevelMapper;
import com.wxd.my_mall.mbg.model.UmsMemberLevel;
import com.wxd.my_mall.mbg.model.UmsMemberLevelExample;
import com.wxd.my_mall.services.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员等级管理Service实现类
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;

    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
