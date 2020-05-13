package com.taras.hnativ.jworld.aws.glue.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.glue.GlueClient;

import java.util.Map;

public class GlueJobGenerator {
    private static final Logger logger = LoggerFactory.getLogger(GlueJobGenerator.class);

    public static boolean runGlueJob(GlueClient glueClient, String jobName, Map<String, String> glueArguments, Long glueSleepAmountInMs) {
        boolean isJobCompleted = false;

        String jobId = GlueService.runGlueJob(glueClient, jobName, glueArguments);

        logger.info("Job submitted, jobId: " + jobId + " CurrentTime: " + System.currentTimeMillis());

        try {
            GlueService.waitForJobToComplete(glueClient, jobName, jobId, glueSleepAmountInMs);
            isJobCompleted = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Job finished, jobId: " + jobId + " CurrentTime: " + System.currentTimeMillis());
        return isJobCompleted;
    }
}
