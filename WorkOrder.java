public class WorkOrder implements Comparable<WorkOrder> {
    int priority;
    String description;

    public WorkOrder(int aPriority, String aDescription) {
        priority = aPriority;
        description = aDescription;
    }

    public String toString() {
        return "priority= " + priority + ", description= " + description;
    }

    @Override
    public int compareTo(WorkOrder other) {
        if (priority < other.priority) return -1;
        if (priority > other.priority) return 1;
        return 0;
    }

    public int getPriority() {
        return priority;
    }
    public String getDescription() {
        return description;
    }
}
