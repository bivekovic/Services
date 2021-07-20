package com.algebra.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var bStartService       : Button
    private lateinit var bStopService        : Button
    private lateinit var bStartIntentService : Button
    private lateinit var bTest               : Button

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        initWidgets( )
        setupListeners( )
    }

    private fun initWidgets( ) {
        bStartService       = findViewById( R.id.bStartService )
        bStopService        = findViewById( R.id.bStopService )
        bStartIntentService = findViewById( R.id.bStartIntentService )
        bTest               = findViewById( R.id.bTest )
    }

    private fun setupListeners() {
        bStartService.setOnClickListener {
            startService( Intent( this, MyService::class.java ) )
        }

        bStopService.setOnClickListener {
            stopService( Intent( this, MyService::class.java ) )
        }

        bStartIntentService.setOnClickListener {
            val intent: Intent = Intent( this, MyIntentService::class.java ).apply {
                action = MY_ACTION
                putExtra( INT_EXTRA, 5 )
            }
            startService( intent )
        }

        bTest.setOnClickListener {
            Toast
                .makeText( this, "Test", Toast.LENGTH_SHORT )
                .show( )
        }

    }

}
