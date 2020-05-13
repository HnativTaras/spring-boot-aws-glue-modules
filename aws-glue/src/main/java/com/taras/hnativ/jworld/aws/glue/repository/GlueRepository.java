package com.taras.hnativ.jworld.aws.glue.repository;



import java.util.Map;

/**
 * Custom Repository interface for Saving Map<String, String> arguments.
 */

public interface GlueRepository {
    boolean save(Map<String, String> arguments);
}
