package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {

    protected static HttpURLConnection getConnection(String url)throws IOException {
        return (HttpURLConnection) new URL(url).openConnection();
    }

    public static boolean canConnect(String location) {
        try {
            HttpURLConnection connection = getConnection(location);
            int responseCode = connection.getResponseCode();
            return (responseCode >= 200 && responseCode < 400)? true : false;
        } catch (IOException e) {
            throw new RepositoryException("Not supported to connect to location:" + location, e);
        }
    }
}
