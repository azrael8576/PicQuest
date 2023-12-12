package com.wei.picquest.core.pip

import android.app.Activity
import android.app.PictureInPictureParams
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.graphics.Rect
import android.os.Build
import android.util.Rational

fun updatedPipParams(
    context: Context,
    width: Int,
    height: Int,
    rect: Rect,
): PictureInPictureParams? {
    if (!context.packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE) ||
        Build.VERSION.SDK_INT < Build.VERSION_CODES.O
    ) {
        return null
    }

    val aspect = Rational(width, height)
    val paramsBuilder = PictureInPictureParams.Builder()
        .setAspectRatio(aspect)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        paramsBuilder.setSourceRectHint(rect)
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        paramsBuilder.setSeamlessResizeEnabled(true)
    }

    return paramsBuilder.build()
}

@Suppress("DEPRECATION")
fun enterPictureInPicture(
    context: Context,
    params: PictureInPictureParams?,
) {
    params?.let {
        context.findActivity().enterPictureInPictureMode(it)
    } ?: context.findActivity().enterPictureInPictureMode()
}

val Context.isInPictureInPictureMode: Boolean
    get() {
        val currentActivity = findActivity()
        return currentActivity.isInPictureInPictureMode
    }

internal fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("Activity not found. Unknown error.")
}
