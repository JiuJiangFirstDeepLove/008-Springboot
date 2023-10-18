package com.surveycenter.service;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.pojo.Response;

import java.util.List;

public interface ResponseService {
    int submitData(Response queData);

    void delResponseByQid(int qid);//根据问题编号删除回答数据

    void delResponseByOid(int oid);//根据选项编号删除回答数据

    List<JSONObject> getAnswersByQid(int qid);//根据问题编号获取回答数据

    int getCountByOid(int oid);//根据选项编号获取回答数据的条数
}
