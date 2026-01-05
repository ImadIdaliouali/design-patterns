package ma.enset.security;

import java.util.Arrays;

public class SecurityContext {
    private static String username;
    private static String password;
    private static String[] roles;

    public static void authenticate(String username, String password, String[] roles) {
        SecurityContext.username = username;
        SecurityContext.password = password;
        SecurityContext.roles = roles;
        System.out.println("✓ Utilisateur authentifié : " + username);
        System.out.println("✓ Rôles attribués : " + Arrays.toString(roles));
    }

    public static boolean hasRole(String role) {
        if (roles == null) {
            return false;
        }
        for (String r : roles) {
            if (r.equals(role)) {
                return true;
            }
        }
        return false;
    }

    public static String getUsername() {
        return username;
    }

    public static String[] getRoles() {
        return roles;
    }

    public static void logout() {
        username = null;
        password = null;
        roles = null;
    }
}
