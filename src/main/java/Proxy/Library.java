package Proxy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, IDocument> documents = new HashMap<>();

    public void addDocument(IDocument document) {
        this.documents.put(document.getId(), document);
    }

    public void addProtectedDocument(int id, LocalDateTime createdAt, String content) {
        Document realDocument = new Document(id, createdAt, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        this.documents.put(id, proxy);
    }

    public IDocument getDocument(int documentId) {
        return this.documents.get(documentId);
    }
}
