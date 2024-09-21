package GitCloner.service;

import GitCloner.model.ClonerModel;
import okhttp3.OkHttpClient;
import okhttp3.*;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class RepoCreator {
    
      public void repoCreator(ClonerModel exerepo) {
        System.out.println("RepoCreator is called");
        final String token = "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";

        OkHttpClient client = new OkHttpClient();
        String url = "https://api.github.com/user/repos";
        String json = "{\"name\":\"" + exerepo.getName() + "\", \"private\":false}";

        RequestBody body = RequestBody.create(json,
                MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", "token " + token)
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            System.out.println("Repository created successfully: " + exerepo.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
