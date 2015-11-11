/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  ShopController.java 2015-11-11 11:46:42 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IShopService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Shop;
import cn.thinkjoy.sss.service.IShopService;

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
public class apiShopController{
    private static final Logger logger = LoggerFactory.getLogger(apiShopController.class);

    @Autowired
    private IShopService shopService;

   /**
     * 新增 资源
     * @param shop
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public Object addShop(@RequestBody Shop shop) {
        try {
            String msg = "";

            if(shop==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(shop.getShopName())){
                msg = "资源不能为空";
            }else if(shop.getShopName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(shop.getDifficulty())){
                msg = "资源不能为空";
            }else if(shop.getDifficulty().length() > 1){
                msg = "资源长度不可超过1";
            }else if(shop.getCreator() != null){
                msg = "资源不能为空";
            }else if(shop.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(shop.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(shop.getLastModDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=shopService.add(shop);
            if(row > 0) {
                return new StringWrapper( shop.getId().toString());
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
     * @param {shopId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shop/{shopId}" ,method = RequestMethod.DELETE)
    public Object delShop(@PathVariable String shopId) {
        try {
            if(StringUtils.isBlank(shopId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=shopService.deleteByProperty("id", shopId);
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
     * @param shop 提交上来的资源JSON数据
     * @param shopId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/shop/{shopId}", method = RequestMethod.PATCH)
    public StringWrapper editShop(@RequestBody Shop shop, @PathVariable String shopId) {
        try {
            String msg = "";
            if(shop==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(shop.getShopName())){
                msg = "资源不能为空";
            }else if(shop.getShopName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(shop.getDifficulty())){
                msg = "资源不能为空";
            }else if(shop.getDifficulty().length() > 1){
                msg = "资源长度不可超过1";
            }else if(shop.getCreator() != null){
                msg = "资源不能为空";
            }else if(shop.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(shop.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(shop.getLastModDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Shop shop_old = (Shop) shopService.findOne("id",shopId);
            if(shop==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(shop.getId() != null){
                shop_old.setId(shop.getId());
            }
            if(!StringUtils.isBlank(shop.getShopName())){
                shop_old.setShopName(shop.getShopName());
            }
            if(!StringUtils.isBlank(shop.getDifficulty())){
                shop_old.setDifficulty(shop.getDifficulty());
            }
            if(shop.getRoundBest() != null){
                shop_old.setRoundBest(shop.getRoundBest());
            }
            if(shop.getOverallBest() != null){
                shop_old.setOverallBest(shop.getOverallBest());
            }
            if(shop.getCreator() != null){
                shop_old.setCreator(shop.getCreator());
            }
            if(shop.getCreatDate() != null){
                shop_old.setCreatDate(shop.getCreatDate());
            }
            if(shop.getLastModifier() != null){
                shop_old.setLastModifier(shop.getLastModifier());
            }
            if(shop.getLastModDate() != null){
                shop_old.setLastModDate(shop.getLastModDate());
            }


            int row=shopService.edit(shop_old);
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
     * @param shopId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shop/{shopId}", method = RequestMethod.GET)
    public Shop getShop(@PathVariable String shopId) {
        try {
            if(StringUtils.isBlank(shopId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", shopId);
            Shop shop= (Shop) shopService.queryOne(whereParams);
            if(null == shop){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return shop;
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
     * @param shop 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/shoplist", method = RequestMethod.POST)
    public BizData4Page shoplist(Shop shop, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(shop.getId() != null){
                whereParams.put("id", new SearchField("id", "=", shop.getId()));
            }
            if(!StringUtils.isBlank(shop.getShopName())){
                whereParams.put("shopName", new SearchField("shopName", "like", "%" + shop.getShopName() + "%"));
            }
            if(!StringUtils.isBlank(shop.getDifficulty())){
                whereParams.put("difficulty", new SearchField("difficulty", "like", "%" + shop.getDifficulty() + "%"));
            }
            if(shop.getRoundBest() != null){
                whereParams.put("roundBest", new SearchField("roundBest", "=", shop.getRoundBest()));
            }
            if(shop.getOverallBest() != null){
                whereParams.put("overallBest", new SearchField("overallBest", "=", shop.getOverallBest()));
            }
            if(shop.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", shop.getCreator()));
            }
            if(shop.getCreatDate() != null){
                whereParams.put("creatDate", new SearchField("creatDate", "=", shop.getCreatDate()));
            }
            if(shop.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", shop.getLastModifier()));
            }
            if(shop.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", shop.getLastModDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            shopService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
