package ru.alinadorozhkina.pictureofthedayapp.mvp.ui.activities

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.alinadorozhkina.pictureofthedayapp.R
import ru.alinadorozhkina.pictureofthedayapp.databinding.ActivityMainBinding
import ru.alinadorozhkina.pictureofthedayapp.mvp.presenter.MainPresenter
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.App
import ru.alinadorozhkina.pictureofthedayapp.mvp.view.MainView
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    val navigator = AppNavigator(this, R.id.fragment_container)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}