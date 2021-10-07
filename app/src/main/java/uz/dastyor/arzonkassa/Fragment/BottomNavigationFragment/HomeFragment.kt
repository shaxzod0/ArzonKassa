package uz.dastyor.arzonkassa.Fragment.BottomNavigationFragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_ticket.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.dastyor.arzonkassa.Adapter.HeaderAdapter
import uz.dastyor.arzonkassa.Adapter.RecyclerAdapter
import uz.dastyor.arzonkassa.Apiinterface
import uz.dastyor.arzonkassa.Interface.ItemClick
import uz.dastyor.arzonkassa.MyDataItem
import uz.dastyor.arzonkassa.OrderActivity
import uz.dastyor.arzonkassa.R
import java.lang.reflect.Array
import java.util.ArrayList

const val BASE_URL="https://608bc945737e470017b754f0.mockapi.io/api/v1/"
class HomeFragment : Fragment() , ItemClick {

    lateinit var adapter: RecyclerAdapter
    val headerAdapter = HeaderAdapter()
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTicket.setHasFixedSize(true)
        adapter = RecyclerAdapter(this@HomeFragment)
        val concatAdapter = ConcatAdapter(headerAdapter,adapter)
        rvTicket.adapter = concatAdapter
        linearLayoutManager= LinearLayoutManager(context)
        rvTicket.layoutManager=linearLayoutManager
        getMyData()

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


    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build().create(
            Apiinterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object: Callback<ArrayList<MyDataItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<ArrayList<MyDataItem>?>,
                response: Response<ArrayList<MyDataItem>?>
            ) {
                val responseBody=response.body()!!
                adapter.updateList(responseBody)
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<ArrayList<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity","onFailure: "+t.message)
            }

        }
        )
    }


}