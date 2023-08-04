package www.dream.cdp.factoryPattern;

import java.util.Optional;

import www.dream.cdp.model.House;
import www.dream.cdp.model.Car;
import www.dream.cdp.model.SleepingPlace;

public class SPFactory {
	/** Factory Pattern */
	public static Optional<SleepingPlace> createVehicle(String carType) {
		switch (carType) {
		case "Car" :
			return Optional.of(new Car());
		case "House" :
			return Optional.of(new House());
		}
		return Optional.empty();
	}
}
