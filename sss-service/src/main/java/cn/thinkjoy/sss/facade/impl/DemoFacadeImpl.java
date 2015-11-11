/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  DemoFacadeImpl.java 2015-10-27 04:14:50 $
 */
package cn.thinkjoy.sss.facade.impl;

import cn.thinkjoy.sss.facade.IDemoFacade;
import cn.thinkjoy.sss.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DemoFacadeImpl")
public class DemoFacadeImpl implements IDemoFacade {
    @Autowired
    private IDemoService demoService;


//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public void add() {
//        demoService.add();
//    }
}
