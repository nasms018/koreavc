package www.dream.aircontrol.simple;

public class SMain {

	public static void main(String[] args) {
		// 방의현재온도
		float curTemp = 16;
		// 설정 온도
		float targetTemp = 20;
		// 여유 범위
		final int BOUNDARY = 2; // 18~22
		// 에어컨 작동상태
		boolean isOn = false, prevACStatus = isOn;

		for (; true;) {
			//더우면 에어컨 킨다, 켜져있을 때 너무 추우면 끈다.
			isOn = curTemp > targetTemp + BOUNDARY || (isOn && curTemp >= targetTemp - BOUNDARY);

			curTemp += isOn ? -1 : 1;

			if (prevACStatus != isOn) {
				System.out.printf("에어컨 상태 %b, 현재 온도 : %f\n", isOn, curTemp);
			}
			prevACStatus = isOn;

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
