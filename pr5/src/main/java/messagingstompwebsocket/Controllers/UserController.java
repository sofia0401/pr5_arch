package messagingstompwebsocket.Controllers;

import messagingstompwebsocket.Models.IdUser;
import messagingstompwebsocket.Service.UserService;
import messagingstompwebsocket.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@MessageMapping("/hello")
	@SendTo("/topic/response")
	public Users greeting(Users users) throws Exception {
		System.out.println(users.toString());
		return userService.save(users);
	}

	@MessageMapping("/id")
	@SendTo("/topic/response")
	public Users findOne(IdUser id) throws Exception {
		System.out.println(id.toString());
		return userService.findById(id.getId());
	}
}