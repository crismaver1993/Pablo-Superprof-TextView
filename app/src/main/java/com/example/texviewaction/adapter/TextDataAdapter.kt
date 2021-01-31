package com.example.texviewaction.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.texviewaction.databinding.ItemTextviewBinding
import com.example.texviewaction.model.TextData

class TextDataAdapter(
    val onClickListener: (data: TextData) -> Unit

) : RecyclerView.Adapter<TextDataAdapter.CommentView>() {
    private val commentList: MutableList<TextData> = mutableListOf()

    fun setData(comments: MutableList<TextData>) {
        commentList.clear()
        commentList.addAll(comments)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentView {
        val itemBinding =
            ItemTextviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentView(itemBinding)
    }

    override fun onBindViewHolder(holder: CommentView, position: Int) {
        val data = commentList[position]

        holder.bind(data)

        holder.itemView.setOnClickListener {
            onClickListener(data)
        }
    }

    class CommentView(private val binding: ItemTextviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: TextData) {
            binding.tvItemBold.text = data.boldText
            binding.tvItemContent.text = data.normalText
            binding.tvItemContent.setTextColor(ContextCompat.getColor(binding.root.context, data.color))
        }
    }
}