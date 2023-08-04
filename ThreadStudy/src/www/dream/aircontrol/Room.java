package www.dream.aircontrol;

public class Room {
	private float temperature = 30;
	
	public Room(float temperature) {
		this.temperature = temperature;
	}

	public void heat(float f) {
		temperature += f;
	}

	public float getCurTemp() {
		return temperature;
	}
}
