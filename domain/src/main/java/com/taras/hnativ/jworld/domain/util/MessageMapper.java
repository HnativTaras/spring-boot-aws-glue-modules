package com.taras.hnativ.jworld.domain.util;


import com.taras.hnativ.jworld.domain.Message;

import java.util.HashMap;
import java.util.Map;

public class MessageMapper {

    public static Map<String, String> messageToMap(Message message) {
        Map<String, String> mapOfMessageProperties = new HashMap<>();

        mapOfMessageProperties.put("--mid", message.getId());
        mapOfMessageProperties.put("--mcontent", message.getContent());
        mapOfMessageProperties.put("--mdate_time", message.getDateTime());

        return mapOfMessageProperties;

    }

}
