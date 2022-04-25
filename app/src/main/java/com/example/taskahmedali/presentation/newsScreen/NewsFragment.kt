package com.example.taskahmedali.presentation.newsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.taskahmedali.databinding.FragmentNewsBinding
import com.example.taskahmedali.model.NewsRsm
import com.example.taskahmedali.model.NewsRsm.Article
import com.example.taskahmedali.presentation.baseActivity.BaseActivity

class NewsFragment : Fragment() {

  lateinit var binding: FragmentNewsBinding
  private lateinit var epoxyController: NewsController

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentNewsBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialEpoxyController()
    setupEpoxyRV()
    updateArticles()
  }

  private fun initialEpoxyController() {
    epoxyController = NewsController { handleClickItem(it) }
  }

  private fun handleClickItem(article: Article) {
    findNavController().navigate(NewsFragmentDirections.actionNewsFragmentToDetailsFragment(article))
  }

  private fun setupEpoxyRV() {
    binding.epoxyRecyclerView.apply {
      setController(epoxyController)
      addItemDecoration(DividerItemDecoration(requireActivity(), RecyclerView.VISIBLE))
    }
  }

  private fun updateArticles() {
    (activity as BaseActivity).viewModel.breakingNews.observe(viewLifecycleOwner) {
      epoxyController.isLoading = true

      epoxyController.articles = it?.articles as MutableList<Article>
    }
  }
}