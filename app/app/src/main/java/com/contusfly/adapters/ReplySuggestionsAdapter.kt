package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.emoji.widget.EmojiAppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.adapters.ReplySuggestionsAdapter.ReplySuggestionViewHolder
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion
import java.util.*

class ReplySuggestionsAdapter(private val context: Context, private val suggestionClickListener: SuggestionClickListener) : RecyclerView.Adapter<ReplySuggestionViewHolder>() {

    private val smartReplySuggestions: MutableList<SmartReplySuggestion> = ArrayList()

    fun setSmartReplySuggestions(smartReplySuggestion: List<SmartReplySuggestion>?) {
        smartReplySuggestions.clear()
        smartReplySuggestions.addAll(smartReplySuggestion!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReplySuggestionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.suggestion_recycler_item, parent, false)
        return ReplySuggestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReplySuggestionViewHolder, position: Int) {
        val suggestion = smartReplySuggestions[position]
        holder.bind(suggestion)
    }

    override fun getItemCount(): Int {
        return smartReplySuggestions.size
    }

    inner class ReplySuggestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var suggestionText: EmojiAppCompatTextView = itemView.findViewById(R.id.reply_text)
        fun bind(suggestion: SmartReplySuggestion) {
            suggestionText.text = suggestion.text
            itemView.setOnClickListener { suggestionClickListener.onSuggestionClick(suggestion.text) }
        }

    }

    fun interface SuggestionClickListener {
        fun onSuggestionClick(text: String)
    }
}