package illumio_coding_challenge;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Firewall {
	private Set<Rule> rules;

	public Firewall(String csvPath){
		rules = new HashSet<>();
		readCSV(csvPath);
	}

	private void readCSV(String csvPath){
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvPath));
			String line = br.readLine();
			while (line != null){
				String[] rule = line.split(",");
				Rule newRule = new Rule(rule[0], rule[1], rule[2], rule[3]);
				rules.add(newRule);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("CSV File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Error");
			e.printStackTrace();
		}
	}

	public boolean accept_packet(String direction, String protocol, int port, String ip){
		Rule incomingRule = new Rule(direction, protocol, String.valueOf(port), ip);
		for (Rule rule:rules){
			if (rule.equals(incomingRule)){
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		Firewall fw = new Firewall("./test_rules.csv");
		boolean test1 = fw.accept_packet("inbound", "tcp", 80, "192.168.1.2");
		System.out.println(test1);  //expect true;

		boolean test2 = fw.accept_packet("outbound", "tcp", 10234, "192.168.10.11");
		System.out.println(test2);  //expect true;

		boolean test3 = fw.accept_packet("inbound", "udp", 53, "192.168.2.1");
		System.out.println(test3);  //expect true;

		boolean test4 = fw.accept_packet("inbound", "tcp", 81, "192.168.1.2");
		System.out.println(test4);  //expect false;

		boolean test5 = fw.accept_packet("inbound", "udp", 24, "52.12.48.92");
		System.out.println(test5);  //expect false;

		boolean test6 = fw.accept_packet("inbound", "tcp", 30, "0.0.1.1");
		System.out.println(test6);  //expect true;

		boolean test7 = fw.accept_packet("inbound", "tcp", 20001, "0.0.1.1");
		System.out.println(test7);  //expect false;

		boolean test8 = fw.accept_packet("outbound", "udp", 19999, "52.12.48.92");
		System.out.println(test8);	//expect false;

	}

}
