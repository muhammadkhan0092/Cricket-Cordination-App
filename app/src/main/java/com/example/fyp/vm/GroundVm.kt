package com.example.fyp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fyp.data.DataSponsor
import com.example.fyp.data.User
import com.example.fyp.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class GroundVm(val firebaseAuth: FirebaseAuth, val firestore : FirebaseFirestore) : ViewModel() {


    private val _getUser = MutableStateFlow<Resource<DataSponsor>>(Resource.Unspecified())
    val getUser : StateFlow<Resource<DataSponsor>> =  _getUser.asStateFlow()





    fun getUser(email : String,pass : String){
        firestore.collection("sponsor").whereEqualTo("email",email)
            .get()
            .addOnSuccessListener {
                val data = it.toObjects(DataSponsor::class.java)
                val user = data.first()
                if(data!=null && data.size!=0){
                    if(user.pass==pass){
                        signIn(email,pass,user)
                    }
                    else
                    {
                        viewModelScope.launch {
                            _getUser.emit(Resource.Error("Wrong password"))
                        }
                    }
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _getUser.emit(Resource.Error(it.message.toString()))
                }
            }
    }

    private fun signIn(email: String, pass: String,sponsor: DataSponsor) {
        firebaseAuth.signInWithEmailAndPassword(email,pass)
            .addOnSuccessListener {
                viewModelScope.launch {
                    _getUser.emit(Resource.Success(sponsor))
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _getUser.emit(Resource.Error(it.message.toString()))
                }
            }
    }


}