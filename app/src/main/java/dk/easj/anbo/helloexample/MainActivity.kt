package dk.easj.anbo.helloexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dk.easj.anbo.helloexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // https://developer.android.com/topic/libraries/view-binding#kotlin
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.sayHelloButton.setOnClickListener {
            val inputField = binding.nameEditText
            val name = inputField.text.toString().trim()
            if (name.isEmpty()) {
                inputField.error = "No name"
                return@setOnClickListener
            }
            binding.sayHelloButton.text = "Hello $name"
        }
    }
}