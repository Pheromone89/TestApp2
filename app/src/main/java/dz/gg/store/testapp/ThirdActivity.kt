package dz.gg.store.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {

    private lateinit var buttonSatu: Button
    private lateinit var buttonDua: Button
    private lateinit var dataSatu: EditText
    private lateinit var dataDua: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        //
        buttonSatu = findViewById(R.id.buttonSatu)
        buttonDua = findViewById(R.id.buttonDua)
        dataSatu = findViewById(R.id.dataSatu)
        dataDua = findViewById(R.id.dataDua)

        buttonSatu.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_satu", dataSatu.text.toString())
            intent.putExtra("data_dua", dataDua.text.toString())
            setResult(KIRIM_KE_SECOND_ACTIVITY, intent)
            finish()
        }

        buttonDua.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_satu", dataSatu.text.toString())
            intent.putExtra("data_dua", dataDua.text.toString())
            setResult(KIRIM_KE_MAIN_ACTIVITY, intent)
            finish()
        }
    }
}
