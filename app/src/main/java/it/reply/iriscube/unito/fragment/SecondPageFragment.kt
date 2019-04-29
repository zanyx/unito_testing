package it.reply.iriscube.unito.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.reply.iriscube.unito.R
import kotlinx.android.synthetic.main.fragment_second_page.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_USERNAME = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SecondPageFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SecondPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SecondPageFragment : Fragment(), View.OnClickListener {
    private var mUserName: String? = null
    private var listener: OnSecondPageFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mUserName = it.getString(ARG_USERNAME)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTxt.text = mUserName
        logoutIcn.setOnClickListener(this)
        logoutTxt.setOnClickListener(this)
        nextIcn.setOnClickListener(this)
        nextTxt.setOnClickListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSecondPageFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnSecondPageFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.logoutIcn,
            R.id.logoutTxt -> {
                listener?.removeFragment(TAG)
            }
            R.id.nextTxt,
            R.id.nextIcn -> {
                listener?.goToMainSection()
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
    interface OnSecondPageFragmentInteractionListener {
        fun removeFragment(tag: String)
        fun goToMainSection()
    }

    companion object {
        const val TAG = "SecondPageFragment"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param username username inserted in login page.
         * @return A new instance of fragment SecondPageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(username: String) =
                SecondPageFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_USERNAME, username)
                    }
                }
    }
}
