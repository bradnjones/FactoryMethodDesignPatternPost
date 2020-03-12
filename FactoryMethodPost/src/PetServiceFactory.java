
public class PetServiceFactory implements ServiceFactory {

	public AbstractService createService(String serviceType, int hours) {

		AbstractService aPetService = null;
		switch (serviceType.toLowerCase()) {
		case "wash":
			aPetService = new WashPetService(hours);
			break;

		case "walk":
			aPetService = new WalkPetService(hours);
			break;

		case "groom":
			aPetService = new GroomPetService(hours);
			break;

		default:
			System.out.println("ERROR: " + serviceType + "is not a supported type of Pet Service.");
			break;
		}

		return aPetService;
	}

}
