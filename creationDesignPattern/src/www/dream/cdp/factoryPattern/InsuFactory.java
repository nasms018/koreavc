package www.dream.cdp.factoryPattern;

import java.util.Optional;

import www.dream.cdp.model.FInsu;
import www.dream.cdp.model.Insu;
import www.dream.cdp.model.VINsu;

public class InsuFactory {
	/** Factory Pattern */
	public static Optional<Insu> createInsu(String insuType) {
		switch (insuType) {
		case "Car" :
			return Optional.of(new VINsu());
		case "House" :
			return Optional.of(new FInsu());
		}
		return Optional.empty();
	}

}
