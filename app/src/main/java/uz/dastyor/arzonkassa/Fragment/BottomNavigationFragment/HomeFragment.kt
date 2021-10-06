package uz.dastyor.arzonkassa.Fragment.BottomNavigationFragment

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

    private lateinit var adapter: RecyclerAdapter
    val headerAdapter = HeaderAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMyData();

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
    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build().create(
            Apiinterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object: Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody=response.body()!!
                val from = StringBuilder()
                val to = StringBuilder()
                val price = StringBuilder()
                for (myData in responseBody) {
                    from.append(myData.to)
                    to.append(myData.from)
                    price.append(myData.price)
                }
                tv_from.text=from
                tv_to.text=to
                tv_price.text="$price$"
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity","onFailure: "+t.message)
            }

        }
        )
    }


}