package dz.gg.store.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var dataSatu: TextView
    private lateinit var dataDua: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //
        button = findViewById(R.id.buttonSatu)
        dataSatu = findViewById(R.id.dataSatu)
        dataDua = findViewById(R.id.dataDua)

        button.setOnClickListener {
            val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
            startActivityForResult(intent, RC_THIRD_ACT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //
        when (requestCode){
            RC_THIRD_ACT -> {
                when (resultCode){
                    KIRIM_KE_SECOND_ACTIVITY -> {
                        data?.let {
                            dataSatu.text = data.getStringExtra("data_satu")
                            dataDua.text = data.getStringExtra("data_dua")
                        }
                    }
                    KIRIM_KE_MAIN_ACTIVITY -> {
                        data?.let {
                            setResult(KIRIM_KE_MAIN_ACTIVITY, data)
                            finish()
                        }
                    }
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
