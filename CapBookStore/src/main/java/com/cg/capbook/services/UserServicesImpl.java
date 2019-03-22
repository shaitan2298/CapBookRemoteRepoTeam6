package com.cg.capbook.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.beans.CapBookUser;
import com.cg.capbook.daoservices.UserDAO;
import com.cg.capbook.exceptions.IncorrectAnswerException;
import com.cg.capbook.exceptions.IncorrectPasswordException;
import com.cg.capbook.exceptions.IncorrectUsernameException;
import com.cg.capbook.exceptions.NewPasswordSimilarToOldException;
import com.cg.capbook.exceptions.PasswordMismatchException;

@Component("userServices")
public class UserServicesImpl implements UserServices
{
	@Autowired
	UserDAO userDAO;

	@Override
	public CapBookUser acceptUserDetails(CapBookUser user) {

		String password = user.getPassword();
		user.setPassword(this.encryptLogic(password));

		String securityAnswer = user.getSecurityAnswer();
		user.setSecurityAnswer(this.encryptLogic(securityAnswer));

		user = userDAO.save(user);
		return user;
	}

	public String encryptLogic(String stringToEncrypt) {
		StringBuffer encryptedBuffer = new StringBuffer();

		for(int i=0;i<stringToEncrypt.length();i++) {
			encryptedBuffer.append((int)stringToEncrypt.charAt(i)+2);
		}
		String encryptedString = (encryptedBuffer.reverse()).toString();
		return encryptedString;
	}

	@Override
	public CapBookUser checkPassword(String email, String password) throws IncorrectPasswordException, IncorrectUsernameException {
		CapBookUser user = this.getUserDetails(email);
		if(user.getPassword().equals(encryptLogic(password)))
			return user;
		else
			throw new IncorrectPasswordException("Incorrect Password");
	}

	@Override
	public CapBookUser loginUser(CapBookUser user) throws IncorrectPasswordException, IncorrectUsernameException {
		if(this.checkPassword(user.getEmail(), user.getPassword()).equals(null)) {
			throw new IncorrectUsernameException("Incorrect Userame in login");
		}
		return this.getUserDetails(user.getEmail());
	}

	@Override
	public CapBookUser forgetPassword(String email) throws IncorrectUsernameException {
		return this.getUserDetails(email);
	}

	@Override
	public CapBookUser getUserDetails(String email) throws IncorrectUsernameException {
		return userDAO.findById(email).orElseThrow(()->new IncorrectUsernameException("Incorrect Username"));
	}

	@Override
	public boolean checkSecurityAnswer(String email1, String securityAnswer) throws IncorrectAnswerException, IncorrectUsernameException {
		CapBookUser user = this.getUserDetails(email1);
		if(user.getSecurityAnswer().equalsIgnoreCase(encryptLogic(securityAnswer))) {
			return true;
		}
		throw new IncorrectAnswerException("Your Answer Is Not Correct");
	}

	@Override
	public boolean changeForgettedPassword(String email1,String newPassword, String confirmPassword) throws PasswordMismatchException, IncorrectUsernameException {
		CapBookUser user = this.getUserDetails(email1);
		if(!newPassword.equals(confirmPassword))
			throw new PasswordMismatchException("Password Mismatch");
		user.setPassword(encryptLogic(confirmPassword));
		userDAO.save(user);
		return true;
	}

	@Override
	public boolean setNewPassword(String email, String oldPassword, String newPassword, String confirmPassword) throws IncorrectUsernameException, PasswordMismatchException, NewPasswordSimilarToOldException {
		CapBookUser user = this.getUserDetails(email);

		if(!encryptLogic(oldPassword).equals(user.getPassword())) {
			
			throw new PasswordMismatchException("Password Mismatch");
		}
		if(encryptLogic(newPassword).equals(encryptLogic(oldPassword))) {
			
			throw new NewPasswordSimilarToOldException("New Password Should'nt match old passowrd");
		}
		if(!newPassword.equals(confirmPassword) ) {
			throw new PasswordMismatchException("Password Mismatch");
		}
			user.setPassword(encryptLogic(confirmPassword));
			userDAO.save(user);
			return true;
		}

	@Override
	public void saveImage(MultipartFile imageFile) throws IOException {
		String folder = "/photos/";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + imageFile.getOriginalFilename());
		Files.write(path,bytes);
		
	}
	}