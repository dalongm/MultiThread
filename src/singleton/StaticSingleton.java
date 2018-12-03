package singleton;

/**
 * @author dalongm
 * @description 
 * @date 2018/9/27 20:21
 **/
public class StaticSingleton {
    private StaticSingleton() {

    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
