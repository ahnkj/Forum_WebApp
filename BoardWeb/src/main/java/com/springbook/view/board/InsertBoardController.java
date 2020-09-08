package com.springbook.view.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

import org.springframework.stereotype.Controller;

//@Controller
public class InsertBoardController {

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAO boardDAO) {

		System.out.println("�� ���� ó��");
		 
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";

		/*
		 * // 1. ����� �Է� ���� ���� // request.setCharacterEncoding("EUC-KR"); String title =
		 * request.getParameter("title"); String writer =
		 * request.getParameter("writer"); String content =
		 * request.getParameter("content");
		 * 
		 * // 2. DB ���� ó�� BoardVO vo = new BoardVO(); vo.setTitle(title);
		 * vo.setWriter(writer); vo.setContent(content); BoardDAO boardDAO = new
		 * BoardDAO(); boardDAO.insertBoard(vo);
		 */

		/*
		 * //3. ȭ�� �׺���̼� return "getBoardList.do";
		 * 
		 * 
		 * ModelAndView mav = new ModelAndView();
		 * mav.setViewName("redirect:getBoardList.do"); return mav;
		 */
	}

}
