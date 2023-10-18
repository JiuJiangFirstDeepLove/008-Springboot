package com.surveycenter.mapper;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.pojo.Survey;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SurveyMapper {
    @Select("select sid, stitle,response from survey where publish=1")
    List<Survey> getAllSurveys();//获取所有问卷
    @Select("select * from survey where uid=#{0} order by survey.createTime desc ")
    List<Survey> getSurveysByUid(int uid);//获取用户创建的问卷
    @Select("select sid, stitle,response from survey where publish=1 and stitle like #{0}")
    List<Survey> getSurveysByKey(String keyword);//关键字查找
    @Select("select stitle from survey where sid=#{0}")
    String getStitleBySid(int sid);// 获取问卷标题
    @Insert("insert into survey(stitle, createTime, lastTime, publish, isDelete, uid, response) VALUES(#{stitle}, NOW(), NOW(), 0, 0, #{uid}, 0)")
    @SelectKey(statement="select last_insert_id()",before=false,keyProperty="sid",resultType=Integer.class,keyColumn="sid") // 返回该信息的问卷编号
    int addSurvey(Survey survey);// 添加新的问卷信息
    @Update("update survey set stitle=#{stitle} where sid=#{sid}")
    int setStitle(@Param("sid") int sid, @Param("stitle") String stitle);// 修改问卷标题
    @Select("select * from survey where uid = #{uid} and stitle like #{keyword} order by survey.createTime desc ")
    List<Survey> getMySurveysByKey(@Param("uid") int uid, @Param("keyword") String keyword);//根据关键字搜索我的问卷
    @Update("update survey set publish=#{publish} where sid=#{sid}")
    int setPublish(@Param("publish") int i, @Param("sid") int sid);//设置问卷状态
    @Select("select survey.sid, survey.stitle, count.num from survey INNER JOIN count where survey.sid=count.sid and survey.publish=1 ORDER BY count.num DESC")
    List<JSONObject> getSurveysInfo();
    @Select("select survey.sid, survey.stitle,count.num from survey INNER JOIN count where survey.sid=count.sid and survey.publish=1 and survey.stitle like #{0} ORDER BY count.num DESC")
    List<JSONObject> surveysSearch(String s);
    @Update("update survey set lastTime=now() where sid=#{0}")
    void updateLastTime(int sid);
    @Delete("delete from survey where sid=#{sid}")
    int delSurvey(int sid);
    @Select("select publish from survey where sid=#{0}")
    int getPublishBySid(int sid);
}
