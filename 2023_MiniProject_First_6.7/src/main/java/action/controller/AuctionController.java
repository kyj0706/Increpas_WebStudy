package action.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import annotation.RequestMapping;

public class AuctionController {
	
	@RequestMapping("auction/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "auction_list.jsp";
	}

		

}
