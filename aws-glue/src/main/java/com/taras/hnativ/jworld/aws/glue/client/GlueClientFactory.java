package com.taras.hnativ.jworld.aws.glue.client;


import software.amazon.awssdk.services.glue.GlueClient;

public interface GlueClientFactory {
    GlueClient createClient();
}
