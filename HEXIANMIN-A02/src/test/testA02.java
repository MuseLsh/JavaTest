package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class testA02 {

	/**
	 *            
	 *txt源数据以及生成的xml文件和json文件均位于项目根目录,执行后refresh即可
	 *数据库备份文件位于/sql
	 */
	public static void main(String[] args) {
		// 数据来源 ——txt:从txt文件读取数据,mysql:从数据库读取数据
		//DataHandler data = new DataHandler("MYSQL");
		// 数据输出格式——xml：以xml形式输出数据 json：以json格式输出数据 
		//OutputHandler handler = WriteFactory.creatWrite("xml");
		//OutputHandler handler = xml.create();
		//handler.outPutZonesInfo(data);
		//域名替换IP
		//handler.replaceIpDomain(data);
		
		ArrayList<String> test = null;
		System.out.println(Optional.ofNullable(test).orElse(new ArrayList<String>()));
		
		String memberValaue = String.format("%s#%s", 1,"test");
		System.out.println(memberValaue);
	}
	


	
	
}
