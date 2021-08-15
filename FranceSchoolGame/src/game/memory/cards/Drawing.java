package game.memory.cards;

//枚举类型
public enum Drawing {
	//枚举类  样式
	HOUSE("HOUSE"),DOG("-DOG-"),CAT("-CAT-"),STAR("STAR "),MOON(" MOON"),
	SEVEN("77777"),PLANE("PLANE"),WOMAN("WOMAN"),BACK("*****");

	//将所有的值存储起来
	private static final Drawing[] array = Drawing.values();
	private String stringValue;
	
	private Drawing(String stringValue) {
		this.stringValue = stringValue;
	}

	public String toString() {
		return stringValue;
	}

	//静态方法   ？？？ 根据下标获取样式
	public static Drawing get(int i) {
		return array[i];
	}
	
}
