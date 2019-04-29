package it.reply.iriscube.unito.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import it.reply.iriscube.unito.R
import kotlinx.android.synthetic.main.login_fragment.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LoginFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LoginFragment : Fragment(), View.OnFocusChangeListener {

    private var listener: OnFirstPageFragmentInteractionListener? = null
    private lateinit var mRootView: View
    private var errorIsVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.login_fragment, container, false)
        return mRootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFirstPageFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFirstPageFragmentInteractionListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userNameTextView.onFocusChangeListener = this
        passwordTextView.onFocusChangeListener = this
        loginButton.setOnClickListener {
            errorIsVisible = false
            if (userNameTextView.text.isEmpty()) {
                userNameErrorView.visibility = View.VISIBLE
                errorIsVisible = true
            } else {
                userNameErrorView.visibility = View.GONE
            }
            if (passwordTextView.text.isEmpty()) {
                passwordErrorView.visibility = View.VISIBLE
                errorIsVisible = true
            } else {
                passwordErrorView.visibility = View.GONE
            }
            if (!errorIsVisible) {
                listener?.onLoginButtonPressed(userNameTextView.text.toString())
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onFocusChange(view: View?, hasFoscus: Boolean) {
        if (hasFoscus) {
            (view as EditText).hint = ""
        } else {
            when (view?.id) {
                userNameTextView.id -> {
                    (view as EditText).hint = getString(R.string.inserisci_username_o_email)
                }
                passwordTextView.id -> {
                    (view as EditText).hint = getString(R.string.inserisci_password)
                }
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFirstPageFragmentInteractionListener {
        fun onLoginButtonPressed(username: String)
    }

    companion object {
        const val TAG = "LoginFragment"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @return A new instance of fragment LoginFragment.
         */
        @JvmStatic
        fun newInstance() =
            LoginFragment()
    }
}
