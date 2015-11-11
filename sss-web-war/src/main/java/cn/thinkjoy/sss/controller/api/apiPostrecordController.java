/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  PostrecordController.java 2015-11-11 11:46:41 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IPostrecordService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Postrecord;
import cn.thinkjoy.sss.service.IPostrecordService;

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
public class apiPostrecordController{
    private static final Logger logger = LoggerFactory.getLogger(apiPostrecordController.class);

    @Autowired
    private IPostrecordService postrecordService;

   /**
     * 新增 资源
     * @param postrecord
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/postrecord", method = RequestMethod.POST)
    public Object addPostrecord(@RequestBody Postrecord postrecord) {
        try {
            String msg = "";

            if(postrecord==null) {
                msg = "添加资源参数不正确";
            }else if(postrecord.getShopHistoryId() != null){
                msg = "资源不能为空";
            }else if(postrecord.getPostId() != null){
                msg = "资源不能为空";
            }else if(postrecord.getSalary() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=postrecordService.add(postrecord);
            if(row > 0) {
                return new StringWrapper( postrecord.getId().toString());
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源异常");
        }
    }


    /**
     * 删除 资源
     *
     * @param {postrecordId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postrecord/{postrecordId}" ,method = RequestMethod.DELETE)
    public Object delPostrecord(@PathVariable String postrecordId) {
        try {
            if(StringUtils.isBlank(postrecordId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=postrecordService.deleteByProperty("id", postrecordId);
            if(row > 0) {
                return new StringWrapper( "删除资源成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源异常");
        }
    }


    /**
     * 修改资源数据
     * @param postrecord 提交上来的资源JSON数据
     * @param postrecordId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/postrecord/{postrecordId}", method = RequestMethod.PATCH)
    public StringWrapper editPostrecord(@RequestBody Postrecord postrecord, @PathVariable String postrecordId) {
        try {
            String msg = "";
            if(postrecord==null) {
                msg = "添加资源参数不正确";
            }else if(postrecord.getShopHistoryId() != null){
                msg = "资源不能为空";
            }else if(postrecord.getPostId() != null){
                msg = "资源不能为空";
            }else if(postrecord.getSalary() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Postrecord postrecord_old = (Postrecord) postrecordService.findOne("id",postrecordId);
            if(postrecord==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(postrecord.getId() != null){
                postrecord_old.setId(postrecord.getId());
            }
            if(postrecord.getShopHistoryId() != null){
                postrecord_old.setShopHistoryId(postrecord.getShopHistoryId());
            }
            if(postrecord.getPostId() != null){
                postrecord_old.setPostId(postrecord.getPostId());
            }
            if(postrecord.getSalary() != null){
                postrecord_old.setSalary(postrecord.getSalary());
            }


            int row=postrecordService.edit(postrecord_old);
            if(row > 0) {
                return new StringWrapper("修改资源成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源数据异常");
        }
    }


    /**
     * 获取单资源实体
     *
     * @param postrecordId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/postrecord/{postrecordId}", method = RequestMethod.GET)
    public Postrecord getPostrecord(@PathVariable String postrecordId) {
        try {
            if(StringUtils.isBlank(postrecordId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", postrecordId);
            Postrecord postrecord= (Postrecord) postrecordService.queryOne(whereParams);
            if(null == postrecord){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return postrecord;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单资源实体异常");
        }
    }


    /**
     * 资源数据输出 带分页
     *
     * @param postrecord 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/postrecordlist", method = RequestMethod.POST)
    public BizData4Page postrecordlist(Postrecord postrecord, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(postrecord.getId() != null){
                whereParams.put("id", new SearchField("id", "=", postrecord.getId()));
            }
            if(postrecord.getShopHistoryId() != null){
                whereParams.put("shopHistoryId", new SearchField("shopHistoryId", "=", postrecord.getShopHistoryId()));
            }
            if(postrecord.getPostId() != null){
                whereParams.put("postId", new SearchField("postId", "=", postrecord.getPostId()));
            }
            if(postrecord.getSalary() != null){
                whereParams.put("salary", new SearchField("salary", "=", postrecord.getSalary()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            postrecordService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
