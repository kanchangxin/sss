/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  MaterialsController.java 2015-11-11 11:46:41 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IMaterialsService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Materials;
import cn.thinkjoy.sss.service.IMaterialsService;

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
public class apiMaterialsController{
    private static final Logger logger = LoggerFactory.getLogger(apiMaterialsController.class);

    @Autowired
    private IMaterialsService materialsService;

   /**
     * 新增 资源
     * @param materials
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/materials", method = RequestMethod.POST)
    public Object addMaterials(@RequestBody Materials materials) {
        try {
            String msg = "";

            if(materials==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(materials.getName())){
                msg = "资源不能为空";
            }else if(materials.getName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(materials.getUnit())){
                msg = "资源不能为空";
            }else if(materials.getUnit().length() > 50){
                msg = "资源长度不可超过50";
            }else if(materials.getShelfLife() != null){
                msg = "资源不能为空";
            }else if(materials.getOrder() != null){
                msg = "资源不能为空";
            }else if(materials.getCreator() != null){
                msg = "资源不能为空";
            }else if(materials.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(materials.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(materials.getLastModDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=materialsService.add(materials);
            if(row > 0) {
                return new StringWrapper( materials.getId().toString());
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
     * @param {materialsId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/materials/{materialsId}" ,method = RequestMethod.DELETE)
    public Object delMaterials(@PathVariable String materialsId) {
        try {
            if(StringUtils.isBlank(materialsId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=materialsService.deleteByProperty("id", materialsId);
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
     * @param materials 提交上来的资源JSON数据
     * @param materialsId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/materials/{materialsId}", method = RequestMethod.PATCH)
    public StringWrapper editMaterials(@RequestBody Materials materials, @PathVariable String materialsId) {
        try {
            String msg = "";
            if(materials==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(materials.getName())){
                msg = "资源不能为空";
            }else if(materials.getName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(StringUtils.isBlank(materials.getUnit())){
                msg = "资源不能为空";
            }else if(materials.getUnit().length() > 50){
                msg = "资源长度不可超过50";
            }else if(materials.getShelfLife() != null){
                msg = "资源不能为空";
            }else if(materials.getOrder() != null){
                msg = "资源不能为空";
            }else if(materials.getCreator() != null){
                msg = "资源不能为空";
            }else if(materials.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(materials.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(materials.getLastModDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Materials materials_old = (Materials) materialsService.findOne("id",materialsId);
            if(materials==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(materials.getId() != null){
                materials_old.setId(materials.getId());
            }
            if(!StringUtils.isBlank(materials.getName())){
                materials_old.setName(materials.getName());
            }
            if(!StringUtils.isBlank(materials.getUnit())){
                materials_old.setUnit(materials.getUnit());
            }
            if(materials.getShelfLife() != null){
                materials_old.setShelfLife(materials.getShelfLife());
            }
            if(materials.getOrder() != null){
                materials_old.setOrder(materials.getOrder());
            }
            if(materials.getCreator() != null){
                materials_old.setCreator(materials.getCreator());
            }
            if(materials.getCreatDate() != null){
                materials_old.setCreatDate(materials.getCreatDate());
            }
            if(materials.getLastModifier() != null){
                materials_old.setLastModifier(materials.getLastModifier());
            }
            if(materials.getLastModDate() != null){
                materials_old.setLastModDate(materials.getLastModDate());
            }


            int row=materialsService.edit(materials_old);
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
     * @param materialsId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/materials/{materialsId}", method = RequestMethod.GET)
    public Materials getMaterials(@PathVariable String materialsId) {
        try {
            if(StringUtils.isBlank(materialsId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", materialsId);
            Materials materials= (Materials) materialsService.queryOne(whereParams);
            if(null == materials){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return materials;
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
     * @param materials 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/materialslist", method = RequestMethod.POST)
    public BizData4Page materialslist(Materials materials, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(materials.getId() != null){
                whereParams.put("id", new SearchField("id", "=", materials.getId()));
            }
            if(!StringUtils.isBlank(materials.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + materials.getName() + "%"));
            }
            if(!StringUtils.isBlank(materials.getUnit())){
                whereParams.put("unit", new SearchField("unit", "like", "%" + materials.getUnit() + "%"));
            }
            if(materials.getShelfLife() != null){
                whereParams.put("shelfLife", new SearchField("shelfLife", "=", materials.getShelfLife()));
            }
            if(materials.getOrder() != null){
                whereParams.put("order", new SearchField("order", "=", materials.getOrder()));
            }
            if(materials.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", materials.getCreator()));
            }
            if(materials.getCreatDate() != null){
                whereParams.put("creatDate", new SearchField("creatDate", "=", materials.getCreatDate()));
            }
            if(materials.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", materials.getLastModifier()));
            }
            if(materials.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", materials.getLastModDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            materialsService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
