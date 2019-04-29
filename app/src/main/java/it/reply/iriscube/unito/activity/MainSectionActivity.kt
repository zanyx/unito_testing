package it.reply.iriscube.unito.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.fragment.MainSectionFragment

class MainSectionActivity : AppCompatActivity(), MainSectionFragment.OnMainSectionFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_section)
        val mainSectionFragment: MainSectionFragment = MainSectionFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, mainSectionFragment, MainSectionFragment.TAG)
            .commit()
    }

    override fun goToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    override fun goToCompany() {
        val intent = Intent(this, CompanyActivity::class.java)
        startActivity(intent)
    }

    override fun goToAddressBook() {
        Toast.makeText(this, getString(R.string.section_not_available), Toast.LENGTH_LONG).show()
    }
}
