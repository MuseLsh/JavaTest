package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class Tools {

	public static void delExistedXml(String url) {
		String path = url;
		File file = new File(path);
		if (file.exists()) {
			file.delete();
			System.out.println("旧xml文件删除成功");
		}
	}
	
	public static void delExistedJson(String url) {
		String path = url;
		File file = new File(path);
		if (file.exists()) {
			file.delete();
			System.out.println("旧json文件删除成功");
		}
	}
	
	public static void writeOS(String path, StringBuilder strJson){
		
		File file = new File(path);
		try {
			Writer write = new FileWriter(file);
			write.write(strJson.toString());
			write.flush();
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
