package bm.app.apigithubuser.service;

import bm.app.apigithubuser.model.User;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);



    public User[] fetchUser(String username) throws IOException {

        URL url = new URL("https://api.github.com/users/" + username + "/repos");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        User[] user = new Gson().fromJson(reader, User[].class);

        if (user == null) {
            logger.error("Could not return the result.");
            return null;
        } else {
            logger.info("The output returned.");
            return user;
        }
    }
}
