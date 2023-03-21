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

import com.example.teamproject.Service.FreeBoardService;
import com.example.teamproject.Vo.FreeBoardMemberCommentVo;
import com.example.teamproject.Vo.FreeBoardMemberImgVo;
import com.example.teamproject.Vo.FreeBoardMemberVo;
import com.example.teamproject.Vo.FreeBoardSellerCommentVo;
import com.example.teamproject.Vo.FreeBoardSellerImgVo;
import com.example.teamproject.Vo.FreeBoardSellerVo;


@Controller
public class FreeBoardController {
	@Autowired
	FreeBoardService freeBoardService;


//	자유 게시판 (회원)=====================================================================================================================

//	게시판 페이지 오픈
	@GetMapping("freeBoardMemberList")
	public String openFreeBoardMemberList(@RequestParam(value = "searchCategory") @Nullable String searchCategory,
			@RequestParam(defaultValue = "") String sportsCategory, @RequestParam(defaultValue = "") String searchWord,
			@RequestParam(defaultValue = "1") int page, Model model) {
		Map<String, Object> map = freeBoardService.selectFreeMemberBoardList(searchCategory, sportsCategory, searchWord,
				page);
		System.out.println("search" + searchCategory);
		System.out.println("sports" + sportsCategory);
		System.out.println("word" + searchWord);
		model.addAttribute("map", map);
		return "/freeBoardMember/freeBoardMemberList";
	}

//	게시판 쓰기 오픈
	@GetMapping("freeBoardMemberWrite")
	public String openFreeBoardMemberWrtie() {
		return "/freeBoardMember/freeBoardMemberWrite";
	}

//	게시판 쓰기 
	@PostMapping("freeBoardMemberWrite")
	public String freeBoardMemberInsert(FreeBoardMemberVo freeBoardMemberVo,
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {

		ArrayList<FreeBoardMemberImgVo> imgList = new ArrayList<FreeBoardMemberImgVo>();
		String[] uploadFileName = null;
		if (files != null) {
			if (files.get(0).getSize() != 0) {
				String fileUrl = "C:\\upload\\freeMember\\";
				uploadFileName = new String[files.size()];

				for (int i = 0; i < files.size(); i++) {
					FreeBoardMemberImgVo img = new FreeBoardMemberImgVo();
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
		freeBoardService.freeBoardMemberInsert(freeBoardMemberVo, imgList);
		return "redirect:freeBoardMemberList";
	}

//	게시글 불러오기
	@GetMapping("freeBoardMemberView")
	public String freeBoardMemberView(@RequestParam(value = "fbm_num") int fbm_num, Model model) {
		Map<String, Object> map = freeBoardService.selectFreeMemberView(fbm_num);
		model.addAttribute("map", map);
		return "/freeBoardMember/freeBoardMemberView";
	}

//	게시판 삭제 ajax
	@PostMapping("freeBoardMemberDelete")
	@ResponseBody
	public void freeBoardMemberDelete(@RequestParam(value = "fbm_num") int fbm_num) {
		freeBoardService.freeBoardMemberDelete(fbm_num);
	}

//	게시글 수정페이지 오픈
	@GetMapping("freeBoardMemberModifyView")
	public String freeBoardMemberModifyView(@RequestParam(value = "fbm_num") int fbm_num, Model model) {
		Map<String, Object> map = freeBoardService.selectFreeBoardMemberModifyView(fbm_num);
		model.addAttribute("map", map);
		return "/freeBoardMember/freeBoardMemberModify";
	}

	// 게시글 수정

	@PostMapping("freeBoardMemberModify")
	public String freeBoardMemberModify(FreeBoardMemberVo freeBoardMemberVo, 
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		String[] uploadFileName = null;
		ArrayList<FreeBoardMemberImgVo> imgList = new ArrayList<FreeBoardMemberImgVo>();
		if (files != null) {
			for(int i=0; i<files.size(); i++) {
				FreeBoardMemberImgVo img = new FreeBoardMemberImgVo();
			if (files.get(i).getSize() != 0) {
				String fileUrl = "C:\\upload\\freeMember\\";
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
		freeBoardService.freeBoardMemberModify(freeBoardMemberVo, imgList);
		return "redirect:freeBoardMemberList";
	}

	// 게시글 댓글 쓰기 ajax

	@PostMapping("freeBoardMemberCommentWrite")
	@ResponseBody
	public Map<String, Object> freeBoardMemberCommentWrite(FreeBoardMemberCommentVo freeBoardCommentVo) {
		Map<String, Object> map = freeBoardService.freeBoardMemberCommentWrite(freeBoardCommentVo);
		System.out.println("실행");
		return map;
	}

	// 게시글 댓글 수정 ajax
	@PostMapping("freeBoardMemberCommentModify")
	@ResponseBody
	public Map<String, Object> freeBoardCommentModify(FreeBoardMemberCommentVo freeBoardMemberCommentVo) {
		Map<String, Object> map = freeBoardService.freeBoardMemberCommentModify(freeBoardMemberCommentVo);
		return map;
	}

	// 게시글 댓글 삭제 ajax

	@PostMapping("freeBoardMemberCommentDelete")
	@ResponseBody
	public int freeBoardCommentDelete(@RequestParam(value = "c_no") int c_no,
			@RequestParam(value = "fbm_num") int fbm_num) {
		int commentCount = freeBoardService.freeBoardMemberCommentDelete(c_no, fbm_num);
		return commentCount;
	}

//		자유 게시판 (판매자)=====================================================================================================================

//		게시판 페이지 오픈
	@GetMapping("freeBoardSellerList")
	public String openFreeBoardSellerList(@RequestParam(value = "searchCategory") @Nullable String searchCategory,
			@RequestParam(defaultValue = "") String sportsCategory, @RequestParam(defaultValue = "") String searchWord,
			@RequestParam(defaultValue = "1") int page, Model model) {
		Map<String, Object> map = freeBoardService.selectFreeSellerBoardList(searchCategory, sportsCategory, searchWord,
				page);
		System.out.println("===============================================================================");
		model.addAttribute("map", map);
		return "/freeBoardSeller/freeBoardSellerList";
	}

//		게시판 쓰기 오픈
	@GetMapping("freeBoardSellerWrite")
	public String openFreeBoardSellerWrtie() {
		return "/freeBoardSeller/freeBoardSellerWrite";
	}

//		게시판 쓰기 
	@PostMapping("freeBoardSellerWrite")
	public String freeBoardSellerInsert(FreeBoardSellerVo freeBoardSellerVo,
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		ArrayList<FreeBoardSellerImgVo> imgList = new ArrayList<FreeBoardSellerImgVo>();
		String[] uploadFileName = null;
		if (files != null) {
			if (files.get(0).getSize() != 0) {
				String fileUrl = "C:\\upload\\freeSeller\\";
				uploadFileName = new String[files.size()];

				for (int i = 0; i < files.size(); i++) {
					FreeBoardSellerImgVo img = new FreeBoardSellerImgVo();
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
		freeBoardService.freeBoardSellerInsert(freeBoardSellerVo, imgList);
		return "redirect:freeBoardSellerList";
	}

//		게시글 불러오기
	@GetMapping("freeBoardSellerView")
	public String freeBoardSellerView(@RequestParam(value = "fbs_num") int fbs_num, Model model) {
		Map<String, Object> map = freeBoardService.selectFreeSellerView(fbs_num);
		model.addAttribute("map", map);
		return "/freeBoardSeller/freeBoardSellerView";
	}
//	게시글 수정페이지 오픈
	@GetMapping("freeBoardSellerModifyView")
	public String freeBoardSellerModifyView(@RequestParam(value = "fbs_num") int fbs_num, Model model) {
		Map<String, Object> map = freeBoardService.selectFreeBoardSellerModifyView(fbs_num);
		model.addAttribute("map", map);
		return "/freeBoardSeller/freeBoardSellerModify";
	}

	@PostMapping("freeBoardSellerModify")
	public String freeBoardMemberModify(FreeBoardSellerVo freeBoardSellerVo, 
			@RequestParam("files") @Nullable List<MultipartFile> files) throws Exception {
		String[] uploadFileName = null;
		ArrayList<FreeBoardSellerImgVo> imgList = new ArrayList<FreeBoardSellerImgVo>();
		if (files != null) {
			for(int i=0; i<files.size(); i++) {
				FreeBoardSellerImgVo img = new FreeBoardSellerImgVo();
			if (files.get(i).getSize() != 0) {
				String fileUrl = "C:\\upload\\freeSeller\\";
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
		freeBoardService.freeBoardSellerModify(freeBoardSellerVo, imgList);
		return "redirect:freeBoardSellerList";
	}

//		게시판 삭제 ajax
	@PostMapping("freeBoardSellerDelete")
	@ResponseBody
	public void freeBoardSellerDelete(@RequestParam(value = "fbs_num") int fbs_num) {
		freeBoardService.freeBoardSellerDelete(fbs_num);
	}
	// 게시글 댓글 쓰기 ajax

	@PostMapping("freeBoardSellerCommentWrite")
	@ResponseBody
	public Map<String, Object> freeBoardSellerCommentWrite(FreeBoardSellerCommentVo freeBoardSellerCommentVo) {
		Map<String, Object> map = freeBoardService.freeBoardSellerCommentWrite(freeBoardSellerCommentVo);
		FreeBoardSellerCommentVo fmsCommentVo = (FreeBoardSellerCommentVo)map.get("fmsCommentVo");
		return map;
	}

	// 게시글 댓글 수정 ajax
	@PostMapping("freeBoardSellerCommentModify")
	@ResponseBody
	public Map<String, Object> freeBoardSellerCommentModify(FreeBoardSellerCommentVo freeBoardSellerCommentVo) {
		Map<String, Object> map = freeBoardService.freeBoardSellerCommentModify(freeBoardSellerCommentVo);
		return map;
	}
	// 게시글 댓글 삭제 ajax

	@PostMapping("freeBoardSellerCommentDelete")
	@ResponseBody
	public int freeBoardSellerCommentDelete(@RequestParam(value = "c_no") int c_no,
			@RequestParam(value = "fbs_num") int fbs_num) {
		int commentCount = freeBoardService.freeBoardSellerCommentDelete(c_no, fbs_num);
		return commentCount;
	}
}
