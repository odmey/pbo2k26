package db;

public class Session {
    private final int id;
    private final String name;
    private final int minutes;
    private final String finishedAt;

    public Session(int id, String name, int minutes, String finishedAt) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.finishedAt = finishedAt;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getMinutes() { return minutes; }
    public String getFinishedAt() { return finishedAt; }
}
