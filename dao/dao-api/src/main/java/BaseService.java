import java.util.List;

public abstract class BaseService {

    protected List<Object> list;

    abstract Object findById(long id);

    abstract void save(Object object);

    abstract void deleteById(long id);
}
