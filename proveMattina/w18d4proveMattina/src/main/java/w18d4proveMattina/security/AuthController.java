package w18d4proveMattina.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import w18d4proveMattina.exceptions.UnauthorizeException;
import w18d4proveMattina.users.User;
import w18d4proveMattina.users.UsersService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UsersService us;

	@Autowired
	private JWTTools jwttTools;

	@PostMapping("/login")
	public String login(@RequestBody UserLoginPayload body) {
		User user = us.findByEmail(body.getEmail());
		if (!body.getPassword().equals(user.getPassword())) {

			String token = jwttTools.createToken(user);
			System.out.println(token);
			return "Credenziali corrette";
		} else {
			throw new UnauthorizeException("Credenziali non valide!");
		}

	}

}
