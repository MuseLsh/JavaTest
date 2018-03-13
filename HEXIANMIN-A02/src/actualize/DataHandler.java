package actualize;

import java.util.ArrayList;
import java.util.HashMap;

import util.Constans;
import model.IpDomain;
import model.ZonesInfo;
import factory.read.ReadFactory;

public class DataHandler {

	//protected OutPutZonesInfo handler = null;

	public ArrayList<ZonesInfo> ZonesInfoList = new ArrayList<ZonesInfo>();
	public HashMap<String, Integer> IpPortMap = new HashMap<String, Integer>();
	public ArrayList<ZonesInfo> zonesListRemove$ = new ArrayList<ZonesInfo>();
	public ArrayList<IpDomain> ipDomainList = new ArrayList<IpDomain>();
	public int serversCount;

	public DataHandler() {}

	/**
	 * 
	 * @param infoFrom
	 *            数据来源 ——txt:从txt文件读取数据,mysql:从数据库读取数据
	 *
	 */
	public DataHandler(String infoFrom) {		
		InputHandler readHandler = ReadFactory.creatRead(infoFrom);
		this.ZonesInfoList = readHandler.readZonesInfo();
		this.ipDomainList = readHandler.readIpDomain();
		this.initOnlyIpPortToMap();
		this.initZoneCount();
		
		
	}

	
	public void initZoneCount() {
		for (ZonesInfo zoneInfo : ZonesInfoList) {
			if (zoneInfo.getZoneName().startsWith("$")) {
				continue;
			}
			zonesListRemove$.add(zoneInfo);
		}
	}

	public void initOnlyIpPortToMap() {
		ArrayList<String> tempList = new ArrayList<String>();
		int index = 1;
		for (ZonesInfo zoneInfo : ZonesInfoList) {
			String tempStr = zoneInfo.getZoneIp() + Constans.TAG
					+ zoneInfo.getZonePort();
			if (tempList.contains(tempStr)) {
				continue;
			} else {
				IpPortMap.put(tempStr, index);
				tempList.add(tempStr);
				index++;
			}
		}
		serversCount = tempList.size();
	}

	public String getIpPortByIndex(int index) {
		for (String key : IpPortMap.keySet()) {
			if (IpPortMap.get(key) == index) {
				return key;
			}
		}
		return null;
	}


	public String getIpByServerNode(String str) {
		return str.split("/")[0];
	}

}
