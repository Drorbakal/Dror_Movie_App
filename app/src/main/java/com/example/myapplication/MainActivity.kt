package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.get
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alphaAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.alpha)
        val rootLayout = findViewById<View>(android.R.id.content)
        rootLayout.startAnimation(alphaAnim)
        val logo = findViewById<ImageView>(R.id.spininglogo)
        val rotatAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
        logo.startAnimation(rotatAnim)
        val show = AnimationUtils.loadAnimation(applicationContext, R.anim.itemshowing)
        val card1 = findViewById<CardView>(R.id.card1)
        val card2 = findViewById<CardView>(R.id.card2)
        val card3 = findViewById<CardView>(R.id.card3)
        val card4 = findViewById<CardView>(R.id.card4)
        val card5 = findViewById<CardView>(R.id.card5)
        val card6 = findViewById<CardView>(R.id.card6)
        val card7 = findViewById<CardView>(R.id.card7)
        val card8 = findViewById<CardView>(R.id.card8)
        val card9 = findViewById<CardView>(R.id.card9)
        val card10 = findViewById<CardView>(R.id.card10)
        val card11 = findViewById<CardView>(R.id.card11)
        val card12 = findViewById<CardView>(R.id.card12)
        card1.startAnimation(show)
        card2.startAnimation(show)
        card3.startAnimation(show)
        card4.startAnimation(show)
        card5.startAnimation(show)
        card6.startAnimation(show)
        card7.startAnimation(show)
        card8.startAnimation(show)
        card9.startAnimation(show)
        card10.startAnimation(show)
        card11.startAnimation(show)
        card12.startAnimation(show)
        card1.setOnClickListener { popuppage(it, 0) }
        card2.setOnClickListener { popuppage(it, 1) }
        card3.setOnClickListener { popuppage(it, 2) }
        card4.setOnClickListener { popuppage(it, 3) }
        card5.setOnClickListener { popuppage(it, 4) }
        card6.setOnClickListener { popuppage(it, 5) }
        card7.setOnClickListener { popuppage(it, 6) }
        card8.setOnClickListener { popuppage(it, 7) }
        card9.setOnClickListener { popuppage(it, 8) }
        card10.setOnClickListener { popuppage(it, 9) }
        card11.setOnClickListener { popuppage(it, 10) }
        card12.setOnClickListener { popuppage(it, 11) }
    }

    fun popuppage(view: View, position: Int) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popuppage)
        val nameTextView = dialog.findViewById<TextView>(R.id.textView)
        val detailsTextView = dialog.findViewById<TextView>(R.id.textView2)
        val image = dialog.findViewById<ImageView>(R.id.imageView)
        val ticketsbtn = dialog.findViewById<Button>(R.id.ticketsbtn)
        val calendercrd = dialog.findViewById<CardView>(R.id.calendercard)
        val calender = dialog.findViewById<DatePicker>(R.id.datePicker)
        val tickets = dialog.findViewById<CardView>(R.id.ticketscard)
        val adulteditText = dialog.findViewById<EditText>(R.id.adultedittxt)
        val adultpricetext = dialog.findViewById<EditText>(R.id.adulteditpricetxt)
        val childedittext = dialog.findViewById<EditText>(R.id.childedittxt)
        val childpricetext = dialog.findViewById<EditText>(R.id.childpriceedittxt)
        var adultvalue = 0
        var childvalue = 0
        calendercrd.alpha = 0.0f
        tickets.alpha = 0.0f
        var theatre_name = "name"
        val theatrebtn = dialog.findViewById<Button>(R.id.theatrebtn)
        image.setOnClickListener {
            val moviepicsdialog = Dialog(this)
            moviepicsdialog.setContentView(R.layout.moviepics)
            val pic1 = moviepicsdialog.findViewById<ImageView>(R.id.moviepic1)
            val pic2 = moviepicsdialog.findViewById<ImageView>(R.id.moviepic2)
            val pic3 = moviepicsdialog.findViewById<ImageView>(R.id.moviepic3)
            val pic4 = moviepicsdialog.findViewById<ImageView>(R.id.moviepic4)
            pic1.setImageResource(MyImages.image1Arr[position])
            pic2.setImageResource(MyImages.image2Arr[position])
            pic3.setImageResource(MyImages.image3Arr[position])
            pic4.setImageResource(MyImages.image4Arr[position])
            val show = AnimationUtils.loadAnimation(applicationContext, R.anim.itemshowing)
            pic1.startAnimation(show)
            pic2.startAnimation(show)
            pic3.startAnimation(show)
            pic4.startAnimation(show)
            moviepicsdialog.show()
        }
        theatrebtn.setOnClickListener {
            val theatreSelectionDialog = Dialog(this)
            theatreSelectionDialog.setContentView(R.layout.thaetre_popup)
            val planetbtn = theatreSelectionDialog.findViewById<Button>(R.id.th1)
            val cinemabtn = theatreSelectionDialog.findViewById<Button>(R.id.th2)
            val hotbtn = theatreSelectionDialog.findViewById<Button>(R.id.th3)
            planetbtn.setOnClickListener {
                theatre_name = getString(R.string.planet)
                theatrebtn.text = theatre_name
                theatreSelectionDialog.dismiss()
            }
            cinemabtn.setOnClickListener {
                theatre_name = getString(R.string.cinema_city)
                theatrebtn.text = theatre_name
                theatreSelectionDialog.dismiss()
            }
            hotbtn.setOnClickListener {
                theatre_name = getString(R.string.hot_globus)
                theatrebtn.text = theatre_name
                theatreSelectionDialog.dismiss()
            }
            theatreSelectionDialog.show()
        }
        ticketsbtn.setOnClickListener {
            calendercrd.alpha = 1.0f
            val calendar = Calendar.getInstance()
            val currentDate = calendar.time
            val maxDate = Calendar.getInstance()
            maxDate.add(Calendar.DAY_OF_MONTH, 14)
            calender.minDate = calendar.timeInMillis
            calender.maxDate = maxDate.timeInMillis
            val cnfbtn = dialog.findViewById<Button>(R.id.datebtn)
            cnfbtn.setOnClickListener {
                val selectedDate = "${calender.dayOfMonth}/${calender.month + 1}/${calender.year}"
                tickets.alpha = 1.0f
                val plusbtn = dialog.findViewById<Button>(R.id.plus)
                val plusbtn2 = dialog.findViewById<Button>(R.id.plus2)
                plusbtn.setOnClickListener {
                    adultvalue++
                    adulteditText.setText(adultvalue.toString())
                    adultpricetext.setText("%.1f$".format(adultvalue * 9.9))
                }
                plusbtn2.setOnClickListener {
                    childvalue++
                    childedittext.setText(childvalue.toString())
                    childpricetext.setText("%.1f$".format(childvalue * 7.9))
                }
                val minusbtn = dialog.findViewById<Button>(R.id.minus)
                val minusbtn2 = dialog.findViewById<Button>(R.id.minus2)
                minusbtn.setOnClickListener {
                    if (adultvalue>0) {
                        adultvalue--
                        adulteditText.setText(adultvalue.toString())
                        adultpricetext.setText("%.1f$".format(adultvalue * 9.9))
                    }
                }
                minusbtn2.setOnClickListener {
                    if (childvalue>0) {
                        childvalue--
                        childedittext.setText(childvalue.toString())
                        childpricetext.setText("%.1f$".format(childvalue * 9.9))
                    }
                }
                val orderbtn = dialog.findViewById<Button>(R.id.order)
                orderbtn.setOnClickListener {
                    if (theatre_name!="name") {
                        if (adultvalue > 0 || childvalue>0) {
                            val dialog = Dialog(this)
                            dialog.setContentView(R.layout.tickets_approved)
                            val moviename = dialog.findViewById<TextView>(R.id.movietxt)
                            val date_txt = dialog.findViewById<TextView>(R.id.datetxt)
                            val adultamount_txt = dialog.findViewById<TextView>(R.id.adultticketsnumtxt)
                            val price_txt = dialog.findViewById<TextView>(R.id.totaltxt)
                            val gobackbtn = dialog.findViewById<Button>(R.id.back2)
                            val confirmbtn = dialog.findViewById<Button>(R.id.confirm)
                            val theatreinfo = dialog.findViewById<TextView>(R.id.theatreinfo)
                            val childamounttxt = dialog.findViewById<TextView>(R.id.childticketnumtxt)
                            moviename.text = getString(R.string.movie_name_prefix) + " ${nameTextView.text}"
                            date_txt.text = getString(R.string.date_prefix) + " ${selectedDate}"
                            adultamount_txt.text = getString(R.string.adult_number_of_tickets) + " $adultvalue"
                            childamounttxt.text = getString(R.string.child_number_of_tickets) + " $childvalue"
                            price_txt.text = getString(R.string.price_prefix) + " ${(adultvalue * 9.9 + childvalue * 7.9)} $"
                            theatreinfo.text = getString(R.string.theatre) + " $theatre_name"
                            dialog.show()
                            gobackbtn.setOnClickListener {
                                dialog.dismiss()
                            }
                            confirmbtn.setOnClickListener {
                                val tst = getString(R.string.thank_you_payment_successful)
                                Toast.makeText(this, tst, Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                        }
                        else {
                            Toast.makeText(this, getString(R.string.type_your_amount_of_tickets), Toast.LENGTH_SHORT).show()
                        }
                    }
                    else {
                        Toast.makeText(this, getString(R.string.select_theatre), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        nameTextView.text = getString(MyData.nameArr[position])
        detailsTextView.text = getString(MyData.detailsArr[position])
        image.setImageResource(MyData.drawableArr[position])
        val rotatAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)

        image.startAnimation(rotatAnim)
        dialog.window?.setBackgroundDrawableResource(MyData.drawableArr[position])
        dialog.show()
        val backbtn = dialog.findViewById<Button>(R.id.backbtn)
        backbtn.setOnClickListener {
            dialog.dismiss()
        }
    }
}

