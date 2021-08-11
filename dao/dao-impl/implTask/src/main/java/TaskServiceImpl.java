import java.util.List;

public class TaskServiceImpl extends BaseService {

    public TaskServiceImpl(List<Object> tasks) {
        this.list = tasks;
    }

    @Override
    public Object findById(long id) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        for (Object object : list) {
            Task task = (Task) object;
            if (task.getId() == id) {
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
        if (object instanceof Task) {
            int indexOfObject = list.indexOf(object);
            if (indexOfObject < 0) {
                list.add(object);
            } else {
                list.set(indexOfObject, object);
            }
        } else {
            System.out.println("WARN: TaskServiceImpl.save - Object is not of type Task!");
        }
    }

    @Override
    public void deleteById(long id) {
        if (list != null && !list.isEmpty()) {
            for (Object object: list)
            {
                Task task = (Task) object;
                if (task.getId() == id) {
                    list.remove(object);
                }
            }
        }
    }
}
