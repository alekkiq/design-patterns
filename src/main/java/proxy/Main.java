package proxy;

import proxy.service.AccessControlService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        // add an unprotected document first
        lib.addDocument(new Document(1, LocalDateTime.now(), "Julkist kamaa!"));

        // add protected documents
        lib.addProtectedDocument(2, LocalDateTime.now(), "top secret classified kamaa");
        lib.addProtectedDocument(3, LocalDateTime.now(), "lisää top secret classified kamaa");

        // dummy users
        User u1 = new User("Aleksi");
        User u2 = new User("Lenni");

        // grant access to users
        acs.grantAccess(u1.getUsername(), 2);
        acs.grantAccess(u2.getUsername(), 3);

        // demo access attempts
        lib.getDocument(1).getContent(u1); // succeed
        lib.getDocument(1).getContent(u2); // succeed
        lib.getDocument(2).getContent(u1); // succeed
        lib.getDocument(2).getContent(u2); // fail
        lib.getDocument(3).getContent(u1); // fail
        lib.getDocument(3).getContent(u2); // succeed
    }
}
