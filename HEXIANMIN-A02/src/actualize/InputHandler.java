package actualize;

import java.util.ArrayList;

import model.IpDomain;
import model.ZonesInfo;

public interface InputHandler {

	ArrayList<IpDomain> readIpDomain();
	
	ArrayList<ZonesInfo> readZonesInfo();
}
