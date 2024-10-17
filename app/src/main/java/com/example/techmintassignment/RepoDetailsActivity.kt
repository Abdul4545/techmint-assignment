package com.example.techmintassignment

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class RepoDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_details)

        val repository = intent.getParcelableExtra<Repository>("repository")

        findViewById<TextView>(R.id.repo_name).text = repository?.name
        findViewById<TextView>(R.id.repo_owner).text = repository?.owner?.login
        findViewById<TextView>(R.id.repo_description).text = repository?.description
        findViewById<TextView>(R.id.repo_link).apply {
            text = repository?.html_url
            setOnClickListener {
                val intent = Intent(this@RepoDetailsActivity, WebViewActivity::class.java)
                intent.putExtra("url", repository?.html_url)
                startActivity(intent)
            }
        }
    }
}
