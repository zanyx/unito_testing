package it.reply.iriscube.unito.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.activity.LoginActivity.Companion.USERNAME
import it.reply.iriscube.unito.fragment.LoginFragment
import it.reply.iriscube.unito.fragment.WelcomeFragment

class WelcomeActivity : AppCompatActivity(), WelcomeFragment.OnWelcomeFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val username = intent.getStringExtra(USERNAME)
        val welcomeFragment: WelcomeFragment = WelcomeFragment.newInstance(username)
        supportFragmentManager.beginTransaction().add(R.id.container, welcomeFragment, WelcomeFragment.TAG).commit()
    }

    override fun logout() {
        finish()
    }

    override fun goToMainSection() {
        val intent = Intent(this, MainSectionActivity::class.java)
        startActivity(intent)
    }
}
