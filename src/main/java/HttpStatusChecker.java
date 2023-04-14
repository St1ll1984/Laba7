import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.HttpURLConnection;

public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/";
    private static final OkHttpClient client = new OkHttpClient();

    public static String getStatusImage(int code) throws IOException {
        String url = BASE_URL + code + ".jpg";
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
            throw new java.net.MalformedURLException("No image found for code " + code);
        }
        return url;
    }
}
