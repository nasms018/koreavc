package www.dream.recursion.hanoi;

import java.util.Stack;

public class TowerMain {

	public static void move(int height, Stack<Integer> src, Stack<Integer> target, Stack<Integer> temp) {
		if (height == 1) {
			target.push(src.pop());
		} else {
			//원본에서 height - 1개를 임시로 한꺼번에 옮기고
			move(height - 1, src, temp, target);
			//한개가 남은 원본의 맨 아래 것을 목적지로 옮긴 다음에
			target.push(src.pop());
			//임시에 옮겨둔 height - 1개를 목적지로 옮긴다
			move(height - 1, temp, target, src);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> src = new Stack<>(), temp = new Stack<>(), target = new Stack<>();
		//원본 탑 만들기
		final int LAYERS = 4;
		for (int i = LAYERS; i > 0 ; i--)
			src.push(i);

		for (int val : src)
			System.out.print(val + " ");

		move(LAYERS, src, target, temp);
		
		if (! src.isEmpty())
			System.out.println("개발 오류");

		System.out.println("");
		for (int val : target)
			System.out.print(val + " ");
	}

}
