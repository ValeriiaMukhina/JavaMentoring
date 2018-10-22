package exercise7;

import java.util.Objects;

public final class Pancake {

	private static final double MIN_DIFF = 0.1;

	private final String name;

	private final double diameter;

	public Pancake(String name, double diameter) {
		super();
		this.name = name;
		this.diameter = diameter;
	}

	public String getName() {
		return name;
	}

	public double getDiameter() {
		return diameter;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pancake)) return false;
		Pancake pancake = (Pancake) o;
		return Double.compare(Math.round(pancake.getDiameter() / MIN_DIFF),
				Math.round(getDiameter() / MIN_DIFF)) == 0 &&
				Objects.equals(getName(), pancake.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), Math.round(getDiameter() / MIN_DIFF));
	}
}