package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
    @Select("SELECT CURDATE() FROM DUAL")       // dual 은 curdate 를 사용하기 위한 가상의 공간
    java.util.Date selectSysdate(); // 호출을 당할 때 위의 쿼리문 실행.

}
