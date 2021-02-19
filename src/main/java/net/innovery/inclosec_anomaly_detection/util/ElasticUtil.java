package net.innovery.inclosec_anomaly_detection.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service("elasticUtil")
public class ElasticUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

	// Request to ES for all operations from a userEmail
	public String getAverageBehavior(String userEmail) {
		
		LOGGER.warn("2. Scarico i dati dell'ultimo mese da ES");
		Object resultAverageBehavior = queryES(userEmail); 
		
		return "resultAverageBehavior = media1|media2|media3|media4|media5|media6";

	}

	// Request to ES for session operations from a sessionId
	public String getAverageSession(String sessionId) {

		LOGGER.warn("3. Scarico i dati della sessione da ES");
		Object resultAverageSession = queryES(sessionId);
		
		return "resultAverageSession = media1|media2|media3|media4|media5|media6";

	}

	private Object queryES(Object request) {

		LOGGER.warn("Query ES");

		return null;
	}
}
