import java.util.Optional;
import java.util.function.Consumer;

public class Customer {
	private final String name;
	private final Integer age;
	private final String address;
	private final String phoneNumber;
	private final Sex sex;

	private Customer(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.address = builder.address;
		this.phoneNumber = builder.phoneNumber;
		this.sex = builder.sex;
	}

	public static Builder builderOf(String name) {
		return new Builder(name);
	}

	static class Builder {
		private final String name;
		public Integer age;
		public String address;
		public String phoneNumber;
		public Sex sex;

		private Builder(String name) {
			this.name = name;
		}

		public Builder with(Consumer<Builder> consumer) {
			consumer.accept(this);
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}

	public String getName() {
		return name;
	}

	public Optional<Integer> getAge() {
		return Optional.ofNullable(age);
	}

	public Optional<String> getAddress() {
		return Optional.ofNullable(address);
	}

	public Optional<String> getPhoneNumber() {
		return Optional.ofNullable(phoneNumber);
	}

	public Optional<Sex> getSex() {
		return Optional.ofNullable(sex);
	}
	enum Sex {
		MALE, FEMALE
	}
}

