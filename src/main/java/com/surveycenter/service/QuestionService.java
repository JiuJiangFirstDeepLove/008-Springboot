package com.surveycenter.service;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.pojo.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionListBySid(int sid);//根据问卷编号获取问题列表

    int addQueText(String qtitle, int qtype,int sid);//添加简答题

    int addQueChos(Question quesChos);//添加选择题

    int delQuestionByQid(int qid);//根据问题编号删除该问题

    int updateQuestion(String qtitle, int qid);//根据问题编号更新问题信息

    List<JSONObject> getQuesInfo(int sid);//根据问卷编号获取问题信息列表
}
