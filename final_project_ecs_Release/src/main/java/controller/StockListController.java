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

		
		//TIGER ���̳�������SOLACTIVE
		String URL_1 = "https://finance.naver.com/item/main.naver?code=371460";
		//TIGER �۷ι���������&������SOLACTIVE
		String URL_2 = "https://finance.naver.com/item/main.naver?code=394660";
		//ACE G2������&���������Ƽ��
		String URL_3 = "https://finance.naver.com/item/main.naver?code=414270";
		//SOL �ѱ����۷ι�������&2��������Ƽ��
		String URL_4 = "https://finance.naver.com/item/main.naver?code=429980";
		//TIGER ����������(�ռ�)
		String URL_5 = "https://finance.naver.com/item/main.naver?code=449680";
		//KODEX ����������(�ռ�)
		String URL_6 = "https://finance.naver.com/item/main.naver?code=450180";
		
		Document doc;

		try {
			//TIGER ���̳�������SOLACTIVE
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
			
			//TIGER ���̳�������SOLACTIVE
			//URL_2 = "https://finance.naver.com/item/main.naver?code=371460";

			
			
//======================================================================================================================================================			
			//TIGER �۷ι���������&������SOLACTIVE
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
			 * System.out.println("�����:"+name); System.out.println("���簡:"+NowPrice);
			 * System.out.println("���ϴ��:"+vsyesterday);
			 * System.out.println("�����:"+DungRakrate); System.out.println("��:"+HighPrice);
			 * System.out.println("����:"+LowPrice); System.out.println("�ŷ���:"+georaeryang);
			 * System.out.println("�ŷ����:"+TradingValue);
			 */
				
			//ACE G2������&���������Ƽ��
			//URL_3 = "https://finance.naver.com/item/main.naver?code=414270";

//======================================================================================================================================================
			//ACE G2������&���������Ƽ��
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
			//SOL �ѱ����۷ι�������&2��������Ƽ��
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
			//TIGER ����������(�ռ�)
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
