package com.surveycenter.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface CountMapper {
    @Insert("INSERT INTO `count`(num,sid) VALUES(0, #{sid})")
    int addCountData(@Param("sid") int sid);// 添加一条问卷统计数据
    @Update("update `count` set num=num+1 where sid=#{sid}")
    int updateCount(@Param("sid") int sid);//更新问卷统计数据
    @Select("select num from `count` where sid=#{0}")
    int getNum(int sid);//获取统计数据
    @Delete("delete from `count` where sid=#{0}")
    int delCount(int sid);
}
