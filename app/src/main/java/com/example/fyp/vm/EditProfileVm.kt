package com.example.fyp.vm

import android.app.Activity
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cloudinary.android.MediaManager
import com.cloudinary.android.callback.ErrorInfo
import com.cloudinary.android.callback.UploadCallback
import com.example.fyp.data.DataSponsor
import com.example.fyp.data.User
import com.example.fyp.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class EditProfileVm(val firebaseAuth: FirebaseAuth, val firestore : FirebaseFirestore) : ViewModel() {

    private val _update = MutableStateFlow<Resource<DataSponsor>>(Resource.Unspecified())
    val update : StateFlow<Resource<DataSponsor>> =  _update.asStateFlow()
    fun uploadToCloudinary(filepath: String,onSuccess: (String) -> Unit,onError: (String) -> Unit) {
        MediaManager.get().upload(filepath).callback(object : UploadCallback {
            override fun onSuccess(requestId: String?, resultData: MutableMap<Any?, Any?>?) {
                val downloadUrl = resultData?.get("url") as? String
                if (downloadUrl != null) {
                    onSuccess(downloadUrl)
                    Log.d("Cloudinary", "Download URL: $downloadUrl")
                } else {
                    onError("")
                }
            }

            override fun onProgress(requestId: String?, bytes: Long, totalBytes: Long) {
            }

            override fun onReschedule(requestId: String?, error: ErrorInfo?) {
            }

            override fun onError(requestId: String?, error: ErrorInfo?) {
                onError(error.toString())
            }

            override fun onStart(requestId: String?) {
            }
        }).dispatch()
    }

    fun getRealPathFromUri(imageUri: Uri?, activity: Activity): String? {
        val cursor: Cursor? = activity.contentResolver.query(imageUri!!, null, null, null, null)
        return if (cursor == null) {
            imageUri.path
        } else {
            cursor.moveToFirst()
            val idx: Int = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            cursor.getString(idx)
        }
    }

    fun update(data: DataSponsor) {
        viewModelScope.launch {
            _update.emit(Resource.Loading())
        }
        firestore.collection("sponsor").document(data.id).set(data)
            .addOnSuccessListener {
                viewModelScope.launch {
                    _update.emit(Resource.Success(data))
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _update.emit(Resource.Error(it.message.toString()))
                }
            }
    }


}