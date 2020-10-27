package com.dancun.mapper;

import com.dancun.entity.Lan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dancun
 * @since 2020-10-24
 */
@Repository//消除service层爆红,无关紧要,或者在main入口添加mapper扫描
@Mapper
public interface LanMapper extends BaseMapper<Lan> {

}
