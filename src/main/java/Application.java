import com.nitish.controller.UserController;
import com.nitish.service.UserService;

/**
 * Created by nsm1211 on 10-09-2015.
 */
public class Application {

    public static void main(String[] args) {
        // need to the basic initliaztion here
        new UserController(new UserService());
    }
}
