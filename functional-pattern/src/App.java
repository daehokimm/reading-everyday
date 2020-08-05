import vehicles.*;

import java.math.BigDecimal;
import java.util.function.Function;

public class App {
	public static void main(String[] args) {
		// factory method pattern
		Vehicle blackCar = VehicleType.CAR.factory.apply(VehicleColor.BLACK);

		// template method pattern
		blackCar.start(nil -> System.out.println("Check if every passenger is seated"));

		// strategy pattern
		BigDecimal deliveryPrice = Plan.BASIC.deliveryPrice.apply(blackCar);
		System.out.println("Delivery Price of Car is " + deliveryPrice);

		// builder pattern
		final Customer customer = Customer.builderOf("daehokimm")
				.with(builder -> {
					builder.age = 29;
					builder.address = "nowhere";
					builder.phoneNumber = "0100000000";
					builder.sex = Customer.Sex.MALE;
				})
				.build();
		System.out.println(customer.getAddress().orElse("No Address"));

		// chain of responsibility pattern
		Function<Car, Car> initial = c -> new Car();
		final Function<Car, Car> chain = initial
				.andThen(c1 -> c1.updateState(WashState.INITIAL_WASH))
				.andThen(c1 -> c1.updateState(WashState.SOAP))
				.andThen(c1 -> c1.updateState(WashState.RINSED))
				.andThen(c1 -> c1.updateState(WashState.POLISHED))
				.andThen(c1 -> c1.updateState(WashState.DRIED));

		Car cleanCar = chain.apply((Car) blackCar);
		System.out.println("Final car washing state is " + cleanCar.getWashState());

	}
}
