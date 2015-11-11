/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  ShopFacadeImpl.java 2015-11-10 16:55:51 $
 */
package cn.thinkjoy.sss.facade.impl;

import cn.thinkjoy.sss.facade.IShopFacade;
import cn.thinkjoy.sss.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ShopFacadeImpl")
public class ShopFacadeImpl implements IShopFacade {
    @Autowired
    private IShopService shopService;


//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public void add() {
//        shopService.add();
//    }
}
