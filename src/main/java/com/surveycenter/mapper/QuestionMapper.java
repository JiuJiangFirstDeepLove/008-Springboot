package com.surveycenter.mapper;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("select `qid`,`qtitle`,`qtype`,`sid` from questions where `sid`=#{0} and isDelete=0")
    List<Question> getQuestionListBySid(int sid);//获取问卷问题
    @Insert("insert into questions(qtitle, qtype, createTime, lastTime, isDelete, sid) values(#{qtitle}, #{qtype}, NOW(), NOW(), 0, #{sid})")
    int addQueText(@Param("qtitle") String qtitle, @Param("qtype") int qtype, @Param("sid") int sid);//添加简答题
    @Insert("insert into questions(qtitle, qtype, createTime, lastTime, isDelete, sid) values(#{qtitle}, #{qtype}, NOW(), NOW(), 0, #{sid})")
    @SelectKey(statement="select last_insert_id()",before=false,keyProperty="qid",resultType=Integer.class,keyColumn="qid")
    int addQueChos(Question quesChos);//添加选择题
    @Delete("delete from questions where qid=#{0}")
    int delQuestionByQid(int qid);//根据问题编号删除该问题
    @Update("update questions set qtitle=#{qtitle} where qid=#{qid}")
    int updateQuestion(@Param("qtitle") String qtitle, @Param("qid") int qid);//根据问题编号更新问题信息
    @Select("select qid,qtitle,qtype from questions where sid=#{0}")
    List<JSONObject> getQuesInfo(int sid);//根据问卷编号获取问题信息列表
}
