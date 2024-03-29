package com.iist.hrm.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.iist.hrm.dto.RoleDto;
import com.iist.hrm.model.Token;
import com.iist.hrm.repository.TokenRepository;
import com.iist.hrm.service.AccountService;
import com.iist.hrm.utils.Constants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value("${security.jwt.token.secret-key}")
	private String secretKey = "secret";
	@Value("${security.jwt.token.expired-time}")
	private long expiredTime = 3600000;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TokenRepository tokenRepository;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public String createToken(String username, Set<RoleDto> roles, Date validateTime) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("roles", roles);
		Date now = new Date();
		return Jwts.builder()
					.setClaims(claims)
					.setIssuedAt(now)
					.setExpiration(validateTime)
					.signWith(SignatureAlgorithm.HS256, secretKey)
					.compact();
	}

	public Claims getClaimsFromToken(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token).getBody();
	}

	public Authentication getAuthentication(String token) {
		UserDetails userDetails = accountService.getAccountInfo(getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader(Constants.AUTHORIZATION_STRING);
		if (!StringUtils.isEmpty(bearerToken) && bearerToken.startsWith(Constants.TOKEN_PREFIX)) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

	public boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			Token tokenDb = tokenRepository.findByToken(token);
			if (claims.getBody().getExpiration().before(new Date()) || tokenDb == null || !tokenDb.isActive() ) {
				return false;
			}
			return true;
		} catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
		return false;
	}

}
