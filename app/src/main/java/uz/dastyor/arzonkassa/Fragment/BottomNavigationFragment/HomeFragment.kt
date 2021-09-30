package uz.dastyor.arzonkassa.Fragment.BottomNavigationFragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlinx.android.synthetic.main.fragment_home.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import uz.dastyor.arzonkassa.Adapter.HeaderAdapter
import uz.dastyor.arzonkassa.Adapter.RecyclerAdapter
import uz.dastyor.arzonkassa.Interface.ItemClick
import uz.dastyor.arzonkassa.OrderActivity
import uz.dastyor.arzonkassa.R
import java.lang.reflect.Array
import java.util.ArrayList


class HomeFragment : Fragment() , ItemClick {

    private lateinit var adapter: RecyclerAdapter
    val headerAdapter = HeaderAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cities = arrayOf("Andijon", "Namagan" , "Fergana" , "Jizzax" , "Termiz" , "Toshkent")
        rvTicket.layoutManager = LinearLayoutManager(context)
        adapter = RecyclerAdapter(
            cities,
            this@HomeFragment
        )
        val concatAdapter = ConcatAdapter(headerAdapter,adapter)
        rvTicket.adapter = concatAdapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onItemClicked(position: Int) {
        val intent = Intent(requireContext() , OrderActivity::class.java)
        startActivity(intent)
    }


}