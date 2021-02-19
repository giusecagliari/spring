package net.innovery.inclosec_anomaly_detection.elastic;

public interface ApartmentSearchRepository extends ElasticsearchRepository<Apartments, String> {
	List<Apartments> findByApartmentName(String apartmentName);
	}