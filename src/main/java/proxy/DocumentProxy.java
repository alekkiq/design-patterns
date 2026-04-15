package proxy;

import proxy.service.AccessControlService;
import proxy.exception.AccessDeniedException;
import java.time.LocalDateTime;

public class DocumentProxy implements IDocument {
    private Document document;

    public DocumentProxy(Document document) {
        this.document = document;
    }

    @Override
    public int getId() {
        return this.document.getId();
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.document.getCreatedAt();
    }

    @Override
    public String getContent(User user) {
        if (!AccessControlService.getInstance().isAllowed(user.getUsername(), this.getId())) {
            throw new AccessDeniedException("User " + user.getUsername() + " does not have access to document " + this.getId());
        }

        return this.document.getContent(user);
    }

    public Document getDocument() {
        return this.document;
    }
}
