package www.dream.aircontrol;

public class AirConditioner extends Heater {
	private boolean onStatus = false;	//on_off
	private int targetTemperature;
	private static final int BOUNDARY = 1;
	
	public AirConditioner(float power) {
		super(power);
	}

	public void turnOn() {
		onStatus = true;
	}

	public void setTargetTemperature(int targetTemperature) {
		this.targetTemperature = targetTemperature;
	}

	@Override
	protected void setOnOff(float curTemp) {
		//더우면 에어컨 킨다, 켜져있을 때 너무 추우면 끈다.
		onStatus = curTemp > targetTemperature + BOUNDARY || (onStatus && curTemp >= targetTemperature - BOUNDARY);
		System.out.printf("%b  %.2f\n", onStatus, curTemp);
	}
	@Override
	protected void heatRoom() {
		if (onStatus)
			super.heatRoom();
	}
}
