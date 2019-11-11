package illumio_coding_challenge;

public class InternetProtocol {
	private String type;
	private int[] startIP;
	private int[] endIP;

	public InternetProtocol(String ip){
		parseIP(ip);
	}

	public int[] getStartIP(){
		return this.startIP;
	}

	private void parseIP(String ip){
		String[] ips = ip.split("-");
		if (ips.length == 1){
			this.type = "single";
			this.startIP = new int[4];

			String[] start = ips[0].split("\\.");
			this.startIP[0] = Integer.valueOf(start[0]);
			this.startIP[1] = Integer.valueOf(start[1]);
			this.startIP[2] = Integer.valueOf(start[2]);
			this.startIP[3] = Integer.valueOf(start[3]);
		} else if (ips.length == 2){
			this.type = "range";
			this.startIP = new int[4];
			this.endIP = new int[4];
			String[] start = ips[0].split("\\.");
			String[] end = ips[1].split("\\.");

			this.startIP[0] = Integer.valueOf(start[0]);
			this.startIP[1] = Integer.valueOf(start[1]);
			this.startIP[2] = Integer.valueOf(start[2]);
			this.startIP[3] = Integer.valueOf(start[3]);

			this.endIP[0] = Integer.valueOf(end[0]);
			this.endIP[1] = Integer.valueOf(end[1]);
			this.endIP[2] = Integer.valueOf(end[2]);
			this.endIP[3] = Integer.valueOf(end[3]);
		}
	}

	public boolean matches(InternetProtocol ip){
		int[] ips = ip.getStartIP();
		if (type == "single"){
			return ips[0] == startIP[0] && ips[1] == startIP[1]
					&& ips[2] == startIP[2] && ips[3] == startIP[3];
		} else if (type == "range"){
			return ips[0] >= startIP[0] && ips[1] >= startIP[1]
					&& ips[2] >= startIP[2] && ips[3] >= startIP[3]
					&& ips[0] <= endIP[0] && ips[1] <= endIP[1]
					&& ips[2] <= endIP[2] && ips[3] <= endIP[3];
		}
		return false;
	}
}
