package www.dream.cdp;

import www.dream.cdp.abstractFactory.AF;
import www.dream.cdp.factoryPattern.AFFactory;
import www.dream.cdp.factoryPattern.SPFactory;

public class Client {

	public static void main(String[] args) {
		AF af = AFFactory.createAF("M");
		System.out.println(af.createSP().get().getEngineSound());
		System.out.println(af.createInsu().get().안심되니());
	}

	private static void tacUseCase() {
		System.out.println(SPFactory.createVehicle("Bus").get().getEngineSound());
		System.out.println(SPFactory.createVehicle("Car").get().getEngineSound());
	}

}
