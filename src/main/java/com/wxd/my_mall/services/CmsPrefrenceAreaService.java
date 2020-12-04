package com.wxd.my_mall.services;


import com.wxd.my_mall.mbg.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 优选专区Service
 */
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<CmsPrefrenceArea> listAll();
}
