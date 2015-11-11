/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  MarketingController.java 2015-11-11 11:46:40 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IMarketingService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Marketing;
import cn.thinkjoy.sss.service.IMarketingService;

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
public class apiMarketingController{
    private static final Logger logger = LoggerFactory.getLogger(apiMarketingController.class);

    @Autowired
    private IMarketingService marketingService;

   /**
     * 新增 资源
     * @param marketing
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/marketing", method = RequestMethod.POST)
    public Object addMarketing(@RequestBody Marketing marketing) {
        try {
            String msg = "";

            if(marketing==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(marketing.getName())){
                msg = "资源不能为空";
            }else if(marketing.getName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(marketing.getCost() != null){
                msg = "资源不能为空";
            }else if(marketing.getEffect() != null){
                msg = "资源不能为空";
            }else if(marketing.getCreator() != null){
                msg = "资源不能为空";
            }else if(marketing.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(marketing.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(marketing.getLastModDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=marketingService.add(marketing);
            if(row > 0) {
                return new StringWrapper( marketing.getId().toString() );
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
     * @param {marketingId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/marketing/{marketingId}" ,method = RequestMethod.DELETE)
    public Object delMarketing(@PathVariable String marketingId) {
        try {
            if(StringUtils.isBlank(marketingId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=marketingService.deleteByProperty("id", marketingId);
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
     * @param marketing 提交上来的资源JSON数据
     * @param marketingId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/marketing/{marketingId}", method = RequestMethod.PATCH)
    public StringWrapper editMarketing(@RequestBody Marketing marketing, @PathVariable String marketingId) {
        try {
            String msg = "";
            if(marketing==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(marketing.getName())){
                msg = "资源不能为空";
            }else if(marketing.getName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(marketing.getCost() != null){
                msg = "资源不能为空";
            }else if(marketing.getEffect() != null){
                msg = "资源不能为空";
            }else if(marketing.getCreator() != null){
                msg = "资源不能为空";
            }else if(marketing.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(marketing.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(marketing.getLastModDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Marketing marketing_old = (Marketing) marketingService.findOne("id",marketingId);
            if(marketing==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(marketing.getId() != null){
                marketing_old.setId(marketing.getId());
            }
            if(!StringUtils.isBlank(marketing.getName())){
                marketing_old.setName(marketing.getName());
            }
            if(marketing.getCost() != null){
                marketing_old.setCost(marketing.getCost());
            }
            if(marketing.getEffect() != null){
                marketing_old.setEffect(marketing.getEffect());
            }
            if(marketing.getCreator() != null){
                marketing_old.setCreator(marketing.getCreator());
            }
            if(marketing.getCreatDate() != null){
                marketing_old.setCreatDate(marketing.getCreatDate());
            }
            if(marketing.getLastModifier() != null){
                marketing_old.setLastModifier(marketing.getLastModifier());
            }
            if(marketing.getLastModDate() != null){
                marketing_old.setLastModDate(marketing.getLastModDate());
            }


            int row=marketingService.edit(marketing_old);
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
     * @param marketingId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/marketing/{marketingId}", method = RequestMethod.GET)
    public Marketing getMarketing(@PathVariable String marketingId) {
        try {
            if(StringUtils.isBlank(marketingId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", marketingId);
            Marketing marketing= (Marketing) marketingService.queryOne(whereParams);
            if(null == marketing){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return marketing;
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
     * @param marketing 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/marketinglist", method = RequestMethod.POST)
    public BizData4Page marketinglist(Marketing marketing, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(marketing.getId() != null){
                whereParams.put("id", new SearchField("id", "=", marketing.getId()));
            }
            if(!StringUtils.isBlank(marketing.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + marketing.getName() + "%"));
            }
            if(marketing.getCost() != null){
                whereParams.put("cost", new SearchField("cost", "=", marketing.getCost()));
            }
            if(marketing.getEffect() != null){
                whereParams.put("effect", new SearchField("effect", "=", marketing.getEffect()));
            }
            if(marketing.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", marketing.getCreator()));
            }
            if(marketing.getCreatDate() != null){
                whereParams.put("creatDate", new SearchField("creatDate", "=", marketing.getCreatDate()));
            }
            if(marketing.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", marketing.getLastModifier()));
            }
            if(marketing.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", marketing.getLastModDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            marketingService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
