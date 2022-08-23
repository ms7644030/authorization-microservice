package com.authorizationService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestControllerAdvice
public class AuthorizationAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleException(RuntimeException e) {

		return new ResponseEntity<>("Invalid", HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException iae) {

		return new ResponseEntity<>("JWT claims string is empty", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnsupportedJwtException.class)
	public ResponseEntity<String> handleUnsupportedJwtException(UnsupportedJwtException unsupportedJwtException) {

		return new ResponseEntity<>("Unsupported Jwt token", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MalformedJwtException.class)
	public ResponseEntity<String> handleMalformedJwtException(MalformedJwtException malformedJwtException) {

		return new ResponseEntity<>("Invalid IWt token", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SignatureException.class)
	public ResponseEntity<String> handleSignatureException(SignatureException signatureException) {

		return new ResponseEntity<>("Invalid JWT signature", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<String> handleExpiredJwtException(ExpiredJwtException expiredJwtException) {

		return new ResponseEntity<>("JWT token expired", HttpStatus.BAD_REQUEST);
	}

}
