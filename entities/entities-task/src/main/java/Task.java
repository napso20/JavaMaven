import lombok.Data;

@Data
public class Task extends BaseEntity {
    public enum Status { OPEN, IN_PROGRESS, FINISHED}

    private String description;
    private Status status;
    private int priority; // 1 to 10

    public Task(long id, String description, Status status, int priority) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }
}
