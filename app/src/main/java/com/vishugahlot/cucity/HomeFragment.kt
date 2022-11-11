package com.vishugahlot.cucity

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { return inflater.inflate( R.layout.fragment_home,container, false)}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




//        weather activity intent
        weather.setOnClickListener {
            val cn = ComponentName("com.google.android.googlequicksearchbox",
                        "com.google.android.apps.search.weather.WeatherExportedActivity"
            )
            try {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_LAUNCHER)
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                intent.component = cn
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "activity not found", Toast.LENGTH_LONG)
                    .show()
            }
        }

//        Google News website intent
        news.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://news.google.com/search?q=coding&hl=en-IN&gl=IN&ceid=IN%3Aen"))
            startActivity(browserIntent)
        }



//        cumap activity intent
        //30.770526699815903, 76.57912718224343
        cumap.setOnClickListener{
            val url = "https://www.google.com/maps/search/?api=1&query=30.770526699815903, 76.57912718224343"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

//        carousel view
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://cdn.dribbble.com/userupload/2836025/file/original-ed5313ae4258291a1ff8d8265aeaae1e.jpg?compress=1&resize=752x","Map"))
        imageList.add(SlideModel("https://cdn.dribbble.com/userupload/3399788/file/original-f19c3aa15c827a2b7acf7517284c2528.png?compress=1&resize=752x","Chat"))
        imageList.add(SlideModel("https://cdn.dribbble.com/users/299116/screenshots/17659151/media/95bbe674c35a19119e5279ec89225ca8.jpg","Integration"))
        imageList.add(SlideModel("https://cdn.dribbble.com/userupload/3637928/file/original-4b75643a870982e95404926c022a36b0.png?compress=1&resize=752x","Virtual Talks"))

        slider.setImageList(imageList,ScaleTypes.FIT)

    // music intents
        relaxmusic.setOnClickListener{
            var uri = Uri.parse("https://www.youtube.com/watch?v=hlWiI4xVXKY")
            uri = Uri.parse("vnd.youtube:" + uri.getQueryParameter("v"))
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        sleepmusic.setOnClickListener{
            var uri = Uri.parse("https://www.youtube.com/watch?v=bP9gMpl1gyQ")
            uri = Uri.parse("vnd.youtube:" + uri.getQueryParameter("v"))
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        motivationmusic.setOnClickListener{
            var uri = Uri.parse("https://www.youtube.com/watch?v=WDxMas784iY")
            uri = Uri.parse("vnd.youtube:" + uri.getQueryParameter("v"))
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        focusmusic.setOnClickListener{
            var uri = Uri.parse("https://www.youtube.com/watch?v=_4kHxtiuML0")
            uri = Uri.parse("vnd.youtube:" + uri.getQueryParameter("v"))
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }




}

