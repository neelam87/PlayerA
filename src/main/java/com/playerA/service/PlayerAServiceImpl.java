/**
 * 
 */
package com.playerA.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * @author neelam
 *
 */
@Service
public class PlayerAServiceImpl implements PlayerAService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerAServiceImpl.class);

	private static final Random random = new Random();
	private static final int MAX = 10000;

	@Value("${player.url}")
	private String playerUrl;

	@Autowired
	private RestTemplate restTemplate;

	public PlayerAServiceImpl(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Integer getTheRandomNumber() throws Exception {
		int n = random.nextInt(MAX) + 1;
		return callThirdPartyService(n, playerUrl);
	}

	@Override
	public Integer callThirdPartyService(Integer number, String playerUrl) throws Exception {
		Integer responseEntity = null;
		try {
			do {
				responseEntity = restTemplate.getForObject(playerUrl + "?number=" + number, Integer.class);
				number = responseEntity;
				if (number == 1) {
					LOGGER.info("PLAYER A WINS");
				}
			} while (number != 1);
		} catch (ResourceAccessException ex) {
			LOGGER.error("OTHER PLAYER IS NOT AVAILABLE, PLEASE TRY WHEN ITS AVAILABLE");
		}
		return responseEntity;
	}

}
