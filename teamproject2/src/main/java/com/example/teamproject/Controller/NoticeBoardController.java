package com.example.teamproject.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.teamproject.Service.NoticeBoardService;
import com.example.teamproject.Vo.NoticeBoardImgVo;
import com.example.teamproject.Vo.NoticeBoardVo;



@Controller
public class NoticeBoardController {
	
	@Autowired
	NoticeBoardService noticeBoardService;
	
//	게시판 페이지 오픈
	@GetMapping("noticeBoardList")
	public String openNoticeBoardList(@RequestParam(value = "searchCategory") @Nullable String searchCategory,
			@RequestParam(defaultValue = "") String sportsCategory, @RequestParam(defaultValue = "") String searchWord,
			@RequestParam(defaultValue = "1") int page, Model model) {
		Map<String, Object> map = noticeBoardService.selectNoticeBoardList(searchCategory, sportsCategory, searchWord,
				page);
		System.out.println("search" + searchCategory);
		System.out.println("sports" + sportsCategory);
		System.out.println("word" + searchWord);
		model.addAttribute("map", map);
		return "/noticeBoard/noticeBoardList";
	}
//	게시판 쓰기 오픈
	@GetMapping("noticeBoardWrite")
	public String openNoticeBoardWrtie() {
		return "/noticeBoard/noticeBoardWrite";
	}
//	게시판 쓰기 
	@PostMapping("noticeBoardWrite")
	public String noticeBoardInsert(NoticeBoardVo noticeBoardVo,
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		ArrayList<NoticeBoardImgVo> imgList = new ArrayList<NoticeBoardImgVo>();
		String[] uploadFileName = null;
		if (files != null) {
			if (files.get(0).getSize() != 0) {
				String fileUrl = "C:\\upload\\notice\\";
				uploadFileName = new String[files.size()];

				for (int i = 0; i < files.size(); i++) {
					NoticeBoardImgVo img = new NoticeBoardImgVo();
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
		noticeBoardService.noticeBoardInsert(noticeBoardVo, imgList);
		return "redirect:noticeBoardList";
	}
//	게시글 불러오기
	@GetMapping("noticeBoardView")
	public String noticeBoardrView(@RequestParam(value = "n_num") int n_num, Model model) {
		Map<String, Object> map = noticeBoardService.selectNoticeView(n_num);
		model.addAttribute("map", map);
		return "/noticeBoard/noticeBoardView";
	}
	
//	게시판 삭제 ajax
	@PostMapping("noticeBoardDelete")
	@ResponseBody
	public void noticeBoardDelete(@RequestParam(value = "n_num") int n_num) {
		noticeBoardService.noticeBoardDelete(n_num);
	}
	
//	게시글 수정페이지 오픈
	@GetMapping("noticeBoardModifyView")
	public String noticeBoardrModifyView(@RequestParam(value = "n_num") int n_num, Model model) {
		Map<String, Object> map = noticeBoardService.selectNoticeBoardModifyView(n_num);
		model.addAttribute("map", map);
		return "/noticeBoard/noticeBoardModify";
	}

	// 게시글 수정

	@PostMapping("noticeBoardModify")
	public String noticeBoardModify(NoticeBoardVo noticeBoardVo, 
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		String[] uploadFileName = null;
		ArrayList<NoticeBoardImgVo> imgList = new ArrayList<NoticeBoardImgVo>();
		if (files != null) {
			for(int i=0; i<files.size(); i++) {
				NoticeBoardImgVo img = new NoticeBoardImgVo();
			if (files.get(i).getSize() != 0) {
				String fileUrl = "C:\\upload\\notice\\";
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
		noticeBoardService.noticeBoardModify(noticeBoardVo, imgList);
		return "redirect:noticeBoardList";
	}
}
