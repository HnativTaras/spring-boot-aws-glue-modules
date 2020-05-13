package com.taras.hnativ.jworld.aws.glue.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.glue.GlueClient;
import software.amazon.awssdk.services.glue.model.*;

import java.util.Map;

@Component
public class GlueService {
    private static final Logger logger = LoggerFactory.getLogger(GlueService.class);

    public static String runGlueJob(GlueClient glueClient, String jobName, Map<String, String> glueArguments) {

        StartJobRunResponse response = glueClient.startJobRun(StartJobRunRequest.builder().jobName(jobName).arguments(glueArguments).build());
        String jobId = response.jobRunId();
        logger.info("JobId: " + jobId);

        return jobId;

    }

    public static void waitForJobToComplete(GlueClient glueClient, String jobName, String jobId, Long glueSleepAmountInMs) throws InterruptedException {

        boolean isJobStillRunning = true;

        while (isJobStillRunning) {
            GetJobRunResponse getJobRunResponse = glueClient.getJobRun(GetJobRunRequest.builder().jobName(jobName).runId(jobId).build());
            String jobState = getJobRunResponse.jobRun().jobRunStateAsString();

            if (jobState.equals(JobRunState.FAILED.toString())) {
                throw new RuntimeException("Job Failed to run with Error Message: " + getJobRunResponse.jobRun().errorMessage());
            } else if (jobState.equals(JobRunState.STOPPED.toString())) {
                throw new RuntimeException("Query was stopped.");
            } else if (jobState.equals(JobRunState.SUCCEEDED.toString())) {
                isJobStillRunning = false;
            } else {
                Thread.sleep(glueSleepAmountInMs);
            }

            logger.info("Current Status is: " + jobState);
        }
    }
}
