package it.reply.iriscube.unito.app.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.app.fragment.CompanyFragment

class CompanyActivity : AppCompatActivity(), CompanyFragment.OnCompanyFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)
        val profileFragment = CompanyFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, profileFragment, CompanyFragment.TAG).commit()
    }
}
