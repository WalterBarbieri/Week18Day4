package w18d4proveMattina.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import w18d4proveMattina.users.User;

@Component
public class JWTTools {
	public String createToken(User u) {
		String token = Jwts.builder().setSubject(u.getId().toString()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
				.signWith(Keys.hmacShaKeyFor("supersecretsupersecretsupersecretsupersecretsupersecret".getBytes()))
				.compact();
		return "token";
	}

	public void verifyToken(String token) {

	}
}
