package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import vo.LocalVo;

public class KakaoSearchUtils {

	public static List<LocalVo>  getLocalListFromJson(
										String  keyword,      //�˻���
										double latitude,      //����
										double longitude,     //�浵
										int radius,
										int page,
										int size) throws Exception{
		List<LocalVo> list = new ArrayList<LocalVo>();
		
		//        3ebe1c7e586491e37bc04090f8d133b0
		//String  kakaoAK = "KakaoAK 3ebe1c7e586491e37bc04090f8d133b0";
		keyword = URLEncoder.encode(keyword, "utf-8");
		String  kakaoAK = MyOpenAPIKey.Kakao.KAKAOAK;
		String urlStr = String.format("https://dapi.kakao.com/v2/local/search/keyword.json?sort=distance&query=%s&x=%f&y=%f&radius=%d&page=%d&size=%d",
				keyword,longitude,latitude,radius,page,size
			);
	
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		//�߱޹��� key
		connection.setRequestProperty("Authorization", kakaoAK); 
		connection.setRequestProperty("Content-Type", "application/plain"); 
		connection.connect();
		
		InputStreamReader isr = new InputStreamReader(connection.getInputStream(),"utf-8");
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			String readData = br.readLine();
			if(readData==null)break;
			sb.append(readData);
		}
		
		 
		JSONObject json = new JSONObject(sb.toString());
		
		//�˻��������
		JSONObject meta = json.getJSONObject("meta");
		int pageable_count = meta.getInt("pageable_count");
		
		//�˻����
		JSONArray local_array = json.getJSONArray("documents");
		for(int i=0;i<local_array.length();i++) {
			
			JSONObject local = local_array.getJSONObject(i);
			LocalVo vo = new LocalVo();
			vo.setPlace_name(local.getString("place_name"));
			vo.setPlace_url(local.getString("place_url"));
			vo.setAddress(local.getString("address_name"));
			vo.setRoad_address(local.getString("road_address_name"));
			vo.setCategory_group_name(local.getString("category_group_name"));
			vo.setCategory_name(local.getString("category_name"));
			vo.setPhone(local.getString("phone"));
			
			int distance=0;
			double local_longitude=0;
			double local_latitude=0;
			
			try {
				local_longitude = Double.parseDouble(local.getString("x"));
				vo.setLongitude(local_longitude);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
				local_latitude = Double.parseDouble(local.getString("y"));
				vo.setLatitude(local_latitude);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				distance = Integer.parseInt(local.getString("distance"));
				vo.setDistance(distance);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			list.add(vo);
			
		}
		
		//�Ÿ���(����� ������ ����)
		//Collections.sort(list, new LocalVoComp());
		
		
		
		return list;
	}
	
	
//------------------------------------------------------------------------------------	
	public static List<LocalVo>  getLocalListFromXml(
			String  keyword,      //�˻���
			double latitude,      //����
			double longitude,     //�浵
			int radius,
			int page,
			int size) throws Exception{
		
		List<LocalVo> list = new ArrayList<LocalVo>();
		//        3ebe1c7e586491e37bc04090f8d133b0
		//String  kakaoAK = "KakaoAK 3ebe1c7e586491e37bc04090f8d133b0";
		keyword = URLEncoder.encode(keyword, "utf-8");
		String  kakaoAK = MyOpenAPIKey.Kakao.KAKAOAK;
		String urlStr = String.format("https://dapi.kakao.com/v2/local/search/keyword.xml?sort=distance&query=%s&x=%f&y=%f&radius=%d&page=%d&size=%d",
										keyword,longitude,latitude,radius,page,size
		);
		
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		//�߱޹��� key
		connection.setRequestProperty("Authorization", kakaoAK); 
		connection.setRequestProperty("Content-Type", "application/plain"); 
		connection.connect();
		
		SAXBuilder sb = new SAXBuilder();
		
		Document doc = sb.build(connection.getInputStream());
		Element root = doc.getRootElement();// <result>
		
		//�˻���� ����
		Element meta = root.getChild("meta");
		
		//�˻�����Ʈ
		List<Element> localList = root.getChildren("documents");
		for(Element local : localList) {
			LocalVo vo = new LocalVo();
			
			vo.setPlace_name(local.getChildText("place_name"));
			vo.setPlace_url(local.getChildText("place_url"));
			vo.setCategory_group_name(local.getChildText("category_group_name"));
			vo.setCategory_name(local.getChildText("category_name"));
			vo.setAddress(local.getChildText("address_name"));
			vo.setRoad_address(local.getChildText("road_address_name"));
			vo.setPhone(local.getChildText("phone"));
			
			int distance=0;
			double local_longitude=0;
			double local_latitude=0;
			
			try {
				local_longitude = Double.parseDouble(local.getChildText("x"));
				vo.setLongitude(local_longitude);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
				local_latitude = Double.parseDouble(local.getChildText("y"));
				vo.setLatitude(local_latitude);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				distance = Integer.parseInt(local.getChildText("distance"));
				vo.setDistance(distance);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			list.add(vo);
		}
		
		//�Ÿ���(����� ������ ����)
		//Collections.sort(list, new LocalVoComp());
		
		return list;
	}
	
	
	//ArrayList ���ı��� ��ü
	static class LocalVoComp implements Comparator<LocalVo>{

		public int compare(LocalVo lhs, LocalVo rhs) {
			// TODO Auto-generated method stub
			int ret=0;
			if(lhs.getDistance()>rhs.getDistance())ret=1;
			else if(lhs.getDistance()<rhs.getDistance())ret=-1;

			return ret;
		}
	}
	
}
