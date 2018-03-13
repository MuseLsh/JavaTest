package model;

import java.math.BigDecimal;

public class ZonesInfo {
	
	private String zoneName;
	private String zoneIp;
	private String zonePort;
	private Integer nowNum;
	private Integer maxNum;
	
	
	
	public ZonesInfo(String zoneName, String zoneIp, String zonePort,
			Integer nowNum, Integer maxNum) {
		this.zoneName = zoneName;
		this.zoneIp = zoneIp;
		this.zonePort = zonePort;
		this.nowNum = nowNum;
		this.maxNum = maxNum;
	}
	
	public ZonesInfo(){}
	
	public String getZoneName() {
		return zoneName;
	}
	
	public String getZoneIp() {
		return zoneIp;
	}
	
	public String getZonePort() {
		return zonePort;
	}
	
	public int getNowNum() {
		return nowNum;
	}
	
	public int getMaxNum() {
		return maxNum;
	}
	
	
	public int calCapacity(float num, float maxNum) {
		BigDecimal bd = new BigDecimal(num / maxNum);
		float result = bd.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();

		if (result >= 0 && result < 0.1) {
			return 1;
		} else if (result >= 0.1 && result < 0.3) {
			return 2;
		} else if (result >= 0.3 && result < 0.4) {
			return 3;
		} else if (result >= 0.4 && result < 0.5) {
			return 4;
		} else if (result >= 0.5 && result < 0.7) {
			return 5;
		} else if (result >= 0.7 && result < 0.8) {
			return 6;
		} else if (result >= 0.8) {
			return 7;
		}
		return -1;
	}

}
