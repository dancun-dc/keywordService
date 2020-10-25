package com.dancun.controller;


import com.dancun.entity.Lan;
import com.dancun.service.ILanService;
import com.dancun.service.ILanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dancun
 * @since 2020-10-24
 */
@RestController
@RequestMapping("/lan")
public class LanController {
    @Autowired
    ILanService lanService;

    @RequestMapping(value = "/list.json")
    public List<Lan> list(){
        List<Lan> list = null;
        try {
            list = lanService.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    @RequestMapping(value = "/delete")
    public String del(Integer id){
        int i=0;
        String message="";
        try {
            lanService.removeById(id);
            message="success";
        }catch (Exception e){
            e.printStackTrace();
            message="error";
        }
        return "{\"state\":"+i+",\"message\":"+message+"}";
    }
    @RequestMapping(value = "/save")
    public String save(Lan lan){
        int i=0;
        String message="";
        try {
            lanService.save(lan);
            message="success";
        }catch (Exception e){
            e.printStackTrace();
            message="error";
        }
        return "{\"state\":"+i+",\"message\":"+message+"}";
    }

    @RequestMapping(value = "/update")
    public String update(Lan lan){
        int i=0;
        String message="";
        try {
            lanService.updateById(lan);
            message="success";
        }catch (Exception e){
            e.printStackTrace();
            message="error";
        }
        return "{\"state\":"+i+",\"message\":"+message+"}";
    }

}

