package com.surveycenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.surveycenter.mapper.ResponseMapper;
import com.surveycenter.pojo.Response;
import com.surveycenter.service.ResponseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Resource
    private ResponseMapper responseMapper;

    @Override
    public int submitData(Response queData) {
        return responseMapper.submitData(queData);
    }

    @Override //根据问题编号删除回答数据
    public void delResponseByQid(int qid) {
        responseMapper.delResponseByQid(qid);
    }

    @Override //根据选项编号删除回答数据
    public void delResponseByOid(int oid) {
        responseMapper.delResponseByOid(oid);
    }

    @Override //根据问题编号获取回答数据
    public List<JSONObject> getAnswersByQid(int qid) {
        return responseMapper.getAnswersByQid(qid);
    }

    @Override //根据选项编号获取回答数据的条数
    public int getCountByOid(int oid) {
        return responseMapper.getCountByOid(oid);
    }
}
