package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import implementations.SupportedRepository;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Util {

    public static SupportedRepository getRepositoriesSupportedData(String nodeName) throws RepositoryException {
        URL path = ClassLoader.getSystemClassLoader().getResource("./supported_repositories_types.json");
        JsonParser jsonParser = null;
        try {
            jsonParser = new JsonFactory().createParser(new File(path.getPath()));
            ObjectMapper mapper = new ObjectMapper(new JsonFactory());
            MappingIterator<JsonNode> rootNode = mapper.readValues(jsonParser, JsonNode.class);

            if(rootNode.hasNext()){
                for (JsonNode node : rootNode.next().findValues(nodeName)) {
                    jsonParser = new JsonFactory().createParser(node.toString());

                    MappingIterator<SupportedRepository> supportedRepositories = mapper.readValues(jsonParser, SupportedRepository.class);
                    return supportedRepositories.hasNext() ? supportedRepositories.next() : null;
                }
            }
        } catch (IOException e) {
            throw new RepositoryException("Couldn't load repository", e);
        }
        return null;
   }

}
