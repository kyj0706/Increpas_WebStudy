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

import com.example.teamproject.Service.NoriBoardService;
import com.example.teamproject.Vo.NoriBoardCommentVo;
import com.example.teamproject.Vo.NoriBoardImgVo;
import com.example.teamproject.Vo.NoriBoardVo;


@Controller
public class NoriBoardController {
	@Autowired
	NoriBoardService noriBoardService;
	
//	게시판 페이지 오픈
	@GetMapping("noriBoardList")
	public String openNoriBoardList(@RequestParam(value = "searchCategory") @Nullable String searchCategory,
			@RequestParam(defaultValue = "") String sportsCategory, @RequestParam(defaultValue = "") String searchWord,
			@RequestParam(defaultValue = "1") int page, Model model) {
		Map<String, Object> map = noriBoardService.selectNoriBoardList(searchCategory, sportsCategory, searchWord,
				page);
		System.out.println("search" + searchCategory);
		System.out.println("sports" + sportsCategory);
		System.out.println("word" + searchWord);
		model.addAttribute("map", map);
		return "/noriBoard/noriBoardList";
	}
//	게시판 쓰기 오픈
	@GetMapping("noriBoardWrite")
	public String openNoriBoardWrtie() {
		return "/noriBoard/noriBoardWrite";
	}

//	게시판 쓰기 
	@PostMapping("noriBoardWrite")
	public String noriBoardInsert(NoriBoardVo noriBoardVo,
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		ArrayList<NoriBoardImgVo> imgList = new ArrayList<NoriBoardImgVo>();
		String[] uploadFileName = null;
		if (files != null) {
			if (files.get(0).getSize() != 0) {
				String fileUrl = "C:\\upload\\nori\\";
				uploadFileName = new String[files.size()];

				for (int i = 0; i < files.size(); i++) {
					NoriBoardImgVo img = new NoriBoardImgVo();
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
		noriBoardService.noriBoardInsert(noriBoardVo, imgList);
		return "redirect:noriBoardList";
	}
	
//	게시글 불러오기
	@GetMapping("noriBoardView")
	public String noriBoardrView(@RequestParam(value = "nb_num") int nb_num, Model model) {
		Map<String, Object> map = noriBoardService.selectnoriBoardView(nb_num);
		model.addAttribute("map", map);
		return "/noriBoard/noriBoardView";
	}
//	게시판 삭제 ajax
	@PostMapping("noriBoardDelete")
	@ResponseBody
	public void noriBoardDelete(@RequestParam(value = "nb_num") int nb_num) {
		noriBoardService.noriBoardDelete(nb_num);
	}
//	게시글 수정페이지 오픈
	@GetMapping("noriBoardModifyView")
	public String noriBoardrModifyView(@RequestParam(value = "nb_num") int nb_num, Model model) {
		Map<String, Object> map = noriBoardService.selectNoriBoardModifyView(nb_num);
		model.addAttribute("map", map);
		return "/noriBoard/noriBoardModify";
	}

	// 게시글 수정

	@PostMapping("noriBoardModify")
	public String noriBoardModify(NoriBoardVo noriBoardVo, 
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		String[] uploadFileName = null;
		ArrayList<NoriBoardImgVo> imgList = new ArrayList<NoriBoardImgVo>();
		if (files != null) {
			for(int i=0; i<files.size(); i++) {
				NoriBoardImgVo img = new NoriBoardImgVo();
			if (files.get(i).getSize() != 0) {
				String fileUrl = "C:\\upload\\nori\\";
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
		noriBoardService.noriBoardModify(noriBoardVo, imgList);
		return "redirect:noriBoardList";
	}
	// 게시글 댓글 쓰기 ajax

		@PostMapping("noriBoardCommentWrite")
		@ResponseBody
		public Map<String, Object> noriBoardCommentWrite(NoriBoardCommentVo noriBoardCommentVo) {
			Map<String, Object> map = noriBoardService.noriBoardCommentWrite(noriBoardCommentVo);
			System.out.println("실행");
			return map;
		}
		
		// 게시글 댓글 수정 ajax
		@PostMapping("noriBoardCommentModify")
		@ResponseBody
		public Map<String, Object> noriBoardCommentModify(NoriBoardCommentVo noriBoardCommentVo) {
			Map<String, Object> map = noriBoardService.noriBoardCommentModify(noriBoardCommentVo);
			return map;
		}
		// 게시글 댓글 삭제 ajax

		@PostMapping("noriBoardCommentDelete")
		@ResponseBody
		public int freeBoardSellerCommentDelete(@RequestParam(value = "c_no") int c_no,
				@RequestParam(value = "nb_num") int nb_num) {
			int commentCount = noriBoardService.noriBoardCommentDelete(c_no, nb_num);
			return commentCount;
		}

}
