package factory.write;

import util.Constans;
import actualize.OutputHandler;
import actualize.writeImpl.WriteJson;
import actualize.writeImpl.WriteXml;

public abstract class  WriteFactory {
	


	public static OutputHandler creatWrite(String format) {
		switch (format.toUpperCase()) {
		case Constans.FORMATXML:
			return new WriteXml();
		case Constans.FORMATJSON:
			return new WriteJson();

		default:
			System.out.println("参数有误,请检查后重新输入!");
			break;
		}
		return null;
	}
	
	public abstract OutputHandler create(); 
}
