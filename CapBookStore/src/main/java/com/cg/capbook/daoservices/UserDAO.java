package com.cg.capbook.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.CapBookUser;
import com.cg.capbook.beans.CapBookUser;

public interface UserDAO extends JpaRepository<CapBookUser, String>{

}
