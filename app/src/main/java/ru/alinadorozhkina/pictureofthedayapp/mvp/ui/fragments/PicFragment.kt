package ru.alinadorozhkina.pictureofthedayapp.mvp.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.alinadorozhkina.pictureofthedayapp.R
import ru.alinadorozhkina.pictureofthedayapp.databinding.FragmentPicBinding
import ru.alinadorozhkina.pictureofthedayapp.mvp.presenter.PicFragmentPresenter
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.App
import ru.alinadorozhkina.pictureofthedayapp.mvp.view.PicFragmentView

class PicFragment : MvpAppCompatFragment(), PicFragmentView {

    private var ui: FragmentPicBinding? = null
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    lateinit var bottomSheetTitle: TextView
    lateinit var bottomSheetDescription: TextView

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
        inflater.inflate(R.menu.bottom_app_bar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favourite-> presenter.favouritesClicked()
            R.id.settings -> presenter.settingsClicked()
            R.id.search -> presenter.seaarchClicked()
            android.R.id.home -> presenter.homeClicked()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ui?.inputLayout?.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://en.wikipedia.org/wiki/${ui?.inputEditText?.text.toString()}")
            })
        }
        setBottomSheetBehavior(view.findViewById(R.id.bottom_sheet_container))
        bottomSheetTitle = view.findViewById(R.id.bottom_sheet_description_header)
        bottomSheetDescription = view.findViewById(R.id.bottom_sheet_description)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun setData(data: String) {
        ui?.dataText?.text = data
    }

    override fun loadPicture(url: String) {
        ui?.imageView?.let {
            presenter.loader.load(url, it) }
    }

    override fun error(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun setTitle(title: String) {
       bottomSheetTitle.text = title
    }

    override fun setDescription(desc: String) {
        bottomSheetDescription.text = desc
    }

    private fun setBottomSheetBehavior(bottomSheet: ConstraintLayout) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    companion object {
        fun newInstance() = PicFragment()
    }

}