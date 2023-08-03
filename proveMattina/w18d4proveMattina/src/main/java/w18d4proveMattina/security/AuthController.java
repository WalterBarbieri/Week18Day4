package w18d4proveMattina.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import w18d4proveMattina.exceptions.UnauthorizeException;
import w18d4proveMattina.users.User;
import w18d4proveMattina.users.UsersService;
import w18d4proveMattina.users.payloads.UserLoginPayload;
import w18d4proveMattina.users.payloads.UserRequestPayload;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UsersService us;

	@Autowired
	private JWTTools jwttTools;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody UserRequestPayload body) {
		User userCreated = us.create(body);
		return userCreated;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserLoginPayload body) {
		User user = us.findByEmail(body.getEmail());
		if (body.getPassword().equals(user.getPassword())) {
			String token = jwttTools.createToken(user);
			System.out.println(token);
			return new ResponseEntity<>(token, HttpStatus.OK);
		} else {
			throw new UnauthorizeException("Credenziali non valide!");
		}

	}

}
