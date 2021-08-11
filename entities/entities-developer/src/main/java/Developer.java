import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Developer extends BaseEntity {
    private String name;
    private List<Task> tasks;

    public Developer(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Developer(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public void AddTask(Task task) {
        if (this.tasks == null) {
            this.tasks = new LinkedList<>();
        }
        int indexOfObject = tasks.indexOf(task);
        if (indexOfObject < 0) {
            tasks.add(task);
        } else {
            tasks.set(indexOfObject, task);
        }
    }

}
