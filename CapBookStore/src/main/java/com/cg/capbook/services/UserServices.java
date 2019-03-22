package com.cg.capbook.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.beans.CapBookUser;
import com.cg.capbook.exceptions.IncorrectAnswerException;
import com.cg.capbook.exceptions.IncorrectPasswordException;
import com.cg.capbook.exceptions.IncorrectUsernameException;
import com.cg.capbook.exceptions.NewPasswordSimilarToOldException;
import com.cg.capbook.exceptions.PasswordMismatchException;

public interface UserServices 
{
    public CapBookUser acceptUserDetails(CapBookUser user);
    public CapBookUser loginUser(CapBookUser user) throws IncorrectPasswordException,IncorrectUsernameException;
    public CapBookUser checkPassword(String email,String password) throws IncorrectPasswordException,IncorrectUsernameException;
    public CapBookUser forgetPassword(String email) throws IncorrectUsernameException;
    public CapBookUser getUserDetails(String email) throws IncorrectUsernameException;
    public boolean checkSecurityAnswer(String email1, String securityAnswer)throws IncorrectAnswerException,IncorrectUsernameException;
    public boolean changeForgettedPassword(String email1,String newPassword, String confirmPassword) throws PasswordMismatchException,IncorrectUsernameException;
    public boolean setNewPassword(String email,String oldPassword,  String newPassword, String confirmPassword)throws IncorrectUsernameException, PasswordMismatchException, NewPasswordSimilarToOldException;
	public void saveImage(MultipartFile imageFile) throws IOException;
}
