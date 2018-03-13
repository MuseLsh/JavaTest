package model;

public class IpDomain {
	
	private String ip;
	private String domain;
	private Integer tag;
	
	
	
	public IpDomain(String ip, String domain, Integer tag) {
		this.ip = ip;
		this.domain = domain;
		this.tag = tag;
	}
	
	public IpDomain(){}
	
	public String getIp() {
		return ip;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public Integer getTag() {
		return tag;
	}
	
	@Override
	public String toString() {
		return "IpDomain [ip=" + ip + ", domain=" + domain + ", tag=" + tag
				+ "]";
	}
	
	

}
