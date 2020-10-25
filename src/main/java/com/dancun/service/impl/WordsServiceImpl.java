package com.dancun.service.impl;

import com.dancun.entity.Words;
import com.dancun.mapper.WordsMapper;
import com.dancun.service.IWordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dancun
 * @since 2020-10-24
 */
@Service
public class WordsServiceImpl extends ServiceImpl<WordsMapper, Words> implements IWordsService {
    @Autowired
    WordsMapper wordsMapper;

    @Override
    public List<Words> list(String lan) {
        return wordsMapper.list(lan);
    }
}
