package test;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		//
		// // Date date = new Date("2015-10-26 13:07:52");
		//
		// try {
		// System.out.println(dateFormat.format((dateFormat.parse("2015-10-26 13:07:52"))));
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
				"星期六" };
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); // yyyy-MM-dd'T'HH:mm:ss.SSS
		Date date1 = dateFormat1.parse("2017-05-01T00:00:00+08:00");
		Date date2 = dateFormat.parse("2017-05-16 22:00:00");
		System.out.println(isBetweenInTwoTimes(date1, date2, new Date()));
		
		Map<String, Integer> productAmountMap = new HashMap<String, Integer>();
		productAmountMap.put("aaasdfddd", 1);
		System.out.println(JSON.toJSON(productAmountMap));
		
		getHourAndMinuteTime(date2);
		
		// System.out.println(date2);
		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(date2);
		// int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		// System.out.println(weekDaysName[week]);

		// //Date date1 = dateFormat.format(new Date());
		// Calendar calendar1 = Calendar.getInstance();
		// calendar1.setTime(new Date());
		// int week1 = calendar1.get(Calendar.DAY_OF_WEEK)-1;
		// System.out.println(weekDaysName[week1]);
		// String year = String.format("%tY", date);
		// String month = String.format("%tB", date);
		// String day = String.format("%te",date);
		// System.out.println("今天是："+year+"-"+month+"-"+day);
		//
		// System.out.println(calendar.getTimeInMillis());
		//
		// System.out.println(System.currentTimeMillis());

		// List<Paramter> paramters = new ArrayList<Paramter>();
		// Paramter paramter = new Paramter();
		// paramter.setName("Id");
		// paramter.setValue("11111");
		//
		// Paramter paramter1 = new Paramter();
		// paramter1.setName("Name");
		// paramter1.setValue("yys");
		// paramters.add(paramter);
		// paramters.add(paramter1);
		// System.out.println(new Gson().toJson(paramters));
		System.out.println(getHourAndMinuteTime(date2));
		
		
		//System.out.println(getQueryParams("http://www.baidu.com?aaa=11111&bbbb=222222"));
		 Map<String,String> params = getQueryParams("http://www.baidu.com?aaa=11111&bbbb=222222");
			for (String key:params.keySet()) {
				if(key.equals("aaa")){
					System.out.println("1234567890-");
				}
			}
	}	

	public static String getDifferentTime(Date startDate, Date endDate) {
		String differentDay;
		String differentHour;
		String differentMin;
		String differentSec;
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diff;
		if (startTime > endTime) {
			diff = startTime - endTime;
		} else {
			diff = endTime - startTime;
		}
		long day = diff / (24 * 60 * 60 * 1000);

		long hour = (diff / (60 * 60 * 1000) - day * 24);
		long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		if (day < 10) {
			differentDay = "0" + day;
		} else {
			differentDay = String.valueOf(day);
		}
		if (hour < 10) {
			differentHour = "0" + hour;
		} else {
			differentHour = String.valueOf(hour);
		}
		if (min < 10) {
			differentMin = "0" + min;
		} else {
			differentMin = String.valueOf(min);
		}
		if (sec < 10) {
			differentSec = "0" + sec;
		} else {
			differentSec = String.valueOf(sec);
		}
		if (day == 0) {
			return differentHour + ":" + differentMin + ":" + differentSec;
		} else {
			return differentDay + ":" + differentHour + ":" + differentMin
					+ ":" + differentSec;
		}
	}

	public static int getDifferentTime(Date startDate, Date endDate, Date date) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long currentTime = date.getTime();
		if (startTime < endTime) {
			return (int) (100 * (currentTime - startTime) / (endTime - startTime));
		} else {
			return (int) ((currentTime - endTime) / (startTime - endTime));
		}
	}

	
	
	
	public static Map<String,String> getQueryParams(String url) {  
		Map<String,String> params = new HashMap<String,String>();
        String[] urlParams = url.split("\\?");  
        if (urlParams.length > 1) {  
            for (String param : urlParams[1].split("&")) {  
                String[] pair = param.split("=");  
                String key = pair[0]; 
                String value = pair[1];
                params.put(key, value);
            }  
        }  
        return params;  
	}  
	
	
	
//	public static String getHourAndMinuteTime(Date date) {
//		if (date != null) {
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(date);
//			return calendar.get(Calendar.HOUR) + ":"
//					+ calendar.get(Calendar.MINUTE);
//		}
//		return null;
//	}

	public static boolean isBetweenInTwoTimes(Date startDate, Date endDate,
			Date date) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long currentTime = date.getTime();
		if (startTime < currentTime && currentTime < endTime) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getHourAndMinuteTime(Date date) {
		if (date != null ) {
			String hourStr;
			String minStr;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int hour =  calendar.get(Calendar.HOUR_OF_DAY);
			int min  = calendar.get(Calendar.MINUTE);
			if (hour < 10) {
				hourStr = "0" + hour;
			} else {
				hourStr = String.valueOf(hour);
			}
			if (min < 10) {
				minStr = "0" + min;
			} else {
				minStr = String.valueOf(min);
			}
			return hourStr+":"+minStr;
		}
		return null;
	}
}

class Paramter {
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
