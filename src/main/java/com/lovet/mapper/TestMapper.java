package com.lovet.mapper;

import com.lovet.entity.Test;

import java.util.List;

public interface TestMapper {

    List<Test> getAll();

    void insert(Test test);

    int count();
}
