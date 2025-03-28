package com.contusfly.activities

import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.databinding.ActivityQrCodeScannerBinding
import com.contusfly.getMessage
import com.contusfly.utils.LogMessage
import com.contusfly.utils.UserInterfaceUtils.Companion.setUpToolBar
import com.google.zxing.BarcodeFormat
import com.mirrorflysdk.api.FlyCore
import com.mirrorflysdk.utils.UpDateWebPassword
import com.mirrorflysdk.views.CustomToast
import com.google.zxing.ResultPoint
import com.google.zxing.client.android.Intents
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DecoratedBarcodeView

class QrCodeScannerActivity : BaseActivity(), BarcodeCallback {

    private lateinit var qrCodeScannerBinding: ActivityQrCodeScannerBinding

    /**
     * The view reference of the BarcodeView object.
     */
    private var barcodeView: DecoratedBarcodeView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        qrCodeScannerBinding = ActivityQrCodeScannerBinding.inflate(layoutInflater)
        setContentView(qrCodeScannerBinding.root)

        val toolbar: Toolbar = qrCodeScannerBinding.toolbar
        setSupportActionBar(toolbar)
        setUpToolBar(this, toolbar, supportActionBar, resources.getString(R.string.scan_code))
        barcodeView = qrCodeScannerBinding.barcodeView
        val tvWebLoginUrl: TextView = qrCodeScannerBinding.tvWebLoginUrl
        tvWebLoginUrl.text = "Visit " + BuildConfig.WEB_CHAT_LOGIN.toString() + " on your computer and scan the QR code"
        val intent = Intent()
        intent.putExtra(Intents.Scan.PROMPT_MESSAGE, "")
        intent.putExtra(Intents.Scan.FORMATS, BarcodeFormat.QR_CODE.toString())  // Restrict to QR codes
        barcodeView!!.initializeFromIntent(intent)
        barcodeView!!.decodeSingle(this)
    }

    private fun qrCodeLogin(qrText: String) {
        FlyCore.loginWebChatViaQRCode(qrText) { isSuccess, throwable, data ->
            if (isSuccess) {
                val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
                if (vibrator.hasVibrator()) {
                    vibrator.vibrate(50)
                }
                finish()
            } else {
                val errorMessage = data.getMessage().ifEmpty {
                    throwable?.localizedMessage ?: getString(R.string.error_occurred_label)
                }
                CustomToast.show(this, errorMessage)
                finish()
            }
        }
    }

    override fun barcodeResult(result: BarcodeResult?) {
        LogMessage.d("#qrlogin","Scanned Successfully")
        qrCodeLogin(result!!.result.text)
    }

    override fun possibleResultPoints(resultPoints: MutableList<ResultPoint>?) {
        //Do nthg
    }

    override fun onResume() {
        super.onResume()
        barcodeView!!.resume()
    }

    override fun onPause() {
        super.onPause()
        barcodeView!!.pauseAndWait()
    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The default implementation simply finishes the current activity,
     * but you can override this to do whatever you want.
     */
    override fun onBackPressed() {
        finish()
    }
}