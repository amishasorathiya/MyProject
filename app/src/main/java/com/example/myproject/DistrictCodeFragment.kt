package com.example.myproject

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import android.provider.SyncStateContract.Helpers.insert

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DistrictCodeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DistrictCodeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var v = inflater.inflate(R.layout.fragment_district_code, container, false)


        val cv = ContentValues()
        var ed = v.findViewById<EditText>(R.id.ed)
        var ed2 = v.findViewById<EditText>(R.id.ed2)

        var b1 = v.findViewById<Button>(R.id.btnNext)
        var b2 = v.findViewById<Button>(R.id.btnPrev)
        var b3 = v.findViewById<Button>(R.id.btnLast)
        var b4 = v.findViewById<Button>(R.id.btnInsert)
        var b5 = v.findViewById<Button>(R.id.btnUpdate)
        var b6 = v.findViewById<Button>(R.id.btnDelete)
        var b7 = v.findViewById<Button>(R.id.btnClear)
        var b8 = v.findViewById<Button>(R.id.btnFirst)
        var b9 = v.findViewById<Button>(R.id.btnAll)

        //val resolver = requireContext().contentResolver
        var resolver = v.context.contentResolver

        var rs = resolver.query(DistrictCodeProvider.CONTENT_URI,
            arrayOf(DistrictCodeProvider._ID,DistrictCodeProvider.DISTRICT_NAME,DistrictCodeProvider.CODE),null,null,null)

        b4.setOnClickListener {
            cv.put(DistrictCodeProvider.DISTRICT_NAME,ed.text.toString())
            cv.put(DistrictCodeProvider.CODE,ed2.text.toString())

            //getActivity()?.getContentResolver()?.insert(DistrictCodeProvider.CONTENT_URI,cv)
            //context?.contentResolver?.insert(DistrictCodeProvider.CONTENT_URI,cv)
            resolver.insert(DistrictCodeProvider.CONTENT_URI,cv)

            rs?.requery()
            Toast.makeText(requireContext(), "Record Inserted ", Toast.LENGTH_SHORT).show()

            ed.setText("")
            ed2.setText("")
            ed.requestFocus()

        }

        b5.setOnClickListener {
            cv.put(DistrictCodeProvider.CODE, ed2.text.toString())
            //Toast.makeText(requireContext(), cv.toString(), Toast.LENGTH_SHORT).show()
            val count = resolver.update(DistrictCodeProvider.CONTENT_URI,cv,"DISTRICT_NAME=?",
                arrayOf(ed.text.toString()))

            Toast.makeText(requireContext(), "Record Updated ", Toast.LENGTH_SHORT).show()

            rs?.requery()

            ed.setText("")
            ed2.setText("")
            ed.requestFocus()

        }

        b6.setOnClickListener {
            val count = resolver.delete(DistrictCodeProvider.CONTENT_URI,"DISTRICT_NAME=?", arrayOf(ed.text.toString()))
            rs?.requery()
            if(rs!!.moveToFirst())
            {
                ed.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }
            else
            {
                ed.setText("Record not found...")
                ed2.setText("Enter new Record...")
            }
            Toast.makeText(requireContext(), "Record Deleted ", Toast.LENGTH_SHORT).show()
        }


        b8.setOnClickListener {
            if(rs!!.moveToNext())
            {
                ed.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }
            else if(rs!!.moveToFirst())
            {
                ed.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }
            else
            {
                ed.setText("Record not found...")
                ed2.setText("Enter new Record...")
            }
        }




        b1.setOnClickListener {
            if(rs!!.moveToNext())
            {
                ed.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }
            else if(rs!!.moveToFirst())
            {
                ed.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }
            else
            {
                ed.setText("Record not found...")
                ed2.setText("Enter new Record...")
            }

        }

        b2.setOnClickListener {
            if(rs!!.moveToPrevious())
            {
                ed.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }
            else if(rs!!.moveToFirst())
            {
                ed.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }
            else
            {
                ed.setText("Record not found...")
                ed2.setText("Enter new Record...")
            }
        }

        b3.setOnClickListener {
            if(rs!!.moveToLast())
            {
                ed.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }
            else
            {
                ed.setText("Record not found...")
                ed2.setText("Enter new Record...")
            }
        }

        b9.setOnClickListener {
            var rs = resolver.query(DistrictCodeProvider.CONTENT_URI,
                arrayOf(DistrictCodeProvider._ID,DistrictCodeProvider.DISTRICT_NAME,DistrictCodeProvider.CODE),null,null,null)

            while (rs?.moveToNext()!!)
            {
                var intent = Intent(requireContext(),ViewAllActivity::class.java)
                startActivity(intent)
                break
            }

        }


        b7.setOnClickListener {
            ed.setText("")
            ed2.setText("")
            ed.requestFocus()
        }

        return v
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DistrictCodeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DistrictCodeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}