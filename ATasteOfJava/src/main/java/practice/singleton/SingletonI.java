package practice.singleton;

/**
 * Created by Hyace on 2015/9/1.
 */
public class SingletonI {
    private SingletonI() {
    }

    private static class SingletonHolder {
        public final static SingletonI instance = new SingletonI();
    }

    public static SingletonI getInstance() {
        return SingletonHolder.instance;
    }
}
