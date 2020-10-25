package com.dancun.controller;


import com.dancun.entity.Words;
import com.dancun.service.IWordsService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dancun
 * @since 2020-10-24
 */
@Slf4j
@RestController
@RequestMapping("/words")
public class WordsController {
    @Value(value = "classpath:keyword.json")
    private Resource resource;

    @Autowired
    IWordsService wordsService;

    @RequestMapping(value = "/list.json")
    public List<Words> list(String lan) {
        List<Words> list = null;
        try {
            list = wordsService.list(lan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/delete")
    public String del(Integer id) {
        int i = 0;
        String message = "";
        try {
            wordsService.removeById(id);
            message = "success";
        } catch (Exception e) {
            e.printStackTrace();
            message = "error";
        }
        return "{\"state\":" + i + ",\"message\":" + message + "}";
    }

    @RequestMapping(value = "/save")
    public String save(Words words) {
        int i = 0;
        String message = "";
        try {
            wordsService.save(words);
            message = "success";
        } catch (Exception e) {
            e.printStackTrace();
            message = "error";
        }
        return "{\"state\":" + i + ",\"message\":" + message + "}";
    }

    @RequestMapping(value = "/test")
    public String test(String lan) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuffer message = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            message.append(line);
        }
        String defaultString = message.toString();
        String result = defaultString.replace("\r\n", "").replaceAll(" +", "");
        JSONObject jsonObject = JSONObject.fromObject(result);
        int l = 0;
        String mes = "";
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String teams = keys.next();
            JSONArray jsonArray = jsonObject.getJSONArray(teams);
            for (int i = 0; i < jsonArray.size(); i++) {
                Words words = new Words();
                words.setKeyword(jsonArray.getJSONObject(i).getString("keyword"));
                words.setLan(teams);
                words.setType(jsonArray.getJSONObject(i).getString("type"));
                try{
                    words.setRightkey(jsonArray.getJSONObject(i).getString("rightkey"));
                }catch (Exception e){
                    log.debug("没有rightkey");
                }

                try {
                    wordsService.save(words);
                    mes = "success";
                    l = 1;
                } catch (Exception e) {
                    e.printStackTrace();
                    mes = "error";
                }
            }

        }


        return "{\"state\":" + l + ",\"message\":" + mes + "}";
    }

    @RequestMapping(value = "/update")
    public String update(Words words) {
        int i = 0;
        String message = "";
        try {
            wordsService.updateById(words);
            message = "success";
        } catch (Exception e) {
            e.printStackTrace();
            message = "error";
        }
        return "{\"state\":" + i + ",\"message\":" + message + "}";
    }

}
