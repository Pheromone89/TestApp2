package dz.gg.store.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var dataSatu: TextView
    private lateinit var dataDua: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        button = findViewById(R.id.buttonSatu)
        dataSatu = findViewById(R.id.dataSatu)
        dataDua = findViewById(R.id.dataDua)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivityForResult(intent, RC_SECOND_ACT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //
        when (requestCode){
            RC_SECOND_ACT -> {
                when (resultCode){
                    KIRIM_KE_MAIN_ACTIVITY -> {
                        data?.let {
                            dataSatu.text = data.getStringExtra("data_satu")
                            dataDua.text = data.getStringExtra("data_dua")
                        }
                    }
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
