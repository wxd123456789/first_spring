package com.wxd.my_mall.services.impl;

import com.wxd.my_mall.mbg.mapper.OmsCompanyAddressMapper;
import com.wxd.my_mall.mbg.model.OmsCompanyAddress;
import com.wxd.my_mall.mbg.model.OmsCompanyAddressExample;
import com.wxd.my_mall.services.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;

    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
