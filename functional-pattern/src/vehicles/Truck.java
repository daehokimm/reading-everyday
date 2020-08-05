package vehicles;

import java.math.BigDecimal;

public class Truck implements Vehicle{
	private VehicleColor color;

	public Truck(VehicleColor vehicleColor) {
		this.color = vehicleColor;
	}

	public VehicleColor getColor() {
		return color;
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(1500);
	}
}
