package com.chaourad.prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaourad.prj.entites.Favorite;
import com.chaourad.prj.entites.Pharmacie;
import com.chaourad.prj.entites.User;
import com.chaourad.prj.repository.FavoriteRepository;

@RestController
@RequestMapping("/api/favorite")
@CrossOrigin
public class FavoriteController {

	
	@Autowired
   	FavoriteRepository favoriteRepository;
	
	
	
	
	
	
	
	
}
