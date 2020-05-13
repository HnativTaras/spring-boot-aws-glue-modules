package com.taras.hnativ.jworld.aws.glue.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.glue.GlueClient;

@Component
public class GlueClientFactoryImpl implements GlueClientFactory{

    @Value("${profile.name}")
    private String profileName;
    @Value("${region.name}")
    private String regionName;


    @Override
    public GlueClient createClient() {
        return GlueClient.builder()
                .region(Region.of(regionName))
                .credentialsProvider(ProfileCredentialsProvider.create(profileName)).build();
    }
}
