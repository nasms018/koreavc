package www.dream.aircontrol;

public class Heater implements Runnable {
	private float power;
	
	private Room room;
	
	public Heater(float power) {
		this.power = power;
	}

	@Override
	public void run() {
		while (true) {
			heatRoom();
			setOnOff(room.getCurTemp());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	protected void heatRoom() {
		room.heat(power / 100);
	}
	/**
	 * AirConditioner 구체화 시킬 기능
	 */
	protected void setOnOff(float curTemp) {}
}
