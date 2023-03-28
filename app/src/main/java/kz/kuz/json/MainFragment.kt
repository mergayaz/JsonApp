package kz.kuz.json

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainFragment : Fragment() {
    // методы фрагмента должны быть открытыми
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.setTitle(R.string.toolbar_title)
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val jsonString = "{'firstName': 'Иван',\"lastName\": \"Иванов\"," +
                "\"address\": {\"streetAddress\": \"Московское ш., 101, кв.101\"," +
                "\"city\": \"Ленинград\", \"postalCode\": 101101}," +
                "\"phoneNumbers\": [{\"one\": \"812 123-1234\"}, {\"two\": \"916 123-4567\"}]}"
        lateinit var jsonBody: JSONObject
        try {
            jsonBody = JSONObject(jsonString)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        lateinit var firstName: String
        try {
            firstName = jsonBody.getString("firstName")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        lateinit var phoneNumbers: JSONArray
        try {
            phoneNumbers = jsonBody.getJSONArray("phoneNumbers")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        lateinit var address: JSONObject
        try {
            address = jsonBody.getJSONObject("address")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        var postalCode = 0
        try {
            postalCode = address.getInt("postalCode")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        lateinit var one_number: JSONObject
        try {
            one_number = phoneNumbers.getJSONObject(0)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Log.e("firstName", firstName)
        Log.e("postalCode", postalCode.toString())
        Log.e("one_number", one_number.toString())
        return view
    }
}