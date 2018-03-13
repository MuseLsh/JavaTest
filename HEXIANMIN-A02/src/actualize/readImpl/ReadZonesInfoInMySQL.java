package actualize.readImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import actualize.InputHandler;
import util.Constans;
import util.DBHelper;
import model.IpDomain;
import model.ZonesInfo;

public class ReadZonesInfoInMySQL implements InputHandler {

	public ArrayList<IpDomain> readIpDomain() {
		DBHelper dbHelper = new DBHelper(Constans.SQLIPDOMAIN);
		ArrayList<IpDomain> tempList = new ArrayList<IpDomain>();
		try {
			ResultSet result = dbHelper.pst.executeQuery();
			while (result.next()) {
				IpDomain ipDomain = new IpDomain(result.getString("ip"),
						result.getString("domain"), Integer.parseInt(result
								.getString("tag")));
				tempList.add(ipDomain);
			}
			result.close();
			dbHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}

	public ArrayList<ZonesInfo> readZonesInfo() {
		ArrayList<ZonesInfo> tempList = new ArrayList<ZonesInfo>();
		DBHelper dbHelper = new DBHelper(Constans.SQLZONESINFO);
		try {
			ResultSet result = dbHelper.pst.executeQuery();
			while (result.next()) {
				ZonesInfo zonesInfo = new ZonesInfo(result.getString("zonename"),
						result.getString("zoneip"), result.getString("zoneport"),
						Integer.parseInt(result.getString("nownum")),
						Integer.parseInt(result.getString("maxnum")));
				tempList.add(zonesInfo);
			}
			result.close();
			dbHelper.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}

}
