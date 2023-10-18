package com.surveycenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.mapper.CountMapper;
import com.surveycenter.mapper.SurveyMapper;
import com.surveycenter.pojo.Survey;
import com.surveycenter.service.SurveyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Resource
    private SurveyMapper surveyMapper;
    @Resource
    private CountMapper countMapper;
    @Override //获取所有问卷信息
    public List<Survey> getAllSurveys() {
        return surveyMapper.getAllSurveys();
    }

    @Override//获取用户创建的问卷
    public List<Survey> getSurveysByUid(int uid) {
        List<Survey> surveys = surveyMapper.getSurveysByUid(uid);
        for (Survey s:surveys) {
            int num = countMapper.getNum(s.getSid());
            s.setResponse(num);
        }
        return surveys;
    }

    @Override//根据关键字查找
    public List<Survey> getSurveysByKey(String keyword) {
        return surveyMapper.getSurveysByKey(keyword);
    }

    @Override// 根据问卷编号获取问卷标题
    public String getStitleBySid(int sid) {
        return surveyMapper.getStitleBySid(sid);
    }

    @Override
    public int addSurvey(Survey survey) {
        //添加问卷信息
        int res = surveyMapper.addSurvey(survey);
        if (res > 0){
            // 添加成功，res的值即问卷编号，添加一条统计数据
            int count = countMapper.addCountData(survey.getSid());
            if (count > 0)
                return survey.getSid();// 返回问卷编号
            else
                return 0;
        }else {
            return -1;//添加失败，返回-1
        }
    }

    @Override
    public int setStitle(int sid, String stitle) {
        return surveyMapper.setStitle(sid,stitle);
    }

    @Override
    public List<Survey> getMySurveysByKey(int uid, String keyword) {
        List<Survey> surveys = surveyMapper.getMySurveysByKey(uid,keyword);
        for(Survey s:surveys){
            int num = countMapper.getNum(s.getSid());
            s.setResponse(num);
        }
        return surveys;
    }

    @Override// 设置问卷状态
    public int setPublish(int i, int sid) {
        return surveyMapper.setPublish(i,sid);
    }

    @Override
    public List<JSONObject> getSurveysInfo() {
        return surveyMapper.getSurveysInfo();
    }

    @Override
    public List<JSONObject> surveysSearch(String s) {
        return surveyMapper.surveysSearch(s);
    }

    @Override
    public void updateLastTime(int sid) {
        surveyMapper.updateLastTime(sid);
    }

    @Override
    public int delSurveyBySid(int sid) {
        int countSurvey = surveyMapper.delSurvey(sid);
        if (countSurvey>0){
            int count = countMapper.delCount(sid);
            if (count>0) return count;
        }
        return -1;
    }

    @Override
    public int getPublishBySid(int sid) {
        return surveyMapper.getPublishBySid(sid);
    }
}
