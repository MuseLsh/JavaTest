package actualize.writeImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import model.IpDomain;
import model.ZonesInfo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import actualize.DataHandler;
import actualize.OutputHandler;
import util.Constans;
import util.Tools;

public class WriteXml implements OutputHandler {

	public void outPutZonesInfo(DataHandler handler) {
		// 删除旧的XML文件
		Tools.delExistedXml(Constans.XMLPATH);
		Document document = DocumentHelper.createDocument();
		// 创建根节点root
		Element root = document.addElement("root");
		// 创建二级节点servers
		Element servers = root.addElement("servers");

		for (int i = 1; i <= handler.serversCount; i++) {
			Element server = servers.addElement("server");
			server.setText(handler.getIpPortByIndex(i));
			// serverList.add(server);
		}

		// 创建二级节点zones
		Element zones = root.addElement("zones");
		for (ZonesInfo zoneInfo : handler.zonesListRemove$) {
			Element zone = zones.addElement("zone");
			zone.addAttribute("name", zoneInfo.getZoneName());
			Integer index = handler.IpPortMap.get(zoneInfo.getZoneIp()
					+ Constans.TAG + zoneInfo.getZonePort());
			zone.addAttribute("serverIndex", index.toString());
			Integer capacity = zoneInfo.calCapacity(zoneInfo.getNowNum(),
					zoneInfo.getMaxNum());
			zone.addAttribute("capacity", capacity.toString());
			// zoneList.add(zone);
		}

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		try {
			XMLWriter output = new XMLWriter(new FileOutputStream(
					"HEXIANMIN-A02.xml"), format); //
			output.write(document);
			System.out.println("生成XML文件成功");
			output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// IP替换域名
    public void replaceIpDomain(DataHandler handler) {
		// 创建SAXReader对象
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			// 读取文件 转换成Document
			document = reader.read(new File("HEXIANMIN-A02.xml"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取根节点元素对象
		Element root = document.getRootElement();
		Element servers = root.element("servers");
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = servers.elementIterator();
		while (iterator.hasNext()) {
			Element server = iterator.next();
			String IP = handler.getIpByServerNode(server.getText());
			for (IpDomain ipDomain : handler.ipDomainList) {
				if ("0".equals(ipDomain.getTag().toString())) {
					continue;
				}
				if (IP.equals(ipDomain.getIp())) {
					server.setText(ipDomain.getDomain());
				}
			}
		}
		try {
			XMLWriter writer = new XMLWriter(
					new FileWriter(Constans.XMLPATH));
			writer.write(document);
			writer.close();
			System.out.println("域名替换IP成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	


}
