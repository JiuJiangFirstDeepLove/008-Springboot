package com.surveycenter.service;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.pojo.Option;

import java.util.List;

public interface OptionService {
    List<Option> getOptionListByQid(int qid);

    int addOption(String value, int qid);//添加问题选项

    String getOptionByOid(int oid);//根据选项编号获取选项内容

    int delOptionsByQid(int qid);//根据问题编号删除选项

    int delOptionByOid(int oid);//根据选项编号删除选项

    int updateOption(String option, int oid);//根据选项编号更新选项信息

    List<JSONObject> getOpsInfo(int qid);//根据问题编号获取选项信息
}
