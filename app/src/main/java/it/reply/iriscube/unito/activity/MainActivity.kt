package it.reply.iriscube.unito.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.fragment.*

class MainActivity : AppCompatActivity(), FirstPageFragment.OnFirstPageFragmentInteractionListener,
    SecondPageFragment.OnSecondPageFragmentInteractionListener,
    MainSectionFragment.OnMainSectionFragmentInteractionListener,
    CompanyFragment.OnCompanyFragmentInteractionListener, ProfileFragment.OnProfileFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstPageFragment: FirstPageFragment = FirstPageFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, firstPageFragment, FirstPageFragment.TAG).commit()
    }

    override fun onLoginButtonPressed(username: String) {
        val secondPageFragment = SecondPageFragment.newInstance(username)
        supportFragmentManager.beginTransaction().add(R.id.container, secondPageFragment, SecondPageFragment.TAG)
            .commit()
    }

    override fun removeFragment(tag: String) {
        val f = supportFragmentManager.findFragmentByTag(tag)
        f.let {
            supportFragmentManager.beginTransaction().remove(it!!).commit()
        }
    }

    override fun goToMainSection() {
        val mainSectionFragment = MainSectionFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, mainSectionFragment, MainSectionFragment.TAG)
            .commit()
    }

    override fun goToProfile() {
        val profileFragment = ProfileFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, profileFragment, ProfileFragment.TAG).commit()
    }

    override fun goToCompany() {
        val companyFragment = CompanyFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, companyFragment, CompanyFragment.TAG).commit()
    }

    override fun goToAddressBook() {
        Toast.makeText(this, getString(R.string.section_not_available), Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.size > 1) {
            val f = supportFragmentManager.fragments.last()
            supportFragmentManager.beginTransaction().remove(f).commit()
        } else {
            this.finish()
        }
    }
}
