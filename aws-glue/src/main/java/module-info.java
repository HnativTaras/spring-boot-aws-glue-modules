module com.taras.hnativ.jworld.aws.glue {
    requires software.amazon.awssdk.services.glue;
    requires software.amazon.awssdk.auth;
    requires software.amazon.awssdk.regions;

    requires spring.beans;
    requires spring.context;

    requires org.apache.logging.slf4j;
    requires org.slf4j;

    requires com.fasterxml.jackson.core;

    exports com.taras.hnativ.jworld.aws.glue.client;
    exports com.taras.hnativ.jworld.aws.glue.repository;

    opens com.taras.hnativ.jworld.aws.glue.client to spring.core, spring.beans, spring.context;
    opens com.taras.hnativ.jworld.aws.glue.repository to spring.core, spring.beans, spring.context;
    opens com.taras.hnativ.jworld.aws.glue.util to spring.core, spring.beans, spring.context;

}