import java.util.List;

public class DeveloperServiceImpl extends BaseService{

    public DeveloperServiceImpl(List<Object> developers) {
        this.list = developers;
    }

    @Override
    public Object findById(long id) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        for (Object object : list) {
            Developer developer = (Developer) object;
            if (developer.getId() == id) {
                return object;
            }
        }
        return null;
    }

    @Override
    public void save(Object object) {
        if (object == null || list == null) {
            return;
        }
        if (object instanceof Developer) {
            int indexOfObject = list.indexOf(object);
            if (indexOfObject < 0) {
                list.add(object);
            } else {
                list.set(indexOfObject, object);
            }
        } else {
            System.out.println("WARN: DeveoperServiceImpl.save - Object is not of type Developer!");
        }

    }

    @Override
    public void deleteById(long id) {
        if (list != null && !list.isEmpty()) {
            for (Object object: list)
            {
                Developer developer = (Developer) object;
                if (developer.getId() == id) {
                    list.remove(object);
                }
            }
        }
    }
}
