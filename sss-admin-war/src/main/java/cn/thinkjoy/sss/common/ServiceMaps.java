
/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  sssServiceMaps.java 2015-11-06 15:47:21 $
 */

package cn.thinkjoy.sss.common;

import cn.thinkjoy.common.service.IBaseService;
import cn.thinkjoy.sss.service.IDemoService;


import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

import cn.thinkjoy.common.managerui.controller.helpers.BaseServiceMaps;

/**
 * Created by shurrik on 14-9-24.
 */
@Service("sssServiceMaps")
public class ServiceMaps extends BaseServiceMaps{


    @Autowired
    private IDemoService demoService;

    @PostConstruct
    public void init(){
        super.init();
        serviceMap.put("demo",demoService);
    }

}