package com.algebra.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service( ) {

    private var serviceOn = false

    override fun onStartCommand( intent: Intent, flags: Int, startId: Int ): Int {
        //Thread.sleep( 10000 )
        if ( serviceOn )
            Toast.makeText( this, "Service already started", Toast.LENGTH_SHORT ).show( )
        else {
            Toast.makeText( this, "Service Started", Toast.LENGTH_SHORT ).show( )
            serviceOn = true
            BackgroundTask( this ).execute( 5 )
        }
        return START_STICKY
    }

    override fun onDestroy( ) {
        Toast.makeText( this, "Stopped", Toast.LENGTH_SHORT ).show( )
        super.onDestroy( )
    }

    override fun onBind( intent: Intent ): IBinder {
        TODO("Return the communication channel to the service.")
    }

}
