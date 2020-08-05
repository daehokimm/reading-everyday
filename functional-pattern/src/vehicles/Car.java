package vehicles;

import java.math.BigDecimal;

public class Car implements Vehicle {
	private VehicleColor color;
	private WashState washState;

	public Car(VehicleColor vehicleColor) {
		this.color = vehicleColor;
	}

	public Car() {
		this.color = VehicleColor.BLACK;
	}

	@Override
	public BigDecimal getPrice() {
		return new BigDecimal(1000);
	}

	public VehicleColor getColor() {
		return color;
	}

	public Car updateState(WashState state) {
		this.washState = state;
		return this;
	}

	public WashState getWashState() {
		return washState;
	}
}
