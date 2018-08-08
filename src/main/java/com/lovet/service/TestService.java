package com.lovet.service;

import com.lovet.entity.Test;
import com.lovet.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public List<Test> getTests() {
        List<Test> tests = testMapper.getAll();
        return tests;
    }

    //    @Transactional(value="test1TransactionManager",rollbackFor = Exception.class,timeout=36000)  //说明针对Exception异常也进行回滚，如果不标注，则Spring 默认只有抛出 RuntimeException才会回滚事务
    public void insertTransactional(Test test) {
        try{
            testMapper.insert(test);
        }catch(Exception e){
            throw e;   // 事物方法中，如果使用trycatch捕获异常后，需要将异常抛出，否则事物不回滚。
        }

    }

    public int count() {
        return testMapper.count();
    }
    
}
