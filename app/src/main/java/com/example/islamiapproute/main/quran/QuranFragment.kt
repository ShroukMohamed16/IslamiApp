package com.example.islamiapproute.main.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapproute.R
import com.example.islamiapproute.main.chapter_details.ChapterDetailsActivity
import com.example.islamiapproute.main.hadeth.HadethFragment


class QuranFragment : Fragment() {


    private lateinit var quranAdapter: ContentAdapter
    private val  soraList= listOf(
        "الفاتحة" to 7,
        "البقرة" to 286,
        "آل عمران" to 200,
        "النساء" to 176,
        "المائدة" to 120,
        "الأنعام" to 165,
        "الأعراف" to 206,
        "الأنفال" to 75,
        "التوبة" to 129,
        "يونس" to 109,
        "هود" to 123,
        "يوسف" to 111,
        "الرعد" to 43,
        "إبراهيم" to 52,
        "الحجر" to 99,
        "النحل" to 128,
        "الإسراء" to 111,
        "الكهف" to 110,
        "مريم" to 98,
        "طه" to 135,
        "الأنبياء" to 112,
        "الحج" to 78,
        "المؤمنون" to 118,
        "النور" to 64,
        "الفرقان" to 77,
        "الشعراء" to 227,
        "النمل" to 93,
        "القصص" to 88,
        "العنكبوت" to 69,
        "الروم" to 60,
        "لقمان" to 34,
        "السجدة" to 30,
        "الأحزاب" to 73,
        "سبأ" to 54,
        "فاطر" to 45,
        "يس" to 83,
        "الصافات" to 182,
        "ص" to 88,
        "الزمر" to 75,
        "غافر" to 85,
        "فصلت" to 54,
        "الشورى" to 53,
        "الزخرف" to 89,
        "الدخان" to 59,
        "الجاثية" to 37,
        "الأحقاف" to 35,
        "محمد" to 38,
        "الفتح" to 29,
        "الحجرات" to 18,
        "ق" to 45,
        "الذاريات" to 60,
        "الطور" to 49,
        "النجم" to 62,
        "القمر" to 55,
        "الرحمن" to 78,
        "الواقعة" to 96,
        "الحديد" to 29,
        "المجادلة" to 22,
        "الحشر" to 24,
        "الممتحنة" to 13,
        "الصف" to 14,
        "الجمعة" to 11,
        "المنافقون" to 11,
        "التغابن" to 18,
        "الطلاق" to 12,
        "التحريم" to 12,
        "الملك" to 30,
        "القلم" to 52,
        "الحاقة" to 52,
        "المعارج" to 44,
        "نوح" to 28,
        "الجن" to 28,
        "المزمل" to 20,
        "المدثر" to 56,
        "القيامة" to 40,
        "الإنسان" to 31,
        "المرسلات" to 50,
        "النبأ" to 40,
        "النازعات" to 46,
        "عبس" to 42,
        "التكوير" to 29,
        "الإنفطار" to 19,
        "المطففين" to 36,
        "الإنشقاق" to 25,
        "البروج" to 22,
        "الطارق" to 17,
        "الأعلى" to 19,
        "الغاشية" to 26,
        "الفجر" to 30,
        "البلد" to 20,
        "الشمس" to 15,
        "الليل" to 21,
        "الضحى" to 11,
        "الشرح" to 8,
        "التين" to 8,
        "العلق" to 19,
        "القدر" to 5,
        "البينة" to 8,
        "الزلزلة" to 8,
        "العاديات" to 11,
        "القارعة" to 11,
        "التكاثر" to 8,
        "العصر" to 3,
        "الهمزة" to 9,
        "الفيل" to 5,
        "قريش" to 4,
        "الماعون" to 7,
        "الكوثر" to 3,
        "الكافرون" to 6,
        "النصر" to 3,
        "المسد" to 5,
        "الإخلاص" to 4,
        "الفلق" to 5,
        "الناس" to 6
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranAdapter = ContentAdapter(soraList)
        val soraRecyclerView:RecyclerView =view.findViewById(R.id.sora_rv)
        soraRecyclerView.adapter = quranAdapter

        quranAdapter.onItemClicked =
            ContentAdapter.OnItemClicked{ position,title ->
                goToChapterDetails(position,title)
            }

    }
    private fun goToChapterDetails(position:Int,title:String){

        val intent = Intent(requireActivity(),ChapterDetailsActivity::class.java)
        intent.putExtra("position",position)
        intent.putExtra("title",title)
        startActivity(intent)
    }


}