package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\b\u0010\u0013\u001a\u00020\u000bH\u0014J\u0018\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/contusfly/activities/QrCodeScannerActivity;", "Lcom/contusfly/activities/BaseActivity;", "Lcom/journeyapps/barcodescanner/BarcodeCallback;", "()V", "barcodeView", "Lcom/journeyapps/barcodescanner/DecoratedBarcodeView;", "qrCodeScannerBinding", "Lcom/contusfly/databinding/ActivityQrCodeScannerBinding;", "updateWebPassword", "Lcom/mirrorflysdk/utils/UpDateWebPassword;", "barcodeResult", "", "result", "Lcom/journeyapps/barcodescanner/BarcodeResult;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "possibleResultPoints", "resultPoints", "", "Lcom/google/zxing/ResultPoint;", "app_debug"})
public final class QrCodeScannerActivity extends com.contusfly.activities.BaseActivity implements com.journeyapps.barcodescanner.BarcodeCallback {
    private com.contusfly.databinding.ActivityQrCodeScannerBinding qrCodeScannerBinding;
    
    /**
     * The reference of the UpdatedWebPassword helper object.
     */
    private com.mirrorflysdk.utils.UpDateWebPassword updateWebPassword;
    
    /**
     * The view reference of the BarcodeView object.
     */
    private com.journeyapps.barcodescanner.DecoratedBarcodeView barcodeView;
    private java.util.HashMap _$_findViewCache;
    
    public QrCodeScannerActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void barcodeResult(@org.jetbrains.annotations.Nullable()
    com.journeyapps.barcodescanner.BarcodeResult result) {
    }
    
    @java.lang.Override()
    public void possibleResultPoints(@org.jetbrains.annotations.Nullable()
    java.util.List<com.google.zxing.ResultPoint> resultPoints) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    /**
     * Called when the activity has detected the user's press of the back
     * key. The default implementation simply finishes the current activity,
     * but you can override this to do whatever you want.
     */
    @java.lang.Override()
    public void onBackPressed() {
    }
}