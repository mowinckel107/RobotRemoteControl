package com.example.robotremotecontrol.PROTODirectControlActivity

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json




const val baseURL = "https://eo1r4mb9juox274.m.pipedream.net"
// const val baseURL = "proto.local"

// Data classes

@kotlinx.serialization.Serializable
data class PROTOTOdometry(
    @SerialName("PositionX") val PositionX: Double,
    @SerialName("PositionY") val PositionY: Double,
    @SerialName("PositionZ") val PositionZ: Double,
    @SerialName("OrientationW") val OrientationW: Double,
    @SerialName("OrientationX") val OrientationX: Double,
    @SerialName("OrientationY") val OrientationY: Double,
    @SerialName("OrientationZ") val OrientationZ: Double
)

@kotlinx.serialization.Serializable
data class PROTOTwist(
    @SerialName("LinearX") val LinearX: Double,
    @SerialName("LinearY") val LinearY: Double,
    @SerialName("LinearZ") val LinearZ: Double,
    @SerialName("AngularX") val AngularX: Double,
    @SerialName("AngularY") val AngularY: Double,
    @SerialName("AngularZ") val AngularZ: Double
)


// interfaces

interface PROTOServiceInterface {
    suspend fun sendTwist(twist : PROTOTwist)
    suspend fun getOdometry() : PROTOTOdometry
}

// Implementation

class PROTOService : PROTOServiceInterface{
    // Set up a client
    private val client = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }

    fun close() {
        client.close()
    }

    override suspend fun sendTwist(twist : PROTOTwist)
    {
        try {
            client.put() {
                url("$baseURL/twist")
                setBody(twist)
            }
        }
        catch (e: Exception) {
            Log.v("SendTwist", e.toString())
            Log.v("SendTwist", e.stackTraceToString())
            Log.v("SendTwist", e::class.qualifiedName.toString())
        }
    }

    override suspend fun getOdometry(): PROTOTOdometry
    {
        return try {
            client.get() {
                url("$baseURL/odometry")
            }.body()
        }
        catch (e: Exception) {
            Log.v("GetOdometry", e.toString())
            Log.v("GetOdometry", e.stackTraceToString())
            Log.v("GetOdometry", e::class.qualifiedName.toString())
            PROTOTOdometry(0.0,0.0,0.0,0.0,0.0,0.0,0.0)
        }
    }
}
