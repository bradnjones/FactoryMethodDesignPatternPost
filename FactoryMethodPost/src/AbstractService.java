
public abstract class AbstractService {
	protected int hours;
	protected double rate;
	protected String type;

	abstract double calculateCost();

	public AbstractService(int hours, double rate, String type) {
		super();
		this.hours = hours;
		this.rate = rate;
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public int getHours() {
		return this.hours;
	}

	public double getRate() {
		return this.rate;
	}

}
