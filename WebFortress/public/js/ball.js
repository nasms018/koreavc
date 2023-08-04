class Ball {
	constructor(radius) {
		/* 공의 반지름 크기*/
		this.radius = radius;
		/* 속도 */
		this.vX = 0;
		this.vY = 0;
	}

	위치지정(posX, posY) {
		this.posX = posX;
		this.posY = posY;
	}

	발사(ballVx, ballVy){
		this.vX = ballVx;
		this.vY = ballVy;
	}
	
	그리기간격(timeInterval) {
		this.timeInterval = timeInterval;
	}
		
	시간흐름() {
		//중력 가속도 적용
		this.vY += 1.98;

		//수평 등속 운동
		this.posX += this.vX;
		this.posY += this.vY;
	}

	맞추었니(target) {
		return target.inXBound(this.posX)
		 && target.inYBound(this.posY);
	}
	
	/* 공을 화면에 그린다. */
	drawBall(ctx) {
		ctx.beginPath();
		ctx.arc(this.posX, this.posY, this.radius, 0, 2.0 * Math.PI, true);
		ctx.fillStyle = "red";
		ctx.fill();
	}

}
