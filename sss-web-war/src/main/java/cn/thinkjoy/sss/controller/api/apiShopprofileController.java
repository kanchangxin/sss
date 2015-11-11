/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  ShopprofileController.java 2015-11-11 11:46:43 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IShopprofileService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Shopprofile;
import cn.thinkjoy.sss.service.IShopprofileService;

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
public class apiShopprofileController{
    private static final Logger logger = LoggerFactory.getLogger(apiShopprofileController.class);

    @Autowired
    private IShopprofileService shopprofileService;

   /**
     * 新增 资源
     * @param shopprofile
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/shopprofile", method = RequestMethod.POST)
    public Object addShopprofile(@RequestBody Shopprofile shopprofile) {
        try {
            String msg = "";

            if(shopprofile==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(shopprofile.getKeyType())){
                msg = "资源不能为空";
            }else if(shopprofile.getKeyType().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(shopprofile.getKeyName())){
                msg = "资源不能为空";
            }else if(shopprofile.getKeyName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(shopprofile.getKeyValue())){
                msg = "资源不能为空";
            }else if(shopprofile.getKeyValue().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(shopprofile.getValueUnit())){
                msg = "资源不能为空";
            }else if(shopprofile.getValueUnit().length() > 50){
                msg = "资源长度不可超过50";
            }else if(shopprofile.getCreator() != null){
                msg = "资源不能为空";
            }else if(shopprofile.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(shopprofile.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(shopprofile.getLastModDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=shopprofileService.add(shopprofile);
            if(row > 0) {
                return new StringWrapper( shopprofile.getId().toString() );
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
     * @param {shopprofileId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shopprofile/{shopprofileId}" ,method = RequestMethod.DELETE)
    public Object delShopprofile(@PathVariable String shopprofileId) {
        try {
            if(StringUtils.isBlank(shopprofileId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=shopprofileService.deleteByProperty("id", shopprofileId);
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
     * @param shopprofile 提交上来的资源JSON数据
     * @param shopprofileId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/shopprofile/{shopprofileId}", method = RequestMethod.PATCH)
    public StringWrapper editShopprofile(@RequestBody Shopprofile shopprofile, @PathVariable String shopprofileId) {
        try {
            String msg = "";
            if(shopprofile==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(shopprofile.getKeyType())){
                msg = "资源不能为空";
            }else if(shopprofile.getKeyType().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(shopprofile.getKeyName())){
                msg = "资源不能为空";
            }else if(shopprofile.getKeyName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(shopprofile.getKeyValue())){
                msg = "资源不能为空";
            }else if(shopprofile.getKeyValue().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(shopprofile.getValueUnit())){
                msg = "资源不能为空";
            }else if(shopprofile.getValueUnit().length() > 50){
                msg = "资源长度不可超过50";
            }else if(shopprofile.getCreator() != null){
                msg = "资源不能为空";
            }else if(shopprofile.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(shopprofile.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(shopprofile.getLastModDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Shopprofile shopprofile_old = (Shopprofile) shopprofileService.findOne("id",shopprofileId);
            if(shopprofile==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(shopprofile.getId() != null){
                shopprofile_old.setId(shopprofile.getId());
            }
            if(!StringUtils.isBlank(shopprofile.getKeyType())){
                shopprofile_old.setKeyType(shopprofile.getKeyType());
            }
            if(!StringUtils.isBlank(shopprofile.getKeyName())){
                shopprofile_old.setKeyName(shopprofile.getKeyName());
            }
            if(!StringUtils.isBlank(shopprofile.getKeyValue())){
                shopprofile_old.setKeyValue(shopprofile.getKeyValue());
            }
            if(!StringUtils.isBlank(shopprofile.getValueUnit())){
                shopprofile_old.setValueUnit(shopprofile.getValueUnit());
            }
            if(shopprofile.getCreator() != null){
                shopprofile_old.setCreator(shopprofile.getCreator());
            }
            if(shopprofile.getCreatDate() != null){
                shopprofile_old.setCreatDate(shopprofile.getCreatDate());
            }
            if(shopprofile.getLastModifier() != null){
                shopprofile_old.setLastModifier(shopprofile.getLastModifier());
            }
            if(shopprofile.getLastModDate() != null){
                shopprofile_old.setLastModDate(shopprofile.getLastModDate());
            }


            int row=shopprofileService.edit(shopprofile_old);
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
     * @param shopprofileId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shopprofile/{shopprofileId}", method = RequestMethod.GET)
    public Shopprofile getShopprofile(@PathVariable String shopprofileId) {
        try {
            if(StringUtils.isBlank(shopprofileId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", shopprofileId);
            Shopprofile shopprofile= (Shopprofile) shopprofileService.queryOne(whereParams);
            if(null == shopprofile){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return shopprofile;
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
     * @param shopprofile 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/shopprofilelist", method = RequestMethod.POST)
    public BizData4Page shopprofilelist(Shopprofile shopprofile, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(shopprofile.getId() != null){
                whereParams.put("id", new SearchField("id", "=", shopprofile.getId()));
            }
            if(!StringUtils.isBlank(shopprofile.getKeyType())){
                whereParams.put("keyType", new SearchField("keyType", "like", "%" + shopprofile.getKeyType() + "%"));
            }
            if(!StringUtils.isBlank(shopprofile.getKeyName())){
                whereParams.put("keyName", new SearchField("keyName", "like", "%" + shopprofile.getKeyName() + "%"));
            }
            if(!StringUtils.isBlank(shopprofile.getKeyValue())){
                whereParams.put("keyValue", new SearchField("keyValue", "like", "%" + shopprofile.getKeyValue() + "%"));
            }
            if(!StringUtils.isBlank(shopprofile.getValueUnit())){
                whereParams.put("valueUnit", new SearchField("valueUnit", "like", "%" + shopprofile.getValueUnit() + "%"));
            }
            if(shopprofile.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", shopprofile.getCreator()));
            }
            if(shopprofile.getCreatDate() != null){
                whereParams.put("creatDate", new SearchField("creatDate", "=", shopprofile.getCreatDate()));
            }
            if(shopprofile.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", shopprofile.getLastModifier()));
            }
            if(shopprofile.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", shopprofile.getLastModDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            shopprofileService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
