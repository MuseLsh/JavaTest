package factory.read;

import util.Constans;
import actualize.InputHandler;
import actualize.readImpl.ReadZonesInfoInMySQL;
import actualize.readImpl.ReadZonesInfoInTxt;

public abstract class ReadFactory {

	public static InputHandler creatRead(String format) {
		switch (format.toUpperCase()) {
		case Constans.FROMTXT:
			System.out.println("数据来源于TXT文件!");
			return new ReadZonesInfoInTxt();
		case Constans.FROMMYSQL:
			System.out.println("数据来源于MYSQLS数据库!");
			return new ReadZonesInfoInMySQL();

		default:
			System.out.println("参数有误,请检查后重新输入!");
			break;
		}
		return null;
	}
	
	public abstract InputHandler create(); 
}
