import easy.framework.core.*;

/**
 * @author limengyu
 * @create 2017/10/19
 */
public class Test {

    @org.junit.Test
    public void loadClass(){
        ClassLoaderHelper.scanAllClassByPackageName("easy.mvc");
    }
}
