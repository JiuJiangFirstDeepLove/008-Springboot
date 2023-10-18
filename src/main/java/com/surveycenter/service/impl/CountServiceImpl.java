package com.surveycenter.service.impl;

import com.surveycenter.mapper.CountMapper;
import com.surveycenter.service.CountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CountServiceImpl implements CountService {
    @Resource
    private CountMapper countMapper;

    @Override
    public int updateCount(int sid) {
        return countMapper.updateCount(sid);
    }

    @Override
    public int getNum(int sid) {
        return countMapper.getNum(sid);
    }
}
