package w18d4proveMattina.security;

import lombok.Data;

@Data
public class UserLoginPayload {
	private String email;
	private String password;
}
