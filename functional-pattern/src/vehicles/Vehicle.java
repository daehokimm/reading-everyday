package vehicles;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface Vehicle {
	default void start(Consumer<Void> preStartCheck) {
		preStartCheck.accept(null);
		System.out.printf("%s starting...%n", this.getClass().getSimpleName());
	}

	BigDecimal getPrice();
}
