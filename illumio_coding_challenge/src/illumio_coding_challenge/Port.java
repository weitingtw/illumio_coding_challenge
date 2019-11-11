package illumio_coding_challenge;

public class Port {
	private String type;
	private int startPort;
	private int endPort;

	public Port(String port){
		parsePort(port);
	}

	public Integer getStartPort(){
		return startPort;
	}

	private void parsePort(String port){
		String[] ports = port.split("-");
		if (ports.length == 1){
			this.type = "single";
			this.startPort = Integer.valueOf(ports[0]);
		} else if (ports.length == 2){
			this.type = "range";
			this.startPort = Integer.valueOf(ports[0]);
			this.endPort = Integer.valueOf(ports[1]);
		}
	}

	public boolean matches(Port port){
		int portNum = port.getStartPort();
		if (type == "single"){
			return startPort == portNum;
		} else if (type == "range"){
			return startPort <= portNum && portNum <= endPort;
		}
		return false;
	}
}
