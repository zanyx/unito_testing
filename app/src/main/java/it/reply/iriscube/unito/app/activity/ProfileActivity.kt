package it.reply.iriscube.unito.app.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.app.fragment.ProfileFragment

class ProfileActivity : AppCompatActivity(), ProfileFragment.OnProfileFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val profileFragment = ProfileFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, profileFragment, ProfileFragment.TAG).commit()
    }
}
