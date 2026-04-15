package proxy;

import java.time.LocalDateTime;

public class Document implements IDocument {
    private int id;
    private LocalDateTime createdAt;
    protected String content;

    public Document(int id, LocalDateTime createdAt, String content) {
        this.id = id;
        this.createdAt = createdAt;
        this.content = content;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public String getContent(User user) {
        return this.content;
    }
}
