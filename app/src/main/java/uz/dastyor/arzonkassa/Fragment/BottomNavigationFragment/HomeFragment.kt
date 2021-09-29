package uz.dastyor.arzonkassa.Fragment.BottomNavigationFragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlinx.android.synthetic.main.fragment_home.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import uz.dastyor.arzonkassa.Adapter.RecyclerAdapter
import uz.dastyor.arzonkassa.Interface.ItemClick
import uz.dastyor.arzonkassa.OrderActivity
import uz.dastyor.arzonkassa.R
import java.lang.reflect.Array
import java.util.ArrayList


class HomeFragment : Fragment() , ItemClick {

    private lateinit var adapter: RecyclerAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Kotlin

        val carousel: ImageCarousel = view.findViewById(R.id.carousel)
        carousel.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()
        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",
                caption = "Photo by Aaron Wu on Unsplash"
            )
        )
        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"
            )
        )
        val headers = mutableMapOf<String, String>()
        headers["header_key"] = "header_value"

        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080",
                headers = headers
            )
        )
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.menu,
                caption = "Photo by Kimiya Oveisi on Unsplash"
            )
        )
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.menu
            )
        )

        list.add(
            CarouselItem(
                imageDrawable = R.drawable.menu
            )
        )

        carousel.setData(list)

        val cities = arrayOf("Andijon", "Namagan" , "Fergana" , "Jizzax" , "Termiz" , "Toshkent")

        rvTicket.layoutManager = LinearLayoutManager(context)
        adapter = RecyclerAdapter(
            cities,
            this@HomeFragment
        )
        rvTicket.adapter = adapter

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