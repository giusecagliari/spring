package net.innovery.inclosec_anomaly_detection.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.innovery.inclosec_anomaly_detection.entity.SessionEntity;
import net.innovery.inclosec_anomaly_detection.util.ElasticUtil;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/analyzeSession")
public class AnalyzerController {
	
	@Autowired
	private ElasticUtil elasticUtil;

	private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

	@RequestMapping(method = RequestMethod.POST)
	public void analyzeSession(@Valid @RequestBody final SessionEntity userSession) {

		String sessionId = userSession.getSessionId();
		String userEmail = userSession.getUserEmail();
		
		

		LOGGER.warn("1. Sessione ricevuta: " + sessionId + " | " + userEmail);

		// Richiamo i dati del mese per l'utente
		String resultAverageBehavior = averageCalculator(elasticUtil.getAverageBehavior(userEmail));
		
		
		// Richiamo i dati della sessione per l'utente
		String resultAverageSession = averageCalculator(elasticUtil.getAverageSession(sessionId));
		
		
		// Comparazione dei dati
		LOGGER.warn("4. Comparazione dei dati");
		
		
		//Salvataggio del risultato
		LOGGER.warn("5. Output del risultato");
	}

	private String averageCalculator(Object queryResult) {

		LOGGER.warn("Calcolo la media in base ai dati di ES");
		return null;

	}

}
