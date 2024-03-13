package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {
    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map); // 메소드명이 sql 문을 실행할 이름이다.


    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);
}
