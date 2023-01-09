package com.liferay.gradle.plugins.workspace;

import com.bmuschko.gradle.docker.shaded.com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.bmuschko.gradle.docker.shaded.com.fasterxml.jackson.annotation.JsonGetter;
import com.bmuschko.gradle.docker.shaded.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.bmuschko.gradle.docker.shaded.com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonTester {
    public static void main(String args[]){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"rollNo\":1,\"names\":\"Marks\"}";

        try {
            Student student = mapper.readerFor(Student.class).readValue(jsonString);
            System.out.println(student.name);
            System.out.println(student.rollNo);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Student {
    public int rollNo;
    public String name;
    @JsonSetter("names")
    public void setAnyName(String name) {
        System.out.println("triggered");
        this.name = name;
    }
}