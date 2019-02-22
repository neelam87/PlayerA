package com.playerA.service;

public interface PlayerAService
{

	Integer getTheRandomNumber() throws Exception;
	Integer callThirdPartyService(Integer signal, String itecUrl) throws Exception;

	
}
