module com.taras.hnativ.jworld.rest.api {
    requires spring.web;
    requires spring.beans;

    requires org.apache.logging.slf4j;
    requires org.slf4j;

    requires com.taras.hnativ.jworld.aws.glue;
    requires com.taras.hnativ.jworld.domain;

    exports com.taras.hnativ.jworld.rest.api;

    opens com.taras.hnativ.jworld.rest.api to spring.core, spring.beans, spring.context;
    requires com.fasterxml.classmate;
}