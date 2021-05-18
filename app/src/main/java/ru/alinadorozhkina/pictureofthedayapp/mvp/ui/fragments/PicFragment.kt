package ru.alinadorozhkina.pictureofthedayapp.mvp.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import coil.api.load
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.alinadorozhkina.pictureofthedayapp.R
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.bottom_navigation_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favourite-> presenter.favouritesClicked()
            R.id.settings -> presenter.settingsClicked()
            R.id.search -> presenter.seaarchClicked()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun setData(data: String) {
        ui?.dataText?.text = data
    }

    override fun loadPicture(url: String) {
        ui?.imageView?.let { presenter.loader.load(url, it) }
    }

    override fun error(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = PicFragment()
    }

}