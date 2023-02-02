package com.example.museumApp.service;

import com.example.museumApp.model.Artist;
import com.example.museumApp.model.Painting;
import com.example.museumApp.model.WikiArtPainting;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@Component
public class WikiArtPaintingRetrieval
{
    private static final String BASE_URI = "https://www.wikiart.org/en/api/2/PaintingSearch?term=";
    private static final HttpClient CLIENT = HttpClient
            .newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public List<WikiArtPainting> getPaintingsFor(Artist artist)
    {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(BASE_URI + artist.getArtistUrl()))
                .GET()
                .build();

        try
        {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            if (statusCode == 200)
                return toPaintings(response);
            else if (statusCode == 404)
                return List.of();
            else
                throw new RuntimeException("API call failed");

        }
        catch (IOException | InterruptedException e)
        {
            throw new RuntimeException("Could not call API", e);
        }
    }

    private static List<WikiArtPainting> toPaintings(HttpResponse<String> response) throws JsonProcessingException
    {
        String trimmedBody  = "[" + response.body().split("\\[")[1].split("\\]")[0] + "]";
        JavaType returnType = OBJECT_MAPPER.getTypeFactory()
                .constructCollectionType(List.class, WikiArtPainting.class);
        return  OBJECT_MAPPER.readValue(trimmedBody, returnType);

    }
}
