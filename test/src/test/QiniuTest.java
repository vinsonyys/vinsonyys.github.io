package test;


import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;


public class QiniuTest {
	public static void main(String[] args) {
		String upToken = "GdjR-Mgy52aMuos3RX3nfwrnbu1niAcSCs4tFIsO:O8tqNiFj4oUAWPysh3W3MeVJ0zo=:eyJzY29wZSI6ImtjMDAxIiwiZGVhZGxpbmUiOjE0OTM2OTYyMjF9";

		String localFilePath = "/Users/vinsonyys/coder/qiniu_test.jpg";
		Zone zone = Zone.autoZone();
		Configuration cfg = new Configuration(zone);
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		try {
			//File file = new java.io.File(localFilePath);
			
			com.qiniu.http.Response response = uploadManager.put(localFilePath, null, upToken);
			
			//解析上传成功的结果
		    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		    System.out.println(putRet.key);
		    System.out.println(putRet.hash);
		    System.out.println(response.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		   
		
	}

}
