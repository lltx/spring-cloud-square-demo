package com.pig4cloud.square.consumer.config;

import org.springframework.context.annotation.Configuration;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * 原始类型返回的 处理器，去掉默认的 Call
 *
 * @author L.cm
 */
@Configuration(proxyBeanMethods = false)
public class ApiCallAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get(@Nonnull Type returnType,
                                 @Nonnull Annotation[] annotations,
                                 @Nonnull Retrofit retrofit) {
        return new CallAdapter<>() {
            @Override
            public Type responseType() {
                return returnType;
            }

            @Override
            public Object adapt(@Nonnull Call<Object> call) {
                try {
                    return call.execute().body();
                } catch (IOException e) {
                    // 自定义fallback、或者直接抛出给全局异常处理
                    return null;
                }
            }
        };
    }

}