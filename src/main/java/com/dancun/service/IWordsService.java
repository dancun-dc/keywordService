package com.dancun.service;

import com.dancun.entity.Words;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dancun
 * @since 2020-10-24
 */
public interface IWordsService extends IService<Words> {
    public List<Words> list(String lan);
}
