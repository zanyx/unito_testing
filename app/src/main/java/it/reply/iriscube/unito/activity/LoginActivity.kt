package it.reply.iriscube.unito.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.fragment.LoginFragment


class LoginActivity : AppCompatActivity(), LoginFragment.OnFirstPageFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val firstPageFragment: LoginFragment = LoginFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, firstPageFragment, LoginFragment.TAG).commit()
    }

    override fun onLoginButtonPressed(username: String) {
        val intent = Intent(this, WelcomeActivity::class.java)
        intent.putExtra(USERNAME, username)
        startActivity(intent)
    }

    companion object {
        val USERNAME = "USERNAME"
    }
}
