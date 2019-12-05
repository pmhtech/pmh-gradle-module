package com.afreeca.connector;

import com.afreeca.domain.Afreeca;
import com.afreeca.domain.AfreecaResultSet;
import com.google.gson.Gson;
import net.pmhtech.connector.AbstractConnector;
import net.pmhtech.monitor.domain.LogMaster;
import net.pmhtech.util.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;

public class AfreecaConnector implements AbstractConnector {

    public URL getURL(String keyword) {

        String callback="callBackFunc"; //JsonP callback
        String m ="liveSearch"; //검색카테고리 (실시간);
        String v="1.0"; // 아프리카 API 버
        String szType="json"; //결과값 데이터 타입
        String szOrder = ""; //정렬순서
        String nPageNo = "1"; //결과값 페이지 인덱
        String nListCnt ="200"; //페이징사이즈
        String szKeyword= keyword; //검색어
        String onlyParent = "1"; //무슨뜻인지모름
        URL url = null;


        StringBuilder urlBuilder = new StringBuilder("http://sch.afreecatv.com/api.php");
        try {
            urlBuilder.append("?" + URLEncoder.encode("callback","UTF-8") + "="+URLEncoder.encode(callback,"UTF-8"));

            urlBuilder.append("&" + URLEncoder.encode("m","UTF-8") + "="+URLEncoder.encode(m,"UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("v","UTF-8") + "="+URLEncoder.encode(v,"UTF-8")); //JSONP callback
            urlBuilder.append("&" + URLEncoder.encode("szType","UTF-8") + "="+URLEncoder.encode(szType,"UTF-8")); //JSONP callback
            urlBuilder.append("&" + URLEncoder.encode("szOrder","UTF-8") + "="+URLEncoder.encode(szOrder,"UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("nPageNo","UTF-8") + "="+URLEncoder.encode(nPageNo,"UTF-8")); //JSONP callback
            urlBuilder.append("&" + URLEncoder.encode("nListCnt","UTF-8") + "="+URLEncoder.encode(nListCnt,"UTF-8")); //JSONP callback
            urlBuilder.append("&" + URLEncoder.encode("szKeyword","UTF-8") + "="+URLEncoder.encode(szKeyword,"UTF-8")); //JSONP callback
            urlBuilder.append("&" + URLEncoder.encode("onlyParent","UTF-8") + "="+URLEncoder.encode(onlyParent,"UTF-8")); //JSONP callback
            urlBuilder.append("&" + "_="+"1499437202662"); //JSONP callback


            //http://sch.afreecatv.com/api.php?callback=callBackFunc&m=liveSearch&v=1.0&szType=json&szOrder=&nPageNo=1&nListCnt=50&szKeyword=%EC%8A%A4%ED%83%80&onlyParent=1&_=1499437202662


            url = new URL(urlBuilder.toString());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return url;
    }



    @Override
    public List<?> getData() {

        String keyword="";
        URL url = this.getURL(keyword);
        BufferedReader rd  = null;
        HttpURLConnection conn =null;
        StringBuilder sb = new StringBuilder();
        List<LogMaster> returnList= new ArrayList<>();

        try{
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");

            System.out.println("Response code: " + conn.getResponseCode());
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
            }
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

            String jsonStr = sb.substring(13,sb.length()-1);

            AfreecaResultSet afreecaResultSet = JsonUtil.toPojo(jsonStr, AfreecaResultSet.class);


            Afreeca[] realBroads = afreecaResultSet.getREAL_BROAD();
            SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            Calendar cal = Calendar.getInstance();
            String logTime = formatter.format(cal.getTime());
            for(int i=0;i<realBroads.length;i++){

                Afreeca temp = realBroads[i];
                String platformType ="1";
                String platformUserId=temp.getUser_id();
                String title=temp.getBroad_title();
                String snapshotPath =temp.getSn_url();
                String viewCount=temp.getTotal_view_cnt();

                LogMaster logMaster = new LogMaster(logTime,platformType,platformUserId,title,snapshotPath,viewCount);

                returnList.add(logMaster);
            }
            //중계방 또는 도방




        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                rd.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn.disconnect();
        }

        return returnList;
    }
}
