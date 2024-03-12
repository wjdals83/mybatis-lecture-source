package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.selectAllMenu");       // 모든 행 출력

    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {

        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);       // selectOne 은 한 행. 왼쪽은 호출하는 느낌, 오른쪽은 호출한 곳의 파라미터 값

    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.update("MenuMapper.updateMenu", menu);

    }

    public int deleteMenu(SqlSession sqlSession, int code) {

        return sqlSession.delete("MenuMapper.deleteMenu", code);

    }
}
