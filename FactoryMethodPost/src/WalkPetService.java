
public class WalkPetService extends AbstractService {

	public WalkPetService(int hours) {
		super(hours, 2.50, "Walk ");
	}

	@Override
	double calculateCost() {
		return this.hours * this.rate;
	}
}
