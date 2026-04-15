package proxy;

import java.time.LocalDateTime;

public interface IDocument {
    int getId();
    LocalDateTime getCreatedAt();
    String getContent(User user);
}
