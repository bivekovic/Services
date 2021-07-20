package com.algebra.services

import android.app.Service
import android.widget.Toast
import android.os.AsyncTask
import android.util.Log

class BackgroundTask( private val service: Service ) : AsyncTask<Int, Int, String>() {

    override fun doInBackground( vararg params: Int? ): String {
        val taskCount = params[0]

        for (i in 0 until taskCount!!) {
            performLongTask( )
            publishProgress( ( (i + 1) / taskCount.toDouble( ) * 100).toInt( ) )
        }
        return "$taskCount izvrseno"
    }


    override fun onProgressUpdate( vararg percentage: Int? ) {
        val text = "${ percentage[0] } %  izvrseno"
        Toast.makeText( service, text, Toast.LENGTH_SHORT ).show( )
    }

    override fun onPostExecute( finishMessage: String ) {
        Toast.makeText( service, finishMessage, Toast.LENGTH_SHORT ).show( )
        service.stopSelf()
    }

    private fun performLongTask( ) {
        Thread.sleep( 3000 )
    }

}
