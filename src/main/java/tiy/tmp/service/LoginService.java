package tiy.tmp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Value("${debug.skip-login:#{false}}")
    private boolean skipLoginForDebug;

    @Value("${debug.skip-logout:#{false}}")
    private boolean skipLogoutForDebug;

    private boolean isLoggedIn = false;

    public void loginIfStillNotLoggedIn() {
        if (!isLoggedIn && !skipLoginForDebug) {
            System.out.println("***** Logging in...");
            isLoggedIn = true;
        }
    }

    public void logout() {
        if (isLoggedIn && !skipLogoutForDebug) {
            System.out.println("***** Logging out...");
            isLoggedIn = false;
        }
    }

}
