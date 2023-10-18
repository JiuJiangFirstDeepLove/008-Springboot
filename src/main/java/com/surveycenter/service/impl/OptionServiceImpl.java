package com.surveycenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.mapper.OptionMapper;
import com.surveycenter.pojo.Option;
import com.surveycenter.service.OptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Resource
    private OptionMapper optionMapper;
    @Override
    public List<Option> getOptionListByQid(int qid) {
        return optionMapper.getOptionListByQid(qid);
    }

    @Override //添加问题选项
    public int addOption(String value, int qid) {
        return optionMapper.addOption(value,qid);
    }

    @Override //根据选项编号获取选项内容
    public String getOptionByOid(int oid) {
        return optionMapper.getOptionByOid(oid);
    }

    @Override //根据问题编号删除选项
    public int delOptionsByQid(int qid) {
        return optionMapper.delOptionsByQid(qid);
    }

    @Override //根据选项编号删除选项
    public int delOptionByOid(int oid) {
        return optionMapper.delOptionByOid(oid);
    }

    @Override //根据选项编号更新选项信息
    public int updateOption(String option, int oid) {
        return optionMapper.updateOption(option,oid);
    }

    @Override //根据问题编号获取选项信息
    public List<JSONObject> getOpsInfo(int qid) {
        return optionMapper.getOpsInfo(qid);
    }
}
