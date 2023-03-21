package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import vo.ChargingVo;


public class ElecCarUtil {

	public static List<ChargingVo> getElecCarPosition(ChargingVo vo ,int pageNo, int zscode) {
	
		List<ChargingVo> list = new ArrayList<ChargingVo>(); 
		String serviceKey  = MyOpenAPIKey.Charging.serviceKey;
		String urlStr = String.format("http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?serviceKey=%s&numOfRows=1&pageNo=%d&dataType=JSON&zscode=%d",
				serviceKey, pageNo, zscode);
		
		
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream(),"utf-8");
			BufferedReader br     = new BufferedReader(isr);
			StringBuffer sb       =  new StringBuffer();
			
			while(true) {
				String readData = br.readLine();
				if(readData==null)break;
				sb.append(readData);
			}
			JSONObject json = new JSONObject(sb.toString());
			
			
			//검색목록
			JSONArray item_array = json.getJSONObject("items").getJSONArray("item");
			for(int i=0;i<item_array.length();i++) {
				
				JSONObject item = item_array.getJSONObject(i);
				
				String statNm      = item.getString("statNm");
				String addr        = item.getString("addr");
				String location    = item.getString("location");
				String useTime     = item.getString("useTime");
				String stat        = item.getString("stat");
				String chgerType   = item.getString("chgerType");
				String output      = item.getString("output");
				String method      = item.getString("method");
				String parkingFree = item.getString("parkingFree");
				String note        = item.getString("note");
				String lat         = item.getString("lat");
				String lng         = item.getString("lng");
				
				vo = new ChargingVo();
				
				vo.setStatNm(statNm);
				vo.setAddr(addr);
				vo.setLocation(location);
				vo.setUseTime(useTime);
				vo.setStat(stat);
				vo.setChgerType(chgerType);
				vo.setOutput(output);
				vo.setMethod(method);
				vo.setParkingFree(parkingFree);
				vo.setNote(note);
				vo.setLat(lat) ;
				vo.setLng(lng);
				
				list.add(vo);
				
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//거리순(가까운 순서로 정렬)
		//Collections.sort(list, new LocalVoComp());
		
		return list;

	}

}
