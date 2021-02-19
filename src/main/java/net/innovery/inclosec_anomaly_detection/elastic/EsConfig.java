package net.innovery.inclosec_anomaly_detection.elastic;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.search.repository")
public class EsConfig {

@Value("${elasticsearch.clustername}")
private String EsClusterName;

@Bean
public Client esClient() throws UnknownHostException {
    Settings esSettings = Settings.builder()
            .put("cluster.name", EsClusterName)
            .put("client.transport.sniff", true)
            .put("client.transport.ignore_cluster_name", false)
            .build();


   TransportClient  client = new PreBuiltTransportClient(esSettings)
    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    return client;

}

@Bean
public ElasticsearchOperations elasticsearchTemplate() throws Exception{
    return new ElasticsearchTemplate(esClient()); 
  }
}