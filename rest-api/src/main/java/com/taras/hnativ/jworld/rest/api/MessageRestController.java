package com.taras.hnativ.jworld.rest.api;

import com.taras.hnativ.jworld.aws.glue.repository.GlueRepository;
import com.taras.hnativ.jworld.domain.Message;
import com.taras.hnativ.jworld.domain.util.MessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    private static final Logger logger = LoggerFactory.getLogger(MessageRestController.class);

    @Autowired
    GlueRepository glueRepository;

    @PostMapping(value = "/save", consumes = "application/json")
    public boolean save(@RequestBody Message message) {
        logger.info("=== Glue Client save: " + message.getId());
        return glueRepository.save(MessageMapper.messageToMap(message));
    }
}
