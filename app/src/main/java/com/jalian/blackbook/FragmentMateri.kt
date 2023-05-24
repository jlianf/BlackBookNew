package com.jalian.blackbook

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jalian.blackbook.databinding.FragmentMateriBinding
import com.jalian.blackbook.model.Field
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayList
import kotlin.jvm.Throws


class FragmentMateri : Fragment() {
    private var _binding: FragmentMateriBinding? = null
    private val binding get() = _binding!!

    private var mRecyclerView: RecyclerView? = null
    private val viewItem: MutableList<Any> = ArrayList()
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMateriBinding.inflate(layoutInflater)
        return binding.root

        mRecyclerView = binding.rvMateriList as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this.activity)
        mRecyclerView!!.layoutManager = layoutManager
        mAdapter = MateriAdapter(this, viewItem)
        mRecyclerView!!.adapter = mAdapter

        addItemFromJson()
        return binding.root
    }

    @Throws(IOException::class)
    private fun readJsonDataFromFile(): String {
        var inputStream : InputStream? = null
        val builder : StringBuilder()
        try {
            var jsonString : String?
            inputStream = assets.open("materi.json")
            val bufferedReader = BufferedReader(
                InputStreamReader(inputStream, "UTP-8")
            )
            while (bufferedReader.readLine().also { jsonString = it } != null){
                builder.append(jsonString)
            }
        } finally {
            inputStream?.close()
        }
        return String(builder)

    }
    private fun addItemFromJson() {
        try {
            val jsonDataString = readJsonDataFromFile()
            val jsonArray =JSONArray(jsonDataString)
            for (i in 0 until jsonArray.lenght()) {
                val itemOjb = jsonArray.getJSONArray(i)
                //val category= itemOjb.getString("category")
                val title = itemOjb.getString("tittle")
                val subtitle = itemOjb.getString("subtittle")
                val materi = Field("",title,subtitle)
                viewItem.add(materi)
            }
        } catch (e : JSONException){
            Log.d(ContentValues.TAG, "addItemFromJSON : ", e)
        } catch (e : IOException){
            Log.d(ContentValues.TAG, "addItemFromJSON : ", e)
        }
    }

}