package com.example.texviewaction

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.texviewaction.adapter.TextDataAdapter
import com.example.texviewaction.databinding.ActivityMainBinding
import com.example.texviewaction.model.TextData
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myAdapter: TextDataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initView()
    }

    private fun initView() {
        with(binding.rvContainer) {
            val flexBoxLayoutManager = FlexboxLayoutManager(context)
            // flexBoxLayoutManager.flexDirection = FlexDirection.COLUMN

            layoutManager = flexBoxLayoutManager //GridLayoutManager(context, 2)
            myAdapter = TextDataAdapter(::onClickListener)
            adapter = myAdapter
        }

        addInfo()
    }

    private fun addInfo() {
        val list = arrayListOf<TextData>(
            TextData(
                boldText = "@cristofermarin",
                color = R.color.purple_500,
                linkType = GENERAL_ACTION,
                count = 1,
                normalText = "Esto es una prueba para el proyecto"
            ),

            TextData(
                boldText = "@android",
                color = R.color.teal_200,
                linkType = GENERAL_ACTION,
                count = 2,
                normalText = "Y el click que muestra?"
            ),

            TextData(
                boldText = "@cristofermarin",
                color = R.color.teal_700,
                linkType = GENERAL_ACTION,
                count = 3,
                normalText = "Da clic"
            ),
            TextData(
                boldText = "@android",
                color = R.color.red,
                linkType = GENERAL_ACTION,
                count = 4,
                normalText = "Se ve bien"
            )
        )

        myAdapter?.setData(list)
    }

    private fun onClickListener(textData: TextData) {
        Log.v("xxxClick", "Info: $textData")
        MaterialAlertDialogBuilder(this)
            .setTitle(textData.boldText)
            .setMessage(textData.normalText)
            .setPositiveButton(
                "Ok"
            ) { dialog, which -> Log.d("xxxClickListener", "User select ok") }
            .show()
    }

    companion object {
        private const val GENERAL_ACTION = 1
    }
}