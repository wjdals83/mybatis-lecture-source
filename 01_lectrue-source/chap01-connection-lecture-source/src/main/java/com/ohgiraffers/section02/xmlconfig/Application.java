package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {

        String resource = "mybatis-config.xml";

        /* 필기. Mybatis 측에서 제공하는 Resources 라는 클래스 */
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);   // xml 파일로 만든 환경 설정 정보 포함
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession(false);

            java.util.Date date = session.selectOne("mapper.selectSysdate");

            System.out.println("date = " + date);

            session.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
