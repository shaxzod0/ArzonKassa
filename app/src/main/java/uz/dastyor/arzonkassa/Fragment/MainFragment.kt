package uz.dastyor.arzonkassa.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import uz.dastyor.arzonkassa.Fragment.BottomNavigationFragment.HomeFragment
import uz.dastyor.arzonkassa.R


class MainFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeFragment(HomeFragment())
        btn_nav.setOnNavigationItemSelectedListener { menuItem ->

            when(menuItem.itemId){
                R.id.home -> {changeFragment(HomeFragment())
                }

            }
            true


        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    fun changeFragment(fr:Fragment){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_bottom,fr)
            .commit()
    }
}