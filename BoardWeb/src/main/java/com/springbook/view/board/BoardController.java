package com.springbook.view.board;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.BoardListVO;


@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String, String> conditionMap =new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용","CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		
		//null check
		if(vo.getSearchCondition()==null)vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null)vo.setSearchKeyword("");

		//model정보 저장
		model.addAttribute("boardList",boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
	
	/*
	 * public String getBoardList(@RequestParam(value="searchCondition",
	 * defaultValue="TITLE", required=false)String condition
	 * , @RequestParam(value="searchKeyword", defaultValue="",required=false) String
	 * keyword ,BoardVO vo, BoardDAO boardDAO, Model model) {
	 * System.out.println("검색 조건 : " + condition); System.out.println("검색 단어 : " +
	 * keyword);
	 * 
	 * model.addAttribute("boardList",boardDAO.getBoardList(vo)); return
	 * "getBoardList.jsp"; }
	 */
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 초회 처리");

		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException{
		//파일 업로드 처리
		MultipartFile uploadFile =vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName =uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/"+fileName));
		}
		System.out.println("글 수정 처리");
		 
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("번호 : "+vo.getSeq());
		System.out.println("제목 : "+vo.getTitle());
		System.out.println("작성자 : "+ vo.getWriter());
		System.out.println("내용 : " +vo.getContent());
		System.out.println("등록일 : " +vo.getRegDate());
		System.out.println("조회수 : "+vo.getCnt());
		
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo){
		  System.out.println("글 삭제 처리");
		  
		  boardService.deleteBoard(vo);
		  return "redirect:getBoardList.do";
	}

}
