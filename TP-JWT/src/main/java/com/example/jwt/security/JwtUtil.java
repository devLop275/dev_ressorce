package com.example.jwt.security;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	public static final String SECRET_KEY = "zouani";
    public static final String ROLES_LABEL = "roles";
    public static final String HEADER_TOKEN_SUFFIX = "Bearer ";
    public static final String HTTP_AUTORISATION_HEADER = "Authorization";
    public static final String EMPTY_STRING = "";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10h

//	 private static String getToken(HttpServletRequest request) {
//		return request.getHeader(HTTP_AUTORISATION_HEADER);
//	}

    public static void generateTokenInHttpHeader(UserDetails userDetails, HttpServletResponse response) {
        String jwtToken = HEADER_TOKEN_SUFFIX + generateToken(userDetails);

        response.addHeader(HTTP_AUTORISATION_HEADER, jwtToken);
    }

    public static String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<String, Object>();
        List<String> roles = userDetails.getAuthorities().stream().map(a -> a.getAuthority())
                .collect(Collectors.toList());
        claims.put(ROLES_LABEL, roles);
        long issuedAt = System.currentTimeMillis();
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(issuedAt))
                .setExpiration(new Date(issuedAt + EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Claims getAllClaimsGeneratedToken(String token) {
        return getAllClaims(token.replace(HEADER_TOKEN_SUFFIX, EMPTY_STRING));
    }

    public static boolean valiateToken(String token, UserDetails userDetails) {
        return getUerName(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public static boolean validateToken(HttpServletRequest request) {
        String token = getToken(request);
        return (token != null && token.startsWith(HEADER_TOKEN_SUFFIX));
    }

    public static String getToken(HttpServletRequest request) {
        return request.getHeader(HTTP_AUTORISATION_HEADER);
    }

    public static Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    public static Boolean isTokenExpired(String token) {
        return getExpiration(token).after(new Date());
    }

    public static String getUerName(String token) {
        return getClaim(token, Claims::getSubject);
    }

    @SuppressWarnings("unchecked")
	public static List<String> getRoles(Claims claims) {
        return (List<String>) claims.get(ROLES_LABEL);
    }

    private static <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaims(token);

        return claimsResolver.apply(claims);
    }

    private static Claims getAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }


}
