import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yabinh on 05/08/2017.
 */
public class DynamicProxy {
    public static void main(String[] args) {
        InvocationHandler handler1 = new DAOHandler(new UserDAO());
        AbstractUserDAO proxy1 =
                (AbstractUserDAO) Proxy.newProxyInstance(
                        AbstractUserDAO.class.getClassLoader(), new Class[] {AbstractUserDAO.class}, handler1
                );
        proxy1.findUserById("Tom");

        InvocationHandler handler2 = new DAOHandler(new DocumentDAO());
        AbstractDocumentDAO proxy2 =
                (AbstractDocumentDAO) Proxy.newProxyInstance(
                        AbstractDocumentDAO.class.getClassLoader(), new Class[] {AbstractDocumentDAO.class}, handler2
                );
        proxy2.findDocumentById("abc.txt");
    }
}

interface AbstractUserDAO {
    boolean findUserById(String id);
}

interface AbstractDocumentDAO {
    boolean findDocumentById(String id);
}

class UserDAO implements AbstractUserDAO {
    @Override
    public boolean findUserById(String id) {
        if (id.equalsIgnoreCase("Tom")) {
            System.out.println("Found Tom!");
            return true;
        }
        System.out.println("Not found Tom");
        return false;
    }
}

class DocumentDAO implements AbstractDocumentDAO {
    @Override
    public boolean findDocumentById(String id) {
        if (id.equalsIgnoreCase("abc.txt")) {
            System.out.println("Found abc.txt");
            return true;
        }
        System.out.println("Not found abc.txt");
        return false;
    }
}

class DAOHandler implements InvocationHandler {
    private Object object;
    DAOHandler(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy /* not use? */, Method method, Object[] args) throws Exception{
        System.out.println("pre invoke");
        Object result = method.invoke(object, args);
        System.out.println("post invoke");
        return result;
    }
}
