package it.reply.iriscube.unito.app.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.app.fragment.MainSectionFragment

class MainSectionActivity : AppCompatActivity(), MainSectionFragment.OnMainSectionFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_section)
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
        val intent = AddressBookActivity.newIntent(this)

        startActivity(intent)
    }
}
