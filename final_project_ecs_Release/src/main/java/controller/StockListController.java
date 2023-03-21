package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.StockVo;

@Controller
@RequestMapping("/ev/")
public class StockListController {

	
	@RequestMapping("/evStock")
	public String list(String[] args, Model model) {

		
		//TIGER 차이나전기차SOLACTIVE
		String URL_1 = "https://finance.naver.com/item/main.naver?code=371460";
		//TIGER 글로벌자율주행&전기차SOLACTIVE
		String URL_2 = "https://finance.naver.com/item/main.naver?code=394660";
		//ACE G2전기차&자율주행액티브
		String URL_3 = "https://finance.naver.com/item/main.naver?code=414270";
		//SOL 한국형글로벌전기차&2차전지액티브
		String URL_4 = "https://finance.naver.com/item/main.naver?code=429980";
		//TIGER 한중전기차(합성)
		String URL_5 = "https://finance.naver.com/item/main.naver?code=449680";
		//KODEX 한중전기차(합성)
		String URL_6 = "https://finance.naver.com/item/main.naver?code=450180";
		
		Document doc;

		try {
			//TIGER 차이나전기차SOLACTIVE
			doc = Jsoup.connect(URL_1).userAgent(
					"Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
					.header("scheme", "https")
					.header("accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
					.header("cache-control", "no-cache").header("pragma", "no-cache")
					.header("upgrade-insecure-requests", "1").get();

			Elements elem = doc.select(".date");
			String[] str = elem.text().split(" ");

			Elements todaylist = doc.select(".new_totalinfo dl>dd");

			String name = todaylist.get(1).text().split(" ")[1]+ todaylist.get(1).text().split(" ")[2];
			String NowPrice = todaylist.get(3).text().split(" ")[1];
			String vsyesterday = todaylist.get(3).text().split(" ")[3] + todaylist.get(3).text().split(" ")[4];
			String DungRakrate = todaylist.get(3).text().split(" ")[5] + todaylist.get(3).text().split(" ")[6]
					+ todaylist.get(3).text().split(" ")[7];
			String yesterdayPrice = todaylist.get(4).text().split(" ")[1];
			String sigaPrice = todaylist.get(5).text().split(" ")[1];
			String HighPrice = todaylist.get(6).text().split(" ")[1];
			String LowPrice = todaylist.get(8).text().split(" ")[1];
			String georaeryang = todaylist.get(10).text().split(" ")[1];
			String TradingValue = todaylist.get(11).text().split(" ")[1];


			StockVo svo1 = new StockVo(name, NowPrice, vsyesterday, DungRakrate, yesterdayPrice, sigaPrice, HighPrice, LowPrice, georaeryang, TradingValue);
		
		
			model.addAttribute("svo1", svo1);
			
			//TIGER 차이나전기차SOLACTIVE
			//URL_2 = "https://finance.naver.com/item/main.naver?code=371460";

			
			
//======================================================================================================================================================			
			//TIGER 글로벌자율주행&전기차SOLACTIVE
				doc = Jsoup.connect(URL_2).userAgent(
						"Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
						.header("scheme", "https")
						.header("accept",
								"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
						.header("accept-encoding", "gzip, deflate, br")
						.header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
						.header("cache-control", "no-cache").header("pragma", "no-cache")
						.header("upgrade-insecure-requests", "1").get();

				elem = doc.select(".date");
				str = elem.text().split(" ");

				todaylist = doc.select(".new_totalinfo dl>dd");

				name = todaylist.get(1).text().split(" ")[1]+ todaylist.get(1).text().split(" ")[2];
				NowPrice = todaylist.get(3).text().split(" ")[1];
				vsyesterday = todaylist.get(3).text().split(" ")[3] + todaylist.get(3).text().split(" ")[4];
				DungRakrate = todaylist.get(3).text().split(" ")[5] + todaylist.get(3).text().split(" ")[6]
						+ todaylist.get(3).text().split(" ")[7];
				yesterdayPrice = todaylist.get(4).text().split(" ")[1];
				sigaPrice = todaylist.get(5).text().split(" ")[1];
				HighPrice = todaylist.get(6).text().split(" ")[1];
				LowPrice = todaylist.get(8).text().split(" ")[1];
				georaeryang = todaylist.get(10).text().split(" ")[1];
				TradingValue = todaylist.get(11).text().split(" ")[1];


				StockVo svo2 = new StockVo(name, NowPrice, vsyesterday, DungRakrate, yesterdayPrice, sigaPrice, HighPrice, LowPrice, georaeryang, TradingValue);
				model.addAttribute("svo2", svo2);
			/*
			 * System.out.println("종목명:"+name); System.out.println("현재가:"+NowPrice);
			 * System.out.println("전일대비:"+vsyesterday);
			 * System.out.println("등락율:"+DungRakrate); System.out.println("고가:"+HighPrice);
			 * System.out.println("저가:"+LowPrice); System.out.println("거래량:"+georaeryang);
			 * System.out.println("거래대금:"+TradingValue);
			 */
				
			//ACE G2전기차&자율주행액티브
			//URL_3 = "https://finance.naver.com/item/main.naver?code=414270";

//======================================================================================================================================================
			//ACE G2전기차&자율주행액티브
			doc = Jsoup.connect(URL_3).userAgent(
					"Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
					.header("scheme", "https")
					.header("accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
					.header("cache-control", "no-cache").header("pragma", "no-cache")
					.header("upgrade-insecure-requests", "1").get();

			elem = doc.select(".date");
			str = elem.text().split(" ");

			todaylist = doc.select(".new_totalinfo dl>dd");

			name = todaylist.get(1).text().split(" ")[1]+ todaylist.get(1).text().split(" ")[2];
			NowPrice = todaylist.get(3).text().split(" ")[1];
			vsyesterday = todaylist.get(3).text().split(" ")[3] + todaylist.get(3).text().split(" ")[4];
			DungRakrate = todaylist.get(3).text().split(" ")[5] + todaylist.get(3).text().split(" ")[6]
					+ todaylist.get(3).text().split(" ")[7];
			yesterdayPrice = todaylist.get(4).text().split(" ")[1];
			sigaPrice = todaylist.get(5).text().split(" ")[1];
			HighPrice = todaylist.get(6).text().split(" ")[1];
			LowPrice = todaylist.get(8).text().split(" ")[1];
			georaeryang = todaylist.get(10).text().split(" ")[1];
			TradingValue = todaylist.get(11).text().split(" ")[1];


			StockVo svo3 = new StockVo(name, NowPrice, vsyesterday, DungRakrate, yesterdayPrice, sigaPrice, HighPrice, LowPrice, georaeryang, TradingValue);
			model.addAttribute("svo3", svo3);	
			
//======================================================================================================================================================			
			//SOL 한국형글로벌전기차&2차전지액티브
			doc = Jsoup.connect(URL_4).userAgent(
					"Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
					.header("scheme", "https")
					.header("accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
					.header("cache-control", "no-cache").header("pragma", "no-cache")
					.header("upgrade-insecure-requests", "1").get();
			
			elem = doc.select(".date");
			str = elem.text().split(" ");
			
			todaylist = doc.select(".new_totalinfo dl>dd");
			
			name = todaylist.get(1).text().split(" ")[1]+ todaylist.get(1).text().split(" ")[2];
			NowPrice = todaylist.get(3).text().split(" ")[1];
			vsyesterday = todaylist.get(3).text().split(" ")[3] + todaylist.get(3).text().split(" ")[4];
			DungRakrate = todaylist.get(3).text().split(" ")[5] + todaylist.get(3).text().split(" ")[6]
					+ todaylist.get(3).text().split(" ")[7];
			yesterdayPrice = todaylist.get(4).text().split(" ")[1];
			sigaPrice = todaylist.get(5).text().split(" ")[1];
			HighPrice = todaylist.get(6).text().split(" ")[1];
			LowPrice = todaylist.get(8).text().split(" ")[1];
			georaeryang = todaylist.get(10).text().split(" ")[1];
			TradingValue = todaylist.get(11).text().split(" ")[1];
			
			
			StockVo svo4 = new StockVo(name, NowPrice, vsyesterday, DungRakrate, yesterdayPrice, sigaPrice, HighPrice, LowPrice, georaeryang, TradingValue);
			model.addAttribute("svo4", svo4);	
			
//======================================================================================================================================================			
			//TIGER 한중전기차(합성)
			doc = Jsoup.connect(URL_5).userAgent(
					"Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
					.header("scheme", "https")
					.header("accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
					.header("cache-control", "no-cache").header("pragma", "no-cache")
					.header("upgrade-insecure-requests", "1").get();
			
			elem = doc.select(".date");
			str = elem.text().split(" ");
			
			todaylist = doc.select(".new_totalinfo dl>dd");
			
			name = todaylist.get(1).text().split(" ")[1]+ todaylist.get(1).text().split(" ")[2];
			NowPrice = todaylist.get(3).text().split(" ")[1];
			vsyesterday = todaylist.get(3).text().split(" ")[3] + todaylist.get(3).text().split(" ")[4];
			DungRakrate = todaylist.get(3).text().split(" ")[5] + todaylist.get(3).text().split(" ")[6]
					+ todaylist.get(3).text().split(" ")[7];
			yesterdayPrice = todaylist.get(4).text().split(" ")[1];
			sigaPrice = todaylist.get(5).text().split(" ")[1];
			HighPrice = todaylist.get(6).text().split(" ")[1];
			LowPrice = todaylist.get(8).text().split(" ")[1];
			georaeryang = todaylist.get(10).text().split(" ")[1];
			TradingValue = todaylist.get(11).text().split(" ")[1];
			
			
			StockVo svo5 = new StockVo(name, NowPrice, vsyesterday, DungRakrate, yesterdayPrice, sigaPrice, HighPrice, LowPrice, georaeryang, TradingValue);
			model.addAttribute("svo5", svo5);	
			
//======================================================================================================================================================			
				
				
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "evStockList";
		}
	}
