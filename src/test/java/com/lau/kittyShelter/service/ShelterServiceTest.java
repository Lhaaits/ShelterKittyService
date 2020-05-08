package com.lau.kittyShelter.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ShelterServiceTest {

    private ShelterService shelterService = new ShelterService();

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testShelterService(){
        String html = readLineByLineJava8("./src/test.resources/shelterResponse1Kitty.html");
        when(restTemplate.getForObject(anyString(), any())).thenReturn(html);

         boolean result = shelterService.isThereNewKittiesYet();

        assertEquals(true, result);
    }

    private static String readLineByLineJava8(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
