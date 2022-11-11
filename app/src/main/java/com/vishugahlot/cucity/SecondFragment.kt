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
import com.vishugahlot.cucity.ui.Chat_bot
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_second,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//      lost intent app code
        lostCard.setOnClickListener {
            val cn = ComponentName("com.example.lostfound",
                "com.example.lostfound.Login"
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

//        found intent app code
        foundCard.setOnClickListener {
            val cn = ComponentName("com.example.lostfound",
                "com.example.lostfound.Login"
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

//       contact intent (using to check contact list)
        contCard.setOnClickListener{
            val intent = Intent(context, ContactList::class.java)
            startActivity(intent)
        }

//        Note application intent
        Note_Take.setOnClickListener {
            val cn = ComponentName("com.codingwithme.notesapp",
                "com.codingwithme.notesapp.MainActivity"
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
    }


}