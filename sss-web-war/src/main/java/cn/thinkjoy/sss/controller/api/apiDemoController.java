/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  DemoController.java 2015-10-27 04:14:50 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IDemoService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;

import cn.thinkjoy.sss.domain.Demo;
import cn.thinkjoy.sss.service.IDemoService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/api")
public class apiDemoController{
    private static final Logger logger = LoggerFactory.getLogger(apiDemoController.class);

    @Autowired
    private IDemoService demoService;

    /**
     * 新增 增删改查范例
     * @param demo
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public Object addDemo(@RequestBody Demo demo) {
        try {
            String msg = "";

            if(demo==null) {
                msg = "添加增删改查范例参数不正确";
            }else if(demo.getCreator() != null){
                msg = "增删改查范例创建人不能为空";
            }else if(demo.getCreateDate() != null){
                msg = "增删改查范例创建时间不能为空";
            }else if(demo.getLastModifier() != null){
                msg = "增删改查范例修改人不能为空";
            }else if(demo.getLastModDate() != null){
                msg = "增删改查范例修改时间不能为空";
            }else if(demo.getStatus() != null){
                msg = "增删改查范例状态不能为空";
            }else if(StringUtils.isBlank(demo.getName())){
                msg = "增删改查范例名称不能为空";
            }else if(demo.getName().length() > 16){
                msg = "增删改查范例名称长度不可超过16";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=demoService.add(demo);
            if(row > 0) {
                return new StringWrapper(  demo.getId().toString()  );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增增删改查范例失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增增删改查范例异常");
        }
    }


    /**
     * 删除 增删改查范例
     *
     * @param {demoId} 增删改查范例ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/demo/{demoId}" ,method = RequestMethod.DELETE)
    public Object delDemo(@PathVariable String demoId) {
        try {
            if(StringUtils.isBlank(demoId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除增删改查范例失败，参数不正确");
            }
            int row=demoService.deleteByProperty("id", demoId);
            if(row > 0) {
                return new StringWrapper( "删除增删改查范例成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除增删改查范例失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除增删改查范例异常");
        }
    }


    /**
     * 修改增删改查范例数据
     * @param demo 提交上来的增删改查范例JSON数据
     * @param demoId  增删改查范例ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/demo/{demoId}", method = RequestMethod.PATCH)
    public StringWrapper editDemo(@RequestBody Demo demo, @PathVariable String demoId) {
        try {
            String msg = "";
            if(demo==null) {
                msg = "添加增删改查范例参数不正确";
            }else if(demo.getCreator() != null){
                msg = "增删改查范例创建人不能为空";
            }else if(demo.getCreateDate() != null){
                msg = "增删改查范例创建时间不能为空";
            }else if(demo.getLastModifier() != null){
                msg = "增删改查范例修改人不能为空";
            }else if(demo.getLastModDate() != null){
                msg = "增删改查范例修改时间不能为空";
            }else if(demo.getStatus() != null){
                msg = "增删改查范例状态不能为空";
            }else if(StringUtils.isBlank(demo.getName())){
                msg = "增删改查范例名称不能为空";
            }else if(demo.getName().length() > 16){
                msg = "增删改查范例名称长度不可超过16";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Demo demo_old = (Demo) demoService.findOne("id",demoId);
            if(demo==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(demo.getId() != null){
                demo_old.setId(demo.getId());
            }
            if(demo.getCreator() != null){
                demo_old.setCreator(demo.getCreator());
            }
            if(demo.getCreateDate() != null){
                demo_old.setCreateDate(demo.getCreateDate());
            }
            if(demo.getLastModifier() != null){
                demo_old.setLastModifier(demo.getLastModifier());
            }
            if(demo.getLastModDate() != null){
                demo_old.setLastModDate(demo.getLastModDate());
            }
            if(demo.getStatus() != null){
                demo_old.setStatus(demo.getStatus());
            }
            if(!StringUtils.isBlank(demo.getName())){
                demo_old.setName(demo.getName());
            }


            int row=demoService.edit(demo_old);
            if(row > 0) {
                return new StringWrapper("修改增删改查范例成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改增删改查范例失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改增删改查范例数据异常");
        }
    }


    /**
     * 获取单增删改查范例实体
     *
     * @param demoId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/demo/{demoId}", method = RequestMethod.GET)
    public Demo getDemo(@PathVariable String demoId) {
        try {
            if(StringUtils.isBlank(demoId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", demoId);
            Demo demo= (Demo) demoService.queryOne(whereParams);
            if(null == demo){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到增删改查范例相关数据！");
            }
            return demo;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单增删改查范例实体异常");
        }
    }


    /**
     * 增删改查范例数据输出 带分页
     *
     * @param demo 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/demolist", method = RequestMethod.POST)
    public BizData4Page demolist(Demo demo, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(demo.getId() != null){
                whereParams.put("id", new SearchField("id", "=", demo.getId()));
            }
            if(demo.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", demo.getCreator()));
            }
            if(demo.getCreateDate() != null){
                whereParams.put("createDate", new SearchField("createDate", "=", demo.getCreateDate()));
            }
            if(demo.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", demo.getLastModifier()));
            }
            if(demo.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", demo.getLastModDate()));
            }
            if(demo.getStatus() != null){
                whereParams.put("status", new SearchField("status", "=", demo.getStatus()));
            }
            if(!StringUtils.isBlank(demo.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + demo.getName() + "%"));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            demoService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询增删改查范例数据异常");
        }
    }
}