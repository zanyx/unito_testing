package it.reply.iriscube.unito.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.reply.iriscube.unito.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CompanyFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CompanyFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CompanyFragment : Fragment() {
    private var listener: OnCompanyFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCompanyFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
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
    interface OnCompanyFragmentInteractionListener

    companion object {
        val TAG = "CompanyFragment"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CompanyFragment.
         */
        @JvmStatic
        fun newInstance() = CompanyFragment()
    }
}
