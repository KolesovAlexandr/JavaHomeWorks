package spaceInvaders;

public class GameScene extends SKScene {
	boolean contentCreated = false;

	void didMoveToView(SKView view) {
		if (!contentCreated) {
			createContent();
			contentCreated = true;
		}
	}

	enum InvaderType {
		A, B, C
	};

	private void createContent() {
	
		CGSize kInvaderSize = CGSize(width:24, height:16);
		CGSize kInvaderGridSpacing = CGSize(width:12, height:12);
		int kInvaderRowCount = 6;
		int kInvaderColCount = 6;
				 
		// 3
		String kInvaderName = "invader";
		
	}
}
