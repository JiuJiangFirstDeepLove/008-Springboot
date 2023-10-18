package com.surveycenter.mapper;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.pojo.Response;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResponseMapper {
    @Insert("insert into response(response, createTime, oid, qid, sid) values(#{response}, NOW(), #{oid}, #{qid}, #{sid})")
    int submitData(Response queData);//新增数据
    @Delete("delete from response where qid=#{0}")
    void delResponseByQid(int qid);//根据问题编号删除回答数据
    @Delete("delete from response where oid=#{0}")
    void delResponseByOid(int oid);//根据选项编号删除回答数据
    @Select("select rid,qid,response from response where qid=#{0}")
    List<JSONObject> getAnswersByQid(int qid);//根据问题编号获取回答数据
    @Select("select count(*) from response where oid=#{0}")
    int getCountByOid(int oid);//根据选项编号获取回答数据的条数
}
