package com.demo.starter;

import com.demo.starter.api.DemoApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Will Liu
 * @date 2022/1/11
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(
        prefix = "demo",
        name = "open",
        havingValue = "true"
)
public class DemoClientConfiguration {

    @Bean
    public Retrofit okHttpClient(DemoProperties properties) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(properties.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(properties.getReadTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(properties.getWriteTimeout(), TimeUnit.MILLISECONDS)
                .build();

        Gson gson = new GsonBuilder().setLenient().create();

        String host = properties.getHost();
        String port = properties.getPort();
        String url = host.startsWith("http://") ? (host + ":" + port) : ("http://" + host + ":" + port);

        // 初始化Retrofit
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .validateEagerly(false)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(new DemoAdapterFactory())
                .build();
    }

    @Bean
    public DemoApi demoApi(Retrofit retrofit) {
        return retrofit.create(DemoApi.class);
    }


}
