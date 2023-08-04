package www.dream.ttt;

import www.dream.ttt.model.Board;
import www.dream.ttt.player.Player;
import www.dream.ttt.player.UserPlayer;

public class TTTMain {
	public static void main(String[] args) {
		final int PLAYER_CNT = 2;
		Player[] players = new Player[PLAYER_CNT];
		players[0] = new Player("자동");
		players[1] = new UserPlayer("배");

		int curPlayer = 0;
		
		do {
			players[curPlayer].너마음에드는칸에돌놓아라();
			Board.getInstance().display();
			//승부 났는 가?
			
			//종료 조건은 빈칸없어서 무승부, 또는 승자 나옴.
			if (!Board.getInstance().계속할까(players[curPlayer]))
				break;
			//턴 넘기기
			curPlayer = ++curPlayer % PLAYER_CNT;
		} while (true);
	}
}
