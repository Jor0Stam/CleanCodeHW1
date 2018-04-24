package bg.uni.sofia.fmi.mjt.dungeon.actor;

public class Position {
	private int horizontalPosition;
	private int verticalPosition;
	
	public Position() {
		this.horizontalPosition=0;
		this.verticalPosition=0;
	}
	
	public Position(int horizontalPosition, int verticalPosition) {
		this.horizontalPosition=horizontalPosition;
		this.verticalPosition=verticalPosition;
	}
	
	public int getHP() {
		return horizontalPosition;
	}
	public void setHP(int horizotalPosition) {
		if(horizotalPosition>=0 && horizotalPosition<=9) {
			this.horizontalPosition = horizotalPosition;
		}
	}
	public int getVP() {
		return verticalPosition;
	}
	public void setVP(int verticalPosition) {
		if(verticalPosition>=0 && verticalPosition<=4) {
			this.verticalPosition = verticalPosition;
		}
	}
	
	public boolean isValidPosition(int command) {
		
		switch(command) {
		case 0:
			return (this.horizontalPosition-1) >= 0 && (this.horizontalPosition-1)<=9;
		case 1:
			return (this.verticalPosition-1) >= 0 && (this.verticalPosition-1)<=4;
		case 2:
			return (this.horizontalPosition+1) >= 0 && (this.horizontalPosition+1)<=9;
		}
		return (this.verticalPosition+1) >= 0 && (this.verticalPosition+1)<=4;
				
	}
	
	public void ChangePosition(int command) {
		
		switch(command) {
		case 0:
			this.setHP(this.horizontalPosition-1);
			break;
		case 1:
			this.setVP(this.verticalPosition-1);
			break;
		case 2:
			this.setHP(this.horizontalPosition+1);
			break;
		case 3:
			this.setVP(this.verticalPosition + 1);
		}
		
	}
}

