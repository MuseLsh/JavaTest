package actualize.readImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import actualize.InputHandler;
import model.IpDomain;
import model.ZonesInfo;

public class ReadZonesInfoInTxt implements InputHandler {

	BufferedReader brZoneInfo;
	BufferedReader brIpDomain;

	String path = "ZoneInfo.txt";
	String path2 = "IpDomain.txt";

	public ArrayList<IpDomain> readIpDomain() {
		ArrayList<IpDomain> tempList = new ArrayList<IpDomain>();
		String zoneMsg = null;
		try {
			brIpDomain = new BufferedReader(new InputStreamReader(
					new FileInputStream(path2), "utf-8"));
			while ((zoneMsg = brIpDomain.readLine()) != null) {

				String[] temp = zoneMsg.split("\t");
				IpDomain ipDomain = new IpDomain(temp[0], temp[1],
						Integer.parseInt(temp[2]));
				tempList.add(ipDomain);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				brIpDomain.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tempList;
	}

	public ArrayList<ZonesInfo> readZonesInfo() {
		ArrayList<ZonesInfo> tempList = new ArrayList<ZonesInfo>();
		String zoneMsg = null;
		try {
			brZoneInfo = new BufferedReader(new InputStreamReader(
					new FileInputStream(path), "utf-8"));
			while ((zoneMsg = brZoneInfo.readLine()) != null) {

				String[] temp = zoneMsg.split("\t");
				ZonesInfo zoneInfo = new ZonesInfo(temp[0], temp[1], temp[2],
						Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
				tempList.add(zoneInfo);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				brZoneInfo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tempList;
	}

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<IpDomain> zoneInfo = new ReadZonesInfoInTxt().readIpDomain();
		System.out.println(zoneInfo.get(0).getDomain());
	}

}
