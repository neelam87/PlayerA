package com.playerA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playerA.service.PlayerAService;

/**
 * All operations for playerA by this controller.
 * <p/>
 */
@RestController
@RequestMapping("game/playerA")
public class PlayerAController {

	private PlayerAService playerAService;

	@Autowired
	public PlayerAController(final PlayerAService playerAService) {
		this.playerAService = playerAService;
	}

	@GetMapping
	public Integer getDriver() throws Exception {
		return playerAService.getTheRandomNumber();
	}

	
}
