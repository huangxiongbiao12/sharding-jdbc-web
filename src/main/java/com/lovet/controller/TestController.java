package com.lovet.controller;

import com.lovet.entity.Test;
import com.lovet.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RestController
@RequestMapping("test")
public class TestController {

    volatile private static int id = 1;

    @Autowired
    private TestService testService;

    @RequestMapping("/getTests")
    @ResponseBody
    public Map getTests() {
        List<Test> tests = testService.getTests();
        int count = testService.count();
        Map map = new HashMap();
        map.put("count", count);
        map.put("tests", tests);
        return map;
    }

    //测试
    @RequestMapping(value = "/save")
    @ResponseBody
    public Test saveTransactional() {
        Random random = new Random();
        id = random.nextInt();
        Test test2 = new Test();
        test2.setId(Math.toIntExact(id));
        test2.setName("niaho");
        test2.setAge("78");
        testService.insertTransactional(test2);
        return test2;
    }
}
