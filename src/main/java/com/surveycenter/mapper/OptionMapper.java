package com.surveycenter.mapper;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.pojo.Option;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OptionMapper {
    @Select("select `oid`,`option`,`qid` from options where `qid`=#{0}")
    List<Option> getOptionListByQid(int qid);//获取问题选项
    @Insert("insert into options(`option`, createTime, lastTime, `qid`) values(#{option}, NOW(), NOW(), #{qid})")
    int addOption(@Param("option") String value, @Param("qid") int qid);//添加问题选项
    @Select("select `option` from options where `oid`=#{0}")
    String getOptionByOid(int oid);//获取选项内容
    @Delete("delete from options where `qid`=#{0}")
    int delOptionsByQid(int qid);//根据问题编号删除选项
    @Delete("delete from options where `oid`=#{0}")
    int delOptionByOid(int oid);//根据选项编号删除选项
    @Update("update options set `option`=#{option} where `oid`=#{oid}")
    int updateOption(@Param("option") String option, @Param("oid") int oid);//根据选项编号更新选项信息
    @Select("select oid,`option` from options where qid=#{qid}")
    List<JSONObject> getOpsInfo(int qid);//根据问题编号获取选项信息
}
