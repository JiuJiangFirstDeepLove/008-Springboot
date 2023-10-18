package com.surveycenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.mapper.QuestionMapper;
import com.surveycenter.pojo.Question;
import com.surveycenter.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;
    @Override // 获取问卷的问题列表
    public List<Question> getQuestionListBySid(int sid) {
        return questionMapper.getQuestionListBySid(sid);
    }

    @Override // 添加简答题
    public int addQueText(String qtitle, int qtype, int sid) {
        return questionMapper.addQueText(qtitle,qtype,sid);
    }

    @Override // 添加选择题
    public int addQueChos(Question quesChos) {
        int count = questionMapper.addQueChos(quesChos);
        if (count > 0)//添加成功，返回问题编号
            return quesChos.getQid();
        else
            return -1;
    }

    @Override //根据问题编号删除该问题
    public int delQuestionByQid(int qid) {
        return questionMapper.delQuestionByQid(qid);
    }

    @Override //根据问题编号更新问题信息
    public int updateQuestion(String qtitle, int qid) {
        return questionMapper.updateQuestion(qtitle,qid);
    }

    @Override //根据问卷编号获取问题信息列表
    public List<JSONObject> getQuesInfo(int sid) {
        return questionMapper.getQuesInfo(sid);
    }
}
