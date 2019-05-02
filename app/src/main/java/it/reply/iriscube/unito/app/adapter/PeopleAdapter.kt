package it.reply.iriscube.unito.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import it.reply.iriscube.unito.R

/**
 * Created by Reply.
 */
class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    var peopleList: List<PersonModel>? = null
        set(value) {
            field = value

            notifyDataSetChanged()
        }

    var onPersonSelectedListener: OnPersonSelectedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_cell_layout, parent, false)

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        peopleList?.let {
            val person = it[position]
            // Binding the person information to the view holder.
            viewHolder.nameTextView.text = person.name
            viewHolder.lastNameTextView.text = person.lastName

            person.avatarUrl?.let { avatarUrl ->
                Glide.with(viewHolder.itemView)
                    .load(avatarUrl)
                    .circleCrop()
                    .placeholder(R.drawable.person_placeholder)
                    .into(viewHolder.avatarImageView)
            } ?: run {
                Glide.with(viewHolder.itemView).clear(viewHolder.avatarImageView)

                viewHolder.avatarImageView.setImageResource(R.drawable.person_placeholder)
            }

            viewHolder.itemView.setOnClickListener {
                peopleList?.let { people ->
                    onPersonSelectedListener?.onPersonSelected(people[position])
                }
            }
        }
    }

    override fun getItemCount(): Int = peopleList?.size ?: 0

    class ViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val avatarImageView: ImageView =
            itemView.findViewById(R.id.avatarImageView)
        val nameTextView: TextView =
            itemView.findViewById(R.id.personNameTextView)
        val lastNameTextView: TextView =
            itemView.findViewById(R.id.personLastNameTextView)
    }

    data class PersonModel(
        val id: Long,
        val name: String,
        val lastName: String,
        val avatarUrl: String?
    )

    interface OnPersonSelectedListener {

        fun onPersonSelected(person: PersonModel)
    }
}