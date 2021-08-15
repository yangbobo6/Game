package game.memory.cards;

//卡片接口   卡片的所有性质
public interface ICard {
	//翻转
	public void turn();
	//取反面
	public String getBack();
	//取正面
	public String getFace();
	//是否可见
	public boolean isVisible();

}
