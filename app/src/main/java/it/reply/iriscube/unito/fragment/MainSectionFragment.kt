package it.reply.iriscube.unito.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.reply.iriscube.unito.R
import kotlinx.android.synthetic.main.fragment_main_section.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainSectionFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainSectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainSectionFragment : Fragment(), View.OnClickListener {
    private var listener: OnMainSectionFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_section, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMainSectionFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnMainSectionFragmentInteractionListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileContainer.setOnClickListener(this)
        companyContainer.setOnClickListener(this)
        addressbookContainer.setOnClickListener(this)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.profileContainer -> {
                listener?.goToProfile()
            }
            R.id.companyIcn,
            R.id.companyTxt,
            R.id.companyContainer -> {
                listener?.goToCompany()
            }
            R.id.addressbookContainer -> {
                listener?.goToAddressBook()
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
    interface OnMainSectionFragmentInteractionListener {
        fun goToProfile()
        fun goToCompany()
        fun goToAddressBook()
    }

    companion object {
        val TAG = "MainSectionFragment"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment MainSectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = MainSectionFragment()
    }
}
