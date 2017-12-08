public class Singleton {
	private static Singleton _instance;

	private Singleton () {

	}

	public static getInstance () {
		if (_instance == null) {
			_instance = new Singleton();
		}
		return _instance;
	}

}

//内部静态类
public class Singleton {
	private Singleton (){}

	private static class Lazy_Singleton {
		static final Singleton _instance = new Singleton();
	}

	public static Singleton getInstance() {
		return Lazy_Singleton._instance;
	}
}