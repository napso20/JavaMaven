import java.util.List;

public class TaskServiceImpl extends BaseService {

    public TaskServiceImpl(List<BaseEntity> tasks) {
        this.list = tasks;
    }
}
