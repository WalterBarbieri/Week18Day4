package w18d4proveMattina.users.payloads;

import lombok.Data;

@Data
public class UserLoginPayload {
	private String email;
	private String password;
}
