package com.example.sollo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.sollo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
      lateinit var bindingClass : ActivityMainBinding
      private var Login = "empty"
      private var Password = "empty"
      private var Name = "empty"
      private var Name2 = "empty"
      private var Name3 = "empty"
      private var imMainAvatar = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constence.RequestCodeSingIn ){

            val l = data?.getStringExtra(Constence.Login)
            val p = data?.getStringExtra(Constence.Password)

            if(l == Login && p == Password) {

                val name123 = "${Name} ${Name2} ${Name3}"
                bindingClass.imMain.visibility = View.VISIBLE
                bindingClass.imMain.setImageResource(imMainAvatar)
                bindingClass.tMain.text = name123
                bindingClass.bUp.visibility = View.GONE
                bindingClass.bIn.text = "Выйти"
            } else {

                bindingClass.imMain.visibility = View.VISIBLE
                bindingClass.tMain.text = "Нет такого аккаунта"
                bindingClass.imMain.setImageResource(R.drawable.dula)

            }

        } else if(requestCode == Constence.RequestCodeSingUp) {

            Login = data?.getStringExtra(Constence.Login)!!
            Password = data.getStringExtra(Constence.Password)!!
            Name = data.getStringExtra(Constence.Name)!!
            Name2 = data.getStringExtra(Constence.Name2)!!
            Name3 = data.getStringExtra(Constence.Name3)!!
            imMainAvatar = data.getIntExtra(Constence.AvatarId, 0 )
            val name123 = "${Name} ${Name2} ${Name3}"

            bindingClass.imMain.visibility = View.VISIBLE
            bindingClass.imMain.setImageResource(imMainAvatar)
            bindingClass.tMain.text = name123
            bindingClass.bUp.visibility = View.GONE
            bindingClass.bIn.text = "Выйти"

        }

    }

    fun onClickSingIn(view: View) {
        if (bindingClass.tMain.text.toString() != "Нет такого аккаунта" && bindingClass.imMain.isVisible ) {

            bindingClass.imMain.visibility = View.INVISIBLE
            bindingClass.bIn.text = getString(R.string.singIn)
            bindingClass.bUp.visibility = View.VISIBLE
            bindingClass.tMain.text = ""

        } else {

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constence.State, Constence.SingInState)
            startActivityForResult(intent, Constence.RequestCodeSingIn)
        }

    }


    fun onClickSingUp(view: View) {

        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra(Constence.State,Constence.SingUpState)
        startActivityForResult(intent,Constence.RequestCodeSingUp)

    }
}