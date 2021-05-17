package ru.alinadorozhkina.pictureofthedayapp.mvp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.alinadorozhkina.pictureofthedayapp.databinding.FragmentPicBinding
import ru.alinadorozhkina.pictureofthedayapp.mvp.presenter.PicFragmentPresenter
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.App
import ru.alinadorozhkina.pictureofthedayapp.mvp.view.PicFragmentView

class PicFragment : MvpAppCompatFragment(), PicFragmentView {

    private var ui: FragmentPicBinding? = null

    private val presenter by moxyPresenter {
        PicFragmentPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentPicBinding.inflate(inflater, container, false).also {
        ui = it
    }.root


    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    companion object {
        fun newInstance() = PicFragment()
    }

    override fun setData() {
        TODO("Not yet implemented")
    }

    override fun loadPicture() {
        TODO("Not yet implemented")
    }

}