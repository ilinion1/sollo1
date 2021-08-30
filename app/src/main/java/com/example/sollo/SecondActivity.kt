package com.example.sollo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.sollo.databinding.ActivitySecondBinding

class SecondActivity:AppCompatActivity() {
    lateinit var bindingClass : ActivitySecondBinding
    private var StateSecond = "empy"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        StateSecond = intent.getStringExtra(Constence.State)!!
        if (StateSecond == Constence.SingInState) {

            bindingClass.edName.visibility = View.GONE
            bindingClass.edName2.visibility = View.GONE
            bindingClass.edName3.visibility = View.GONE
            bindingClass.bAvatar.visibility = View.GONE

        }

    }

    fun onClickBack(view: View) {
        val intent = Intent()

        if (StateSecond == Constence.SingInState) {

            intent.putExtra(Constence.Login,bindingClass.edLogin.text.toString())
            intent.putExtra(Constence.Password,bindingClass.edPassword.text.toString())
            setResult(RESULT_OK,intent)
            finish()

        } else if(StateSecond == Constence.SingUpState) {

            intent.putExtra(Constence.Login,bindingClass.edLogin.text.toString())
            intent.putExtra(Constence.Password,bindingClass.edPassword.text.toString())
            intent.putExtra(Constence.Name,bindingClass.edName.text.toString())
            intent.putExtra(Constence.Name2,bindingClass.edName2.text.toString())
            intent.putExtra(Constence.Name3,bindingClass.edName3.text.toString())
            if(bindingClass.imSecond.isVisible) intent.putExtra(Constence.AvatarId,R.drawable.sergey)
            setResult(RESULT_OK,intent)
            finish()
        }
    }

    fun onClickAvatar(view: View) {

        bindingClass.imSecond.visibility = View.VISIBLE

    }

}


