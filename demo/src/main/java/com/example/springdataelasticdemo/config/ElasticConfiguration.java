package com.example.springdataelasticdemo.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
        (basePackageClasses = {com.example.springdataelasticdemo.repository.UsersRepository.class})
public class ElasticConfiguration extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String elasticHost;

    @Value("${elasticsearch.port}")
    private int elasticPort;

    @Value("${elasticsearch.connectionTimeout}")
    private long connectionTimeout;


    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(String.format("%s:%s", elasticHost, elasticPort))
                .withConnectTimeout(connectionTimeout)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

}
