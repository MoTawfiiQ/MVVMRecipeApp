package com.example.mvvmrecipeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.mvvmrecipeapp.pesentation.ui.RecipeListViewModel


class RecipeListFragment : Fragment(){

    private val viewModel: RecipeListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Create a ComposeView instead of inflating a layout
        val view = ComposeView(requireContext())
        view.apply {
            setContent {
                val recipes = viewModel.recipes.value

//                Lazy
            }
        }
        return view
    }
}