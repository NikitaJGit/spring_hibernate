package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru", carService.add(new Car("model_1", 1)));
      userService.add(user1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", carService.add(new Car("model_2", 2)));
      userService.add(user2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", carService.add(new Car("model_3", 3)));
      userService.add(user3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", carService.add(new Car("model_4", 4)));
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      userService.getCarUser("model_1", 1);
      userService.getCarUser("model_2", 2);
      userService.getCarUser("model_3", 3);
      userService.getCarUser("model_4", 4);

      context.close();
   }
}
