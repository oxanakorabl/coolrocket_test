package com.coolrocket.charttest.dagger

import com.coolrocket.charttest.api.Api
import com.coolrocket.charttest.api.Response
import com.coolrocket.charttest.api.ResponseDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.*
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApi(gson: Gson, okHttpClient: OkHttpClient): Api {
        return Retrofit.Builder()
            .baseUrl("https://demo.bankplus.ru/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(Api::class.java)
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
             .registerTypeAdapter(Response::class.java, ResponseDeserializer())
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z")
            .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.acceptNotTrustedCertificates()
        builder.connectionSpecs(listOf(ConnectionSpec.COMPATIBLE_TLS));

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        builder.addNetworkInterceptor(logging)

        return builder.build()
    }

    private fun OkHttpClient.Builder.acceptNotTrustedCertificates() {

        // Create a trust manager that does not validate certificate chains
        val trustManager = object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<X509Certificate>? {
                return arrayOf()
            }

            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
            }
        }

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf(trustManager), java.security.SecureRandom())
        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.socketFactory
        sslSocketFactory(sslSocketFactory, trustManager)
        hostnameVerifier(HostnameVerifier { _, _ -> true })
    }
}


