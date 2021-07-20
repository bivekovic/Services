package com.algebra.services

import android.app.IntentService
import android.content.Intent
import android.os.Handler
import android.widget.Toast

const val MY_ACTION = "com.algebra.services.action.MY_ACTION"
const val INT_EXTRA = "com.algebra.services.extra.INT_EXTRA"

class MyIntentService : IntentService( "MyIntentService" ) {
    private val handler = Handler( )

    override fun onHandleIntent( intent: Intent? ) {
        if ( intent?.action == MY_ACTION )
            handleAction( intent.getIntExtra( INT_EXTRA, 0 ) )
    }

    private fun handleAction( taskCount: Int ) {
        for ( i in 0 until taskCount ) {
            Thread.sleep( 3000 )
            handler.post {
                Toast.makeText(
                    applicationContext,
                    "${i + 1} of $taskCount tasks finished in background",
                    Toast.LENGTH_SHORT
                )
                    .show( )
            }
        }
    }

}
