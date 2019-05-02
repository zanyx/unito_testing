package it.reply.iriscube.unito.datasource.api

import android.util.Log
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.mock.BehaviorDelegate

/**
 * Created by Reply.
 */
interface APIInterface {

    @GET("api/errorExample")
    fun errorExample(): Single<Int>

    @GET("api/getLabels")
    fun getLabels(): Single<ResponseBody>

    @GET("api/users")
    fun getAddressBook(@Query("page") page: Long): Single<ListUsersApiResponse>
}

class MockAPIInterface(val behaviorDelegate: BehaviorDelegate<APIInterface>) : APIInterface {

    override fun errorExample(): Single<Int> {
        val response = Response.error<Int>(404, ResponseBody.create(null, ""))
        return behaviorDelegate.returningResponse(response).errorExample()
    }

    override fun getLabels(): Single<ResponseBody> {
        val bodyResponse =
            "{\"labels\":[{\"idLabel\":\"userNameLabel\",\"value\":\"Nome utente\"},{\"idLabel\":\"passwordLabel\",\"value\":\"Password utente\"},{\"idLabel\":\"pippo\",\"value\":\"Pippo\"}]}"
        Log.d("getLabels", bodyResponse)
        val response =
            Response.success(200, ResponseBody.create(MediaType.parse("application/json"), bodyResponse.toByteArray()))
        Log.d("getLabels", response.body().toString())
        return behaviorDelegate.returningResponse(response.body()).getLabels()
    }

    override fun getAddressBook(page: Long): Single<ListUsersApiResponse> {
        val bodyResponse = """
            {
                "page": $page,
                "per_page": 3,
                "total": 3,
                "total_pages": 1,
                "data": [
                    {
                        "id": 4,
                        "first_name": "Eve",
                        "last_name": "Holt",
                        "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"
                    },
                    {
                        "id": 5,
                        "first_name": "Charles",
                        "last_name": "Morris",
                        "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"
                    },
                    {
                        "id": 6,
                        "first_name": "Tracey",
                        "last_name": "Ramos",
                        "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"
                    }
                ]
            }
        """.trimIndent()
        val response = Response.success(
            200,
            ResponseBody.create(
                MediaType.get("application/json"),
                bodyResponse.toByteArray()
            )
        )
        return behaviorDelegate.returningResponse(response).getAddressBook(page)
    }
}