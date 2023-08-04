package www.dream.aircontrol;

public class Main {

	public static void main(String[] args) {
		Room room = new Room(10);
		AirConditioner ac = new AirConditioner(-200);
		ac.setTargetTemperature(20);
		ac.setRoom(room);
		
		Heater hongGilDong = new Heater(80);
		Heater computer = new Heater(25);
		
		hongGilDong.setRoom(room);
		computer.setRoom(room);
		
		(new Thread(computer)).start();
		(new Thread(hongGilDong)).start();

		(new Thread(ac)).start();

	}

}
