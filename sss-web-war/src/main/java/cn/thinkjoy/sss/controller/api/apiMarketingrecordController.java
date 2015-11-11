/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  MarketingrecordController.java 2015-11-11 11:46:40 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IMarketingrecordService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Marketingrecord;
import cn.thinkjoy.sss.service.IMarketingrecordService;

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
public class apiMarketingrecordController{
    private static final Logger logger = LoggerFactory.getLogger(apiMarketingrecordController.class);

    @Autowired
    private IMarketingrecordService marketingrecordService;

   /**
     * 新增 资源
     * @param marketingrecord
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/marketingrecord", method = RequestMethod.POST)
    public Object addMarketingrecord(@RequestBody Marketingrecord marketingrecord) {
        try {
            String msg = "";

            if(marketingrecord==null) {
                msg = "添加资源参数不正确";
            }else if(marketingrecord.getShopHistoryId() != null){
                msg = "资源不能为空";
            }else if(marketingrecord.getMarketingId() != null){
                msg = "资源不能为空";
            }else if(marketingrecord.getCost() != null){
                msg = "资源不能为空";
            }else if(marketingrecord.getActivEffect() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=marketingrecordService.add(marketingrecord);
            if(row > 0) {
                return new StringWrapper( marketingrecord.getId().toString() );
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
     * @param {marketingrecordId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/marketingrecord/{marketingrecordId}" ,method = RequestMethod.DELETE)
    public Object delMarketingrecord(@PathVariable String marketingrecordId) {
        try {
            if(StringUtils.isBlank(marketingrecordId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=marketingrecordService.deleteByProperty("id", marketingrecordId);
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
     * @param marketingrecord 提交上来的资源JSON数据
     * @param marketingrecordId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/marketingrecord/{marketingrecordId}", method = RequestMethod.PATCH)
    public StringWrapper editMarketingrecord(@RequestBody Marketingrecord marketingrecord, @PathVariable String marketingrecordId) {
        try {
            String msg = "";
            if(marketingrecord==null) {
                msg = "添加资源参数不正确";
            }else if(marketingrecord.getShopHistoryId() != null){
                msg = "资源不能为空";
            }else if(marketingrecord.getMarketingId() != null){
                msg = "资源不能为空";
            }else if(marketingrecord.getCost() != null){
                msg = "资源不能为空";
            }else if(marketingrecord.getActivEffect() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Marketingrecord marketingrecord_old = (Marketingrecord) marketingrecordService.findOne("id",marketingrecordId);
            if(marketingrecord==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(marketingrecord.getId() != null){
                marketingrecord_old.setId(marketingrecord.getId());
            }
            if(marketingrecord.getShopHistoryId() != null){
                marketingrecord_old.setShopHistoryId(marketingrecord.getShopHistoryId());
            }
            if(marketingrecord.getMarketingId() != null){
                marketingrecord_old.setMarketingId(marketingrecord.getMarketingId());
            }
            if(marketingrecord.getCost() != null){
                marketingrecord_old.setCost(marketingrecord.getCost());
            }
            if(marketingrecord.getActivEffect() != null){
                marketingrecord_old.setActivEffect(marketingrecord.getActivEffect());
            }


            int row=marketingrecordService.edit(marketingrecord_old);
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
     * @param marketingrecordId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/marketingrecord/{marketingrecordId}", method = RequestMethod.GET)
    public Marketingrecord getMarketingrecord(@PathVariable String marketingrecordId) {
        try {
            if(StringUtils.isBlank(marketingrecordId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", marketingrecordId);
            Marketingrecord marketingrecord= (Marketingrecord) marketingrecordService.queryOne(whereParams);
            if(null == marketingrecord){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return marketingrecord;
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
     * @param marketingrecord 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/marketingrecordlist", method = RequestMethod.POST)
    public BizData4Page marketingrecordlist(Marketingrecord marketingrecord, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(marketingrecord.getId() != null){
                whereParams.put("id", new SearchField("id", "=", marketingrecord.getId()));
            }
            if(marketingrecord.getShopHistoryId() != null){
                whereParams.put("shopHistoryId", new SearchField("shopHistoryId", "=", marketingrecord.getShopHistoryId()));
            }
            if(marketingrecord.getMarketingId() != null){
                whereParams.put("marketingId", new SearchField("marketingId", "=", marketingrecord.getMarketingId()));
            }
            if(marketingrecord.getCost() != null){
                whereParams.put("cost", new SearchField("cost", "=", marketingrecord.getCost()));
            }
            if(marketingrecord.getActivEffect() != null){
                whereParams.put("activEffect", new SearchField("activEffect", "=", marketingrecord.getActivEffect()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            marketingrecordService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
