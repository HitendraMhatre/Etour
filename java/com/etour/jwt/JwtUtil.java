package com.etour.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret; 
    public String extractUsername(String token) {
    	System.out.println("inside extractUsername method");
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
    	System.out.println("inside extractExpiration method");
        return extractClaim(token, Claims::getExpiration);
    }
  //retrieve username from jwt token
  	public String getUsernameFromToken(String token) {
  		System.out.println("inside getUsernameFromToken method");
  		return getClaimFromToken(token, Claims::getSubject);
  	}
  	//retrieve expiration date from jwt token
  	public Date getExpirationDateFromToken(String token) {
  		System.out.println("inside getExpirationDateFromToken method");
  		return getClaimFromToken(token, Claims::getExpiration);
  	}
  	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
  		System.out.println("inside getClaimFromToken method");
  		final Claims claims = getAllClaimsFromToken(token);
  		return claimsResolver.apply(claims);
  	}
      //for retrieveing any information from token we will need the secret key
  	private Claims getAllClaimsFromToken(String token) {
  		System.out.println("inside getAllClaimsFromToken method");
  		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  	}
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    	System.out.println("inside extractClaim method");
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
    	System.out.println("inside extractAllClaims method");
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
    	System.out.println("inside isTokenExpired method");
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
    	System.out.println("inside generateToken method");
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
    	System.out.println("inside createToken method");
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
    	System.out.println("inside validateToken method");
    	final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
