package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	

	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	
	//�ۼ���
	public void updateBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.updateBoard",vo);
	}
	
	//�� ����
	public void deleteBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.deleteBoard",vo);
	}
	
	//�� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	//�� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo){
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
}
