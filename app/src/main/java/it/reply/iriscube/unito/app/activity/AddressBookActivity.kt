package it.reply.iriscube.unito.app.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.app.adapter.PeopleAdapter
import it.reply.iriscube.unito.datasource.api.APIClient
import it.reply.iriscube.unito.datasource.api.APIInterface
import it.reply.iriscube.unito.datasource.api.Person
import kotlinx.android.synthetic.main.activity_address_book.*

/**
 * Created by Reply.
 */
class AddressBookActivity : AppCompatActivity(), PeopleAdapter.OnPersonSelectedListener {

    companion object {

        fun newIntent(
            context: Context
        ): Intent = Intent(context, AddressBookActivity::class.java)
    }

    private lateinit var mPeopleAdapter: PeopleAdapter

    private var mPersonList: List<Person>? = null

    private var mLoadAddressBookDisposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_address_book)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        mPeopleAdapter = PeopleAdapter()
        mPeopleAdapter.onPersonSelectedListener = this

        recyclerView.adapter = mPeopleAdapter

        loadAddressBook()
    }

    override fun onDestroy() {
        super.onDestroy()

        mLoadAddressBookDisposable?.apply {
            if (isDisposed) {
                return
            }
            dispose()
        }
    }

    override fun onPersonSelected(person: PeopleAdapter.PersonModel) {
        mPersonList?.firstOrNull { it.id == person.id }?.let {
            val personDetailIntent = PersonDetailActivity.newIntent(this, it)

            startActivity(personDetailIntent)
        }
    }

    private fun loadAddressBook() {
        onDataLoadingStarted()

        val apiInterface = APIClient.client.create(APIInterface::class.java)
        mLoadAddressBookDisposable = apiInterface.getAddressBook(1)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { userResponse ->
                    onDataLoaded()

                    mPersonList = userResponse.data
                    mPeopleAdapter.peopleList = userResponse.data.map {
                        PeopleAdapter.PersonModel(it.id, it.name, it.lastName, it.avatar)
                    }
                },
                { exception ->
                    Log.w("AddressBookActivity", "Because of an error we were not able to load the users.", exception)

                    onDataLoaded()
                }
            )
    }

    private fun onDataLoadingStarted() {
        progressBar.visibility = View.VISIBLE
    }

    private fun onDataLoaded() {
        progressBar.visibility = View.GONE
    }
}