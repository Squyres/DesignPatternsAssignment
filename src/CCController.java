import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CCController {

	private static final String ccDetails = "CCDetails.txt";
	private static List<AmExCC> amExCCList = new ArrayList<AmExCC>();
	private static List<DiscoverCC> discoverCCList = new ArrayList<DiscoverCC>();
	private static List<VisaCC> visaCCList = new ArrayList<VisaCC>();
	private static List<MasterCC> masterCCList = new ArrayList<MasterCC>();

	public static void main(String[] args) {
		readFromFile(ccDetails);
	}

	public static void readFromFile(String fileName) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		try {
			while (bufferedReader.ready()) {
				String nextCCDetails = String.valueOf(bufferedReader.readLine());
				parseCCDetails(nextCCDetails);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void parseCCDetails(String newCCDetails) {
		CreditCard newCard = null;
		String[] details = newCCDetails.split(",");
		String number = details[0];
		String expiration = details[1];
		String holder = details[2];
		if ((number.startsWith("5") || number.startsWith("2")) && number.length() == 16
				&& (number.charAt(1) <= 5 && number.charAt(1) >= 1)) {
			newCard = new MasterCC(number, expiration, holder);
			masterCCList.add((MasterCC) newCard);
		} else if (number.startsWith("4") && (number.length() == 13 || number.length() == 16)) {
			newCard = new VisaCC(number, expiration, holder);
			visaCCList.add((VisaCC) newCard);
		} else if (number.startsWith("3") && number.length() == 15
				&& (number.charAt(1) == 4 || number.charAt(1) == 7)) {
			newCard = new AmExCC(number, expiration, holder);
			amExCCList.add((AmExCC) newCard);
		} else if (number.length() == 16 && number.substring(0, 4).equals("6011")) {
			newCard = new DiscoverCC(number, expiration, holder);
			discoverCCList.add((DiscoverCC) newCard);
		} else {
			System.out.println("Unable to instantiate from known credit types.");
		}
		System.out.println(newCard);
	}

}
