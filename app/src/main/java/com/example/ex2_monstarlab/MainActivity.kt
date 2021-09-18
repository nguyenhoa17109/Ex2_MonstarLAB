package com.example.ex2_monstarlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(EnviarFragment.newInstance())
        navigation.show(0)
        navigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_icon_enviar))
        navigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_icon_recibir))
        navigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_perfil))

        navigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(EnviarFragment.newInstance())
                }
                1 -> {
                    replaceFragment(RecibirFragment.newInstance())
                }
                2 -> {
                    replaceFragment(PerfilFragment.newInstance())
                }
            }
        }
//        button.
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment,fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragment,fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }
}