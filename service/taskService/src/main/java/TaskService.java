import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class TaskService extends BaseDao {

    TaskService() {
        this.list = new LinkedList();
    }

    TaskService(List<BaseEntity> list) {
        this.list = list;
    }

    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }

    public static void main(String[] args) {
        TaskService service = new TaskService();
        Properties prop = service.loadPropertiesFile("db.properties");
        String profile = prop.getProperty("db.profileName");

        Task task1 = new Task(1, "Task-1", Task.Status.OPEN, 1);
        Task task2 = new Task(2, "Task-2", Task.Status.OPEN, 2);
        Task task3 = new Task(3, "Task-3", Task.Status.OPEN, 3);
        Task task4 = new Task(4, "Task-4", Task.Status.OPEN, 4);
        Task task5 = new Task(5, "Task-5", Task.Status.OPEN, 5);

        if (profile.equals("dev")) {
            Developer dev1 = new Developer(1, "Developer-1");
            dev1.AddTask(task1);
            dev1.AddTask(task2);
            dev1.AddTask(task3);

            Developer dev2 = new Developer(2, "Developer-2");
            dev2.AddTask(task4);
            dev2.AddTask(task5);

            service.save(dev1);
            service.save(dev2);

            // Additional way to construct TaskService
//            List<BaseEntity> developers = new LinkedList<>();
//            developers.add(dev1);
//            developers.add(dev2);
//            service = new TaskService(developers);

            final Object objectById = service.findById(1);
            var developerById = (Developer) objectById;
            service.save(new Task(6, "Task-6", Task.Status.OPEN, 9));
            task5.setStatus(Task.Status.IN_PROGRESS);
            service.deleteById(4);
            System.out.println("taskById: " + developerById.getId() + ", description: " + developerById.getName() + ", current tasks:");
            for (var task : developerById.getTasks()) {
                System.out.println("taskById: " + task.getId() + ", description: " + task.getDescription() + ", status: " + task.getStatus());
            }
        } else if (profile.equals("task")) {

            service.save(task1);
            service.save(task2);
            service.save(task3);
            service.save(task4);
            service.save(task5);

            // additional way to construct TaskService
//            List<BaseEntity> tasks = new LinkedList<>();
//            tasks.add(task1);
//            tasks.add(task2);
//            tasks.add(task3);
//            tasks.add(task4);
//            tasks.add(task5);
//            service = new TaskService(tasks);

            final Object objectById = service.findById(3);
            task2.setStatus(Task.Status.FINISHED);
            task2.setPriority(10);
            service.save(task2);
            var taskById = (Task) objectById;
            service.deleteById(5);
            System.out.println("taskById: " + taskById.getId() + ", description: " + taskById.getDescription() + ", status: " + taskById.getStatus());
        }
    }
}