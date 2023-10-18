package com.surveycenter.service;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.pojo.Survey;

import java.util.List;

public interface SurveyService {
    List<Survey> getAllSurveys();

    List<Survey> getSurveysByUid(int uid);

    List<Survey> getSurveysByKey(String keyword);

    String getStitleBySid(int sid);

    int addSurvey(Survey survey);

    int setStitle(int sid, String stitle);

    List<Survey> getMySurveysByKey(int uid, String s);

    int setPublish(int i, int sid);

    List<JSONObject> getSurveysInfo();

    List<JSONObject> surveysSearch(String s);

    void updateLastTime(int sid);

    int delSurveyBySid(int sid);

    int getPublishBySid(int sid);
}
