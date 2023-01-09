package com.liferay.gradle.plugins.workspace;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.liferay.gradle.plugins.workspace.internal.client.extension.ClientExtension;
import org.gradle.api.GradleException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Simple {

    public static void main(String[] args) throws Exception {
        File projectDir = new File(
            "/opt/dev/projects/github/liferay-portal/workspaces/jethr0-workspace");
        File clientExtensionFile = new File(
            projectDir,
            "client-extensions/build-queue-api/client-extension.yaml");

        try (FileReader fileReader = new FileReader(clientExtensionFile)) {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

            JsonNode rootJsonNode = objectMapper.readTree(clientExtensionFile);

            Iterator<Map.Entry<String, JsonNode>> iterator =
                rootJsonNode.fields();

            iterator.forEachRemaining(
                entry -> {
                    String key = entry.getKey();

                    if (Objects.equals("assemble", key)) {
                        return;
                    }

                    System.out.println("=====================================");
                    System.out.println(entry.getKey());
                    System.out.println("-------------------------------------");

                    JsonNode jsonNode = entry.getValue();

                    System.out.println(jsonNode);

                    try {
                        ClientExtension clientExtension =
                            objectMapper.treeToValue(
                                jsonNode, ClientExtension.class);

                        System.out.println(clientExtension);
                        System.out.println("id=" + clientExtension.id);
                        System.out.println("type=" + clientExtension.type);
                        System.out.println(
                            "projectName=" + clientExtension.projectName);
                        System.out.println(
                            "description=" + clientExtension.description);
                        System.out.println("name=" + clientExtension.name);
                        System.out.println(
                            "sourceCodeURL=" + clientExtension.sourceCodeURL);
                        System.out.println(
                            "properties=" + clientExtension.properties);
                        System.out.println(
                            "-------------------------------------");

                        Map<String, Object> jsonMap =
                            clientExtension.toJSONMap();

                        for  (Map.Entry<String, Object> json :
                                jsonMap.entrySet()) {

                            System.out.println(json.getKey());

                            Map<String, Object> configMap =
                                (Map<String, Object>)json.getValue();

                            for (Map.Entry<String, Object> config :
                                    configMap.entrySet()) {

                                System.out.println("\t" + config);
                            }
                        }
                    }
                    catch (Exception exception) {
                        throw new GradleException(
                            "Failed to parse client-extension " + key,
                            exception);
                    }
                });
        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

}
