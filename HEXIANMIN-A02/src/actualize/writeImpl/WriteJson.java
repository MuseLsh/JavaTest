package actualize.writeImpl;



import actualize.DataHandler;
import actualize.OutputHandler;
import util.Constans;
import util.Tools;
import model.ZonesInfo;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class WriteJson implements OutputHandler{


	 public void outPutZonesInfo(DataHandler handler) {
		Tools.delExistedJson(Constans.JSONPATH);
		StringBuilder sb = new StringBuilder();
		sb.append("{").append("\n");
		fiveBlank(sb);
		sb.append(" “servers”:").append("[").append("\n");
		tenBlank(sb);
		//servers数据
		this.writeServer(handler,sb);
		sb.append("\n");
		tenBlank(sb);
		sb.append("]").append(",").append("\n");	
		sb.append("\n");
		fiveBlank(sb);
		sb.append(" “zones”:").append("[").append("\n");
		//zones数据
		tenBlank(sb);
		this.writeZones(handler,sb);
		sb.append("]").append("\n").append("}");	
		Tools.writeOS(Constans.JSONPATH,  sb);
		System.out.println("json文件生成成功!");
	}

	private void writeServer(DataHandler handler,StringBuilder sb) {
		for (int i = 1; i <= handler.serversCount; i++) {
			JSONObject serverJson = new JSONObject();
			String[] str = handler.getIpPortByIndex(i).split("/");
			try {
				serverJson.put("ip", str[0]);
				serverJson.put("port", str[1]);
				sb.append(serverJson.toString());
				if(i != handler.serversCount){
					sb.append(",").append("\n");
					tenBlank(sb);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void writeZones(DataHandler handler,StringBuilder sb) {
		for (ZonesInfo zoneInfo : handler.zonesListRemove$) {
			int num = 1;
			JSONObject zoneJson = new JSONObject();
			try {
				Integer index = handler.IpPortMap.get(zoneInfo.getZoneIp()
						+ Constans.TAG + zoneInfo.getZonePort());
				Integer capacity = zoneInfo.calCapacity(zoneInfo.getNowNum(),
						zoneInfo.getMaxNum());
				zoneJson.put("name", zoneInfo.getZoneName());
				zoneJson.put("serverIndex", index);
				zoneJson.put("capacity", capacity);
				sb.append(zoneJson.toString());
				num++;
				if( num != handler.zonesListRemove$.size()){
					sb.append(",").append("\n");
					tenBlank(sb);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void fiveBlank(StringBuilder sb) {
		for(int i = 0 ; i < 5;i++ ){
			sb.append(" ");
		}
	}
	
	private void tenBlank(StringBuilder sb) {
		for(int i = 0 ; i < 10;i++ ){
			sb.append(" ");
		}
	}

	protected void replaceIpDomain() {

	}

	@Override
	public void replaceIpDomain(DataHandler handler) {
		// TODO Auto-generated method stub
		
	}



}
