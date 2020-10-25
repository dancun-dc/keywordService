package com.dancun.mapper;

import com.dancun.entity.Words;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dancun
 * @since 2020-10-24
 */
@Mapper
public interface WordsMapper extends BaseMapper<Words> {

    @Select("select * from words where lan = #{lan}")
    public List<Words> list(String lan);

}
