package com.vishugahlot.cucity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vishugahlot.cucity.ui.Chat_bot
import kotlinx.android.synthetic.main.fragment_fourth.*


class FourthFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//     phone vishu
        phone_vishu.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:9627127275")
            startActivity(intent)
        }

//        email vishu
        email_vishu.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:vishuvictor2000@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("20bca1485@cuchd.in"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "feedback")

            startActivity(Intent.createChooser(intent, "Email via..."))
        }

//        email akshat
        email_akshat.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:Joshiak3252@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("20bca1328@cuchd.in"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "feedback")

            startActivity(Intent.createChooser(intent, "Email via..."))
        }

//        phone akshat
        phone_akshat.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:9877862504")
            startActivity(intent)
        }

//        share button
        shareApp.setOnClickListener{
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            val text = "Install this cool application for Chandigarh University : "
            val link = "https://t.ly/I7R-"
            i.putExtra(Intent.EXTRA_TEXT, "$text $link")
            startActivity(Intent.createChooser(i, "Share link:"))
        }

//        24 *7 chat support
            chatbox.setOnClickListener {
                val intent = Intent(context, Chat_bot::class.java)
                startActivity(intent)
            }

//        razorpay
        razormoney.setOnClickListener{
            val intent = Intent(context,RazorPayActivity::class.java)
            startActivity(intent)
        }

        }

}

