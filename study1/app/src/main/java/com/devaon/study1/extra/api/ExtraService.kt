package com.devaon.study1.extra.api


import com.devaon.study1.extra.data.ExtraPostSignUp
import com.devaon.study1.extra.data.ExtraPostSignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ExtraService {
    @POST("users/signup")
    fun postSignUp(
        @Body body : ExtraPostSignUp
    ) : Call<ExtraPostSignUpResponse>
}