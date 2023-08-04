package www.dream.ttt.player;

import java.util.Scanner;

import www.dream.ttt.model.Board;
import www.dream.ttt.model.Cell;
import www.dream.ttt.model.domain.StoneType;

public class UserPlayer extends Player {
	private Scanner scan;
	
	public UserPlayer(String name) {
		//상위 클래스의 생성자를 활용
		super(name);
		super.myStone = StoneType.White;
		scan = new Scanner(System.in);
	}

	@Override
	public void 너마음에드는칸에돌놓아라() {
		do {
			System.out.println("돌이 놓인 상황을 보고 빈칸을 선택하세요");
			int row = scan.nextInt();
			int col = scan.nextInt();
			Cell chosenCell = Board.getInstance().getEmptyCell(row, col);
			if (chosenCell != null) {	//있으면
				//this(나)의 상위 클래스 관점에서의 나입니다.
				chosenCell.돌놓을께(super.myStone);
				Board.getInstance().빈칸목록에서지워라(chosenCell);
				return;
			}
		} while(true); 
	}
}
