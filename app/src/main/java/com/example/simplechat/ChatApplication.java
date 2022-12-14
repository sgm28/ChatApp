package com.example.simplechat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ChatApplication extends Application {
   @Override
   public void onCreate() {
      super.onCreate();
      ParseObject.registerSubclass(Message.class);

      // Use for monitoring Parse network traffic
      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
      // Can be Level.BASIC, Level.HEADERS, or Level.BODY
      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      // any network interceptors must be added with the Configuration Builder given this syntax
      builder.networkInterceptors().add(httpLoggingInterceptor);

      // Set applicationId and server based on the values in the Back4App settings.
      Parse.initialize(new Parse.Configuration.Builder(this)
              .applicationId("KHNfSXfeqT0cLYosevDcPnVhBf9d49e2odwQsTxz") // ⚠️ TYPE IN A VALID APPLICATION ID HERE
              .clientKey("Qb62OrqvWuoPOZpWnr7G4cArVxSZChzEn6uCpenU") // ⚠️ TYPE IN A VALID CLIENT KEY HERE
              .clientBuilder(builder)
              .server("https://parseapi.back4app.com").build());  // ⚠️ TYPE IN A VALID SERVER URL HERE
   }

}