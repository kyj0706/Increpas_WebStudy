package controller;

import java.io.IOException;
import java.text.ParseException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.ChartVo;
import vo.StockVo;

@Controller
public class ChartController {

	
	@RequestMapping("/StockChart1")
	public ModelAndView chart1() throws ParseException {
		
		
		ModelAndView mv1 = new ModelAndView();
		
		String URL = "https://finance.naver.com/item/frgn.naver?code=371460";
		Document doc;

		try {
			doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
		            .header("scheme", "https")
		            .header("accept", "application/json, text/plain, */*")
		            .header("accept-encoding", "gzip, deflate, br")
		            .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
		            .header("cache-control", "no-cache")
		            .header("pragma", "no-cache")
		            .header("upgrade-insecure-requests", "1")
		            .get();
			
			Elements datelist =doc.select(".tc .tah");
			System.out.println("첫번째"+datelist);
			
			String[] str1 = datelist.text().split(" ");
			
			int x = 0;
			String[] str3 = new String[str1.length];
			for(int i=str1.length-1; i>=0; i--) {
				 str3[x] = str1[i];
			}
			
			
			Elements siselist =doc.select(".num .tah.p11");
			System.out.println("첫번째1"+siselist);
			
			String[] str2 = siselist.text().split(" ");
			
			
			int cnt = 10;
			int num = 8;
			int j = 1;
			int k = 0;
			String[] sar = new String[str1.length];
			for(int i=cnt; i<str2.length; i++) {
				sar[k] = str2[i];
				
				i = cnt+(num*j)-1;
				
				k++;
				j++;
			
			}
			int[] rsar = new int[sar.length];
			for(int i = 0; i< sar.length; i++) {
				sar[i] = sar[i].replace(",", "");
				rsar[i] = Integer.parseInt(sar[i]);
			}
			ChartVo ar[] = new ChartVo[str1.length];
			int q = 0;
			for(int i=str1.length-1; i>=0; i--) {
				
				str1[i] = str1[i].replaceAll("2022.", "");
				ar[q] = new ChartVo(str1[i], rsar[i]);
				q++;
				
			}
			
			mv1.addObject("ar", ar);
			
			
			
			URL = "https://finance.naver.com/item/main.naver?code=371460";

			
			doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
		            .header("scheme", "https")
		            .header("accept", "application/json, text/plain, */*")
		            .header("accept-encoding", "gzip, deflate, br")
		            .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
		            .header("cache-control", "no-cache")
		            .header("pragma", "no-cache")
		            .header("upgrade-insecure-requests", "1")
		            .get();
			

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


			StockVo svo1 = new StockVo(name, NowPrice, vsyesterday, DungRakrate, 
					HighPrice, LowPrice, georaeryang, TradingValue, yesterdayPrice, sigaPrice);
		
			mv1.addObject("svo1", svo1);
			mv1.setViewName("StockChart1");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv1;
	}
	
	@RequestMapping("/StockChart3")
	public ModelAndView chart3() throws ParseException {
		
		
		ModelAndView mv3 = new ModelAndView();
		
		String URL = "https://finance.naver.com/item/main.naver?code=414270";
		Document doc;

		try {
			doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
		            .header("scheme", "https")
		            .header("accept", "application/json, text/plain, */*")
		            .header("accept-encoding", "gzip, deflate, br")
		            .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
		            .header("cache-control", "no-cache")
		            .header("pragma", "no-cache")
		            .header("upgrade-insecure-requests", "1")
		            .get();
			System.out.println(doc);
			
			
			Elements datelist =doc.select(".tc .tah");
			
			System.out.println(datelist);
			
			String[] str1 = datelist.text().split(" ");
			
			
			int x = 0;
			String[] str3 = new String[str1.length];
			for(int i=str1.length-1; i>=0; i--) {
				 str3[x] = str1[i];
			}
			
			
			Elements siselist =doc.select(".num .tah.p11");
			System.out.println(siselist);
			
			String[] str2 = siselist.text().split(" ");
			
			
			int cnt = 10;
			int num = 8;
			int j = 1;
			int k = 0;
			
			String[] sar = new String[str1.length];
			System.out.println("sar 길이 ="+sar.length);
			
			for(int i=cnt; i<str2.length; i++) {
				sar[k] = str2[i];
				
				i = cnt+(num*j)-1;
				
				k++;
				j++;
			
			}
			
			int[] rsar = new int[sar.length];
			for(int i = 0; i< sar.length; i++) {
				sar[i] = sar[i].replace(",", "");
				rsar[i] = Integer.parseInt(sar[i]);
			}
			
			ChartVo ar[] = new ChartVo[str1.length];
			int q = 0;
			for(int i=str1.length-1; i>=0; i--) {
				
				str1[i] = str1[i].replaceAll("2022.", "");
				ar[q] = new ChartVo(str1[i], rsar[i]);
				q++;
				
			}
			
			mv3.addObject("ar", ar);
			
			
			
			URL = "https://finance.naver.com/item/main.naver?code=414270";

			
			doc = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
		            .header("scheme", "https")
		            .header("accept", "application/json, text/plain, */*")
		            .header("accept-encoding", "gzip, deflate, br")
		            .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
		            .header("cache-control", "no-cache")
		            .header("pragma", "no-cache")
		            .header("upgrade-insecure-requests", "1")
		            .get();
			

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


			StockVo svo3 = new StockVo(name, NowPrice, vsyesterday, DungRakrate, 
					HighPrice, LowPrice, georaeryang, TradingValue, yesterdayPrice, sigaPrice);
		
			mv3.addObject("svo3", svo3);
			mv3.setViewName("StockChart3");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv3;
	}
	
	
}
