package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardController {

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 초회 처리");

		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
		/*
		 * //1. 검색할 게시글 번호 추출 String seq = request.getParameter("seq");
		 * 
		 * //2. DB 연동 처리 BoardVO vo = new BoardVO(); vo.setSeq(Integer.parseInt(seq));
		 * BoardDAO boardDAO = new BoardDAO(); BoardVO board = boardDAO.getBoard(vo);
		 * 
		 * 
		 * //3. 검색 결과를 세션에 저장하고 상세 화면으로 이동한다. HttpSession session =request.getSession();
		 * //session.setAttribute("board", board); return "getBoard";
		 * 
		 * 
		 * ModelAndView mav= new ModelAndView(); mav.addObject("board",board);
		 * mav.setViewName("getBoard"); return mav;
		 */
	}

}
