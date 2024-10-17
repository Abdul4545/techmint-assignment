package com.example.techmintassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class RepositoryAdapter {
//}

class RepositoryAdapter(private val onRepoClick: (Repository) -> Unit) :
    RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    private var repositories = listOf<Repository>()

    fun submitList(repoList: List<Repository>) {
        repositories = repoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(repositories[position], onRepoClick)
    }

    override fun getItemCount(): Int = repositories.size

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repository: Repository, onRepoClick: (Repository) -> Unit) {
            itemView.findViewById<TextView>(R.id.repo_name).text = repository.name
            itemView.findViewById<TextView>(R.id.repo_owner).text = repository.owner.login
            itemView.setOnClickListener { onRepoClick(repository) }
        }
    }
}
