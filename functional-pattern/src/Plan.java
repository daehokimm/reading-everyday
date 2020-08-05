import vehicles.Vehicle;

import java.math.BigDecimal;
import java.util.function.Function;

public enum Plan {
	BASIC(deliveryPriceWithPercentageSurplus(0.025)),
	PREMIUM(deliveryPriceWithPercentageSurplus(0.015)),
	BUSINESS(deliveryPriceWithPercentageSurplus(0.0));

	private static Function<Vehicle, BigDecimal> deliveryPriceWithPercentageSurplus(Double percentageSurplus) {
		return vehicle -> vehicle.getPrice().multiply(new BigDecimal(percentageSurplus).add(new BigDecimal(1)));
	}

	public final Function<Vehicle, BigDecimal> deliveryPrice;

	Plan(Function<Vehicle, BigDecimal> deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
}
