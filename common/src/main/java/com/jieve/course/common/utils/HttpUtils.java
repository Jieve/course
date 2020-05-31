package com.jieve.course.common.utils;
import	java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import static java.util.Optional.ofNullable;

/**
 * @author Jieve
 */
@Slf4j
public class HttpUtils {

    /**
     * GET请求
     * @param url
     * @return
     */
    public static final String get(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            log.error("http get error! url:[{}], e[{}]", url, e.getMessage());
        }
        AtomicReference<String> result = new AtomicReference<>();
        ofNullable(response).ifPresent(value -> {
            if (!value.isSuccessful() || Objects.isNull(value.body())) {
                log.error("server error: " + value);
                return;
            }
            try {
                result.set(value.body().string());
            } catch (IOException e) {
                log.error("http body parse error: " + value.body());
            }
        });
        return result.get();
    }

    /**
     * POST请求
     * @param url
     * @param headers
     * @param params
     * @return
     */
    public static final String post(String url, Map<String, String> headers, Map<String, String> params) {
        OkHttpClient client = new OkHttpClient();
        Headers.Builder headerBuilder = new Headers.Builder();
        ofNullable(headers).ifPresent(value -> {
            value.forEach(headerBuilder::set);
        });
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        ofNullable(params).ifPresent(value -> {
            value.forEach(bodyBuilder::add);
        });

        Request request = new Request.Builder().url(url).headers(headerBuilder.build()).post(bodyBuilder.build()).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            log.error("http get error! url:[{}], e[{}]", url, e.getMessage());
        }
        AtomicReference<String> result = new AtomicReference<>();
        ofNullable(response).ifPresent(value -> {
            if (!value.isSuccessful() || Objects.isNull(value.body())) {
                log.error("server error: " + value);
                return;
            }
            try {
                result.set(value.body().string());
            } catch (IOException e) {
                log.error("http body parse error: " + value.body());
            }
        });
        return result.get();
    }
}
