package com.jason.catalarm.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jason.catalarm.databinding.FragmentHomeBinding
import com.jason.catalarm.ui.ClockAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val homeActivity = activity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        //初始化recyclerview
        val recyclerview : RecyclerView = binding.rvClockList
//        val linearLayout = LinearLayoutManager(activity)
//        linearLayout.orientation = LinearLayoutManager.VERTICAL

        val layoutManager: LinearLayoutManager = object : LinearLayoutManager(activity) {
            override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
                return RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }

        recyclerview.layoutManager = layoutManager
        val adapter = ClockAdapter()
        recyclerview.adapter = adapter

        //初始化添加闹钟按钮
        val ibAddClock: ImageButton = binding.ibAddClock
        ibAddClock.setOnClickListener {
            val intent = Intent(activity, AddClockActivity::class.java)
            startActivity(intent)
        }
        return root
    }

    fun addClock() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


