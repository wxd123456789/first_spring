package com.wxd.my_mall.services.impl;

import com.wxd.my_mall.mbg.mapper.CmsPrefrenceAreaMapper;
import com.wxd.my_mall.mbg.model.CmsPrefrenceArea;
import com.wxd.my_mall.mbg.model.CmsPrefrenceAreaExample;
import com.wxd.my_mall.services.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
