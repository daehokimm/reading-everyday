package vehicles;

import java.math.BigDecimal;

public class Bus implements Vehicle{
	private VehicleColor color;

	public Bus(VehicleColor vehicleColor) {
		this.color = vehicleColor;
	}

	public VehicleColor getColor() {
		return color;
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(2000);
	}
}
