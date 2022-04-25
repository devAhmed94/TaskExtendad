package com.example.taskahmedali.presentation.detailsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.taskahmedali.R
import com.example.taskahmedali.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

  lateinit var binding: FragmentDetailsBinding
  private val args: DetailsFragmentArgs by navArgs()
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentDetailsBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setContent()
  }

  private fun setContent() {
    val article =args.article
    with(binding) {
      Glide.with(requireActivity())
        .load(article?.urlToImage)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder).into(ivArticleImage)

      tvAuthor.text = article.author
      tvContent.text = article.content
      tvTitle.text = article.title
      tvDescription.text = article.description
      tvSource.text = article.source.name
      tvPublishedAt.text = article.publishedAt

    }
  }
}