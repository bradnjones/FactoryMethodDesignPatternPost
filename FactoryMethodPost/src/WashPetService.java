
public class WashPetService extends AbstractService {

	public WashPetService(int hours) {
		super(hours, 5.00, "Wash ");
	}

	@Override
	double calculateCost() {
		return this.hours * this.rate;
	}
}
