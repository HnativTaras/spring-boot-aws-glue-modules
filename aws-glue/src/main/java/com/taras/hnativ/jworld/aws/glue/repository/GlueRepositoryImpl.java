package com.taras.hnativ.jworld.aws.glue.repository;


import com.taras.hnativ.jworld.aws.glue.client.GlueClientFactory;
import com.taras.hnativ.jworld.aws.glue.util.GlueJobGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.glue.GlueClient;

import java.util.Map;

@Repository
public class GlueRepositoryImpl implements GlueRepository {

    @Value("${glue.job.name}")
    private String glueJobName;


    @Value("${glue.sleep.amount.in.ms}")
    private long glueSleepAmountInMs;


    GlueClient glueClient;


    @Autowired
    public GlueRepositoryImpl(GlueClientFactory glueClientFactory) {
        glueClient = glueClientFactory.createClient();
    }


    @Override
    public boolean save(Map<String, String> arguments) {
        return GlueJobGenerator.runGlueJob(glueClient, glueJobName, arguments, glueSleepAmountInMs);
    }
}
