package com.example.teamproject.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.teamproject.Service.EventBoardService;
import com.example.teamproject.Vo.EventBoardImgVo;
import com.example.teamproject.Vo.EventBoardVo;


@Controller
public class EventBoardController {
	
	@Autowired
	EventBoardService eventBoardService;
//	게시판 페이지 오픈
	@GetMapping("eventBoardList")
	public String openEventBoardList(@RequestParam(defaultValue = "1")  String category, Model model) {
		Map<String, Object> map = eventBoardService.selectEventBoardList(category);
		model.addAttribute("map", map);
		model.addAttribute("category",category);
		System.out.println("카테고리" + category);
		return "/eventBoard/eventBoardList";
	}
//	게시판 쓰기 오픈
	@GetMapping("eventBoardWrite")
	public String openEventBoardWrtie(HttpSession session,Model model) {
		String fm_id = (String)session.getAttribute("session_id");
		Map<String,Object> map = eventBoardService.selectFinfoNameList(fm_id);
		model.addAttribute("map",map);
		return "/eventBoard/eventBoardWrite";
	}
//	게시판 쓰기 
	@PostMapping("eventBoardWrite")
	public String eventBoardInsert(EventBoardVo eventBoardVo,
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		ArrayList<EventBoardImgVo> imgList = new ArrayList<EventBoardImgVo>();
		String[] uploadFileName = null;
		if (files != null) {
			if (files.get(0).getSize() != 0) {
				String fileUrl = "C:\\Users\\jacks\\git\\project2\\teamproject2\\src\\main\\resources\\static\\img\\event\\";
				uploadFileName = new String[files.size()];

				for (int i = 0; i < files.size(); i++) {
					EventBoardImgVo img = new EventBoardImgVo();
					String originFileName = files.get(i).getOriginalFilename();
					System.out.println("originFileName : " + originFileName);
					long time = System.currentTimeMillis();
					// 1개의 파일이름을 변형해서 다시 저장
					uploadFileName[i] = String.format("%d_%s", time, originFileName);
					// 파일 복사
					File f = new File(fileUrl + uploadFileName[i]);
					files.get(i).transferTo(f);
					img.setImg_name(uploadFileName[i]);
					System.out.println("이미지이름"+img.getImg_name());
					imgList.add(img);
				}
				for (int i = 0; i < imgList.size(); i++) {
					System.out.println(imgList.get(i).getImg_name());

				}

			}
		}
		eventBoardService.eventBoardInsert(eventBoardVo, imgList);
		return "redirect:eventBoardList";
	}
//	게시글 불러오기
	@GetMapping("eventBoardView")
	public String eventBoardrView(@RequestParam(value = "eb_num") int eb_num, Model model) {
		Map<String, Object> map = eventBoardService.selectEventView(eb_num);
		model.addAttribute("map", map);
		return "/eventBoard/eventBoardView";
	}
//	게시판 삭제 ajax
	@PostMapping("eventBoardDelete")
	@ResponseBody
	public void eventBoardDelete(@RequestParam(value = "eb_num") int eb_num) {
		eventBoardService.eventBoardDelete(eb_num);
	}
	
//	게시글 수정페이지 오픈
	@GetMapping("eventBoardModifyView")
	public String eventBoardrModifyView(@RequestParam(value = "eb_num") int eb_num, Model model) {
		Map<String, Object> map = eventBoardService.selectEventBoardModifyView(eb_num);
		model.addAttribute("map", map);
		return "/eventBoard/eventBoardModify";
	}

	// 게시글 수정

	@PostMapping("eventBoardModify")
	public String eventBoardModify(EventBoardVo eventBoardVo, 
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		String[] uploadFileName = null;
		ArrayList<EventBoardImgVo> imgList = new ArrayList<EventBoardImgVo>();
		if (files != null) {
			for(int i=0; i<files.size(); i++) {
				EventBoardImgVo img = new EventBoardImgVo();
			if (files.get(i).getSize() != 0) {
				String fileUrl = "C:\\Users\\jacks\\git\\project2\\teamproject2\\src\\main\\resources\\static\\img\\event\\";
				uploadFileName = new String[files.size()];

					String originFileName = files.get(i).getOriginalFilename();
					System.out.println("originFileName : " + originFileName);
					long time = System.currentTimeMillis();
					// 1개의 파일이름을 변형해서 다시 저장
					uploadFileName[i] = String.format("%d_%s", time, originFileName);
					// 파일 복사
					File f = new File(fileUrl + uploadFileName[i]);
					files.get(i).transferTo(f);
					img.setImg_name(uploadFileName[i]);
					imgList.add(img);
					

				}else {
					img.setImg_name(null);
					imgList.add(img);
					System.out.println("파일쓰"+imgList.get(i).getImg_name());
					
				}
			}
		}
		System.out.println("수정");
		eventBoardService.eventBoardModify(eventBoardVo, imgList);
		return "redirect:eventBoardList";
	}
}

