
public class GroomPetService extends AbstractService {

	private double productsUsedCost = 10.00;

	public GroomPetService(int hours) {
		super(hours, 15.75, "Groom");
	}

	@Override
	double calculateCost() {
		return (this.hours * this.rate) + this.productsUsedCost;
	}
}
