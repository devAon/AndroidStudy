package com.devaon.study1.extra.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.devaon.study1.R
import com.devaon.study1.extra.api.ExtraServiceImpl
import com.devaon.study1.extra.data.ExtraPostSignUp
import com.devaon.study1.extra.data.ExtraPostSignUpResponse

import kotlinx.android.synthetic.main.activity_extra.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExtraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra)

        extra_btn_signup.setOnClickListener{
            val body = ExtraPostSignUp(extra_edit_id.text.toString(),
                extra_edit_pwd.text.toString(),
                extra_edit_phone.text.toString(),
                extra_edit_name.text.toString())

            val call = ExtraServiceImpl.service.postSignUp(body)

            call.enqueue(object : Callback<ExtraPostSignUpResponse>{
                override fun onFailure(call: Call<ExtraPostSignUpResponse>, t: Throwable) {
                    Toast.makeText(this@ExtraActivity, "인터넷 연결 불량", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ExtraPostSignUpResponse>,
                    response: Response<ExtraPostSignUpResponse>
                ) {
                    if(response.isSuccessful){
                        Toast.makeText(this@ExtraActivity, "회원가입 완료", Toast.LENGTH_SHORT).show()

                        //정말 post맨에서 받아온 변수를 잘 맞게 받아왔는지 확인할 것 -> Log.v
                        Log.v("Extra", response.body()?.message)


                    }else{
                        Toast.makeText(this@ExtraActivity, "회원가입 실패", Toast.LENGTH_SHORT).show()

                    }
                }

            })
        }
    }
}
