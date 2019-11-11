package illumio_coding_challenge;

public class Rule{

	private String direction;
	private String protocol;
	private Port port;
	private InternetProtocol ip;

	public Rule(String direction, String protocol, String port, String ip){
		this.direction = direction;
		this.protocol = protocol;
		this.port = new Port(port);
		this.ip = new InternetProtocol(ip);
	}

	public String getDirection(){
		return this.direction;
	}

	public String getProtocol(){
		return this.protocol;
	}

	public Port getPort(){
		return this.port;
	}

	public InternetProtocol getIP(){
		return this.ip;
	}

	@Override
    public boolean equals(Object object) {
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Rule input = (Rule)object;
        return (
                input.direction.equals(this.direction) &&
                input.protocol.equals(this.protocol) &&
                this.ip.matches(input.getIP())&&
                this.port.matches(input.getPort())
        );
    }
}
