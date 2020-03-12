import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Invoice {

	private static ArrayList<String> supportedPetServices = new ArrayList<String>(
			Arrays.asList("wash", "walk", "groom"));

	private static DecimalFormat df = new DecimalFormat("#0.00");

	public static void main(String[] args) {
		ServiceFactory aServiceFactory = new PetServiceFactory();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
		ArrayList<AbstractService> lineItems = new ArrayList<AbstractService>();

		try {
			do {
				System.out.println("Add a line item? (y/n)");
				inputString = br.readLine();
				if (inputString.equals("y")) {
					String petServiceType = handlePetServiceTypeInput(br);
					int hours = handleHoursInput(br);
					AbstractService aService = aServiceFactory.createService(petServiceType, hours);
					if (aService != null) {
						lineItems.add(aService);
					}
				}

			} while (inputString != null && (!inputString.equalsIgnoreCase("n")));

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

		printInvoice(lineItems);
	}

	private static void printInvoice(ArrayList<AbstractService> lineItems) {
		System.out.println();
		System.out.println("*****************************************************");
		System.out.println("*                     INVOICE                       *");
		System.out.println("*****************************************************");
		System.out.println();

		double[] totalCost = { 0.00 };

		lineItems.forEach(aLineItem -> {
			double lineItemCost = aLineItem.calculateCost();
			totalCost[0] += lineItemCost;
			System.out.println("    " + aLineItem.getType() + "  PRICE: $" + df.format(lineItemCost) + "  RATE: $"
					+ df.format(aLineItem.getRate()) + "  HOURS: " + aLineItem.getHours());
		});

		System.out.println("    _____________________________________________");
		System.out.println("    TOTAL: $" + df.format(totalCost[0]));
		System.out.println();
		System.out.println("*****************************************************");

	}

	private static String handlePetServiceTypeInput(BufferedReader br) throws IOException {
		System.out.println("Service Type (wash, walk, groom)");
		String petServiceType = br.readLine();
		if (supportedPetServices.contains(petServiceType.toLowerCase())) {
			return petServiceType;
		} else {
			System.out.println(petServiceType
					+ " is not a supported Pet Service, please use one of the following values; wash, walk or groom.");
			return handlePetServiceTypeInput(br);
		}
	}

	private static int handleHoursInput(BufferedReader br) throws IOException {

		try {
			System.out.println("Number of service hours");
			String inputString = br.readLine();
			return Integer.parseInt(inputString);
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid Value for hours, please retry.");
			return handleHoursInput(br);
		}
	}

}
