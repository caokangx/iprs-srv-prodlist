package edu.nju.iip.iprs.elasticsearch;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientConfig {

    @Value("${elasticsearch.hostname}")
    private String hostname;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.index}")
    private String index;

    public String getIndex() {
        return index;
    }

    @Bean
    public RestHighLevelClient restHighLevelClient() {

        return new RestHighLevelClient(RestClient.builder(new HttpHost(hostname, port, "http")));
    }

}
