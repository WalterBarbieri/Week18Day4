package w18d4proveMattina.users.payloads;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class NewUserResponsePayload {
	private UUID id;
}
