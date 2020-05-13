module com.taras.hnativ.jworld.application {
    requires com.taras.hnativ.jworld.domain;
    requires com.taras.hnativ.jworld.aws.glue;
    requires com.taras.hnativ.jworld.rest.api;

    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.beans;
    requires spring.context;

    opens com.taras.hnativ.jworld  to spring.core, spring.beans, spring.context;
}