package game.memory.cards;

//卡片抽象类
public abstract class Card implements ICard {

	//全局变量   卡片默认不可见
	private boolean visible=false; 
	
	/**
	 * public getters (and setters)
	 * @return the attribute visible
	 */
	//卡片是否可见
	public boolean isVisible() {
		return this.visible;
	}
	//卡片的反转
	public void turn() {
		this.visible = !this.visible;
	}

	//取背面
	@Override
	public String getBack() {
		return Drawing.BACK.toString();
	}

	//将目前状态卡片显示出来
	@Override
	public String toString() {
		return visible ? getFace():getBack();
	}

	
	
}
