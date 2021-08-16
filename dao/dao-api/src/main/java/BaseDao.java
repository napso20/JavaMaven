import java.util.List;

public abstract class BaseDao<T extends BaseEntity> {

    protected List<T> list;

    T findById(long id){
        if (list == null || list.isEmpty()) {
            return null;
        }

        for (T object : list) {
            if (object.getId() == id) {
                return object;
            }
        }
        return null;
    }

    void save(T object) {
        if (object == null || list == null) {
            return;
        }

        int indexOfObject = list.indexOf(object);
        if (indexOfObject < 0) {
            list.add(object);
        } else {
            list.set(indexOfObject, object);
        }
    }

    void deleteById(long id){
        if (list != null && !list.isEmpty()) {
            list.removeIf(object -> object.getId() == id);
        }
    }
}
