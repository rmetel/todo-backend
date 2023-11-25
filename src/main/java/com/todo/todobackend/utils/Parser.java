package com.todo.todobackend.utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static String parseTag(String tagName, String content) {
        String tagValue = "";
        final Pattern pattern = Pattern.compile(String.format("<%s>(.+?)</%s>", tagName, tagName), Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(content);

        if(matcher.find()){
            tagValue = matcher.group(1);
        }

        return tagValue;
    }
}
