package proxy.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private Map<String, Set<Integer>> permissions = new HashMap<>();

    private AccessControlService() {}

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public boolean isAllowed(String username, int documentId) {
        return this.permissions.containsKey(username) && this.permissions.get(username).contains(documentId);
    }

    public void grantAccess(String username, int documentId) {
        this.permissions.putIfAbsent(username, new HashSet<>());
        this.permissions.get(username).add(documentId);
    }
}
