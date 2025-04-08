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


class ProfileVm(val firebaseAuth: FirebaseAuth, val firestore : FirebaseFirestore) : ViewModel() {


    private val _getUser = MutableStateFlow<Resource<DataSponsor>>(Resource.Unspecified())
    val getUser : StateFlow<Resource<DataSponsor>> =  _getUser.asStateFlow()

    private val _logout = MutableStateFlow<Resource<String>>(Resource.Unspecified())
    val logout : StateFlow<Resource<String>> =  _logout.asStateFlow()





    fun getUser(id:String){
        firestore.collection("sponsor").whereEqualTo("id",id)
            .get()
            .addOnSuccessListener {
                val data = it.toObjects(DataSponsor::class.java)
                val user = data.first()
                viewModelScope.launch {
                    _getUser.emit(Resource.Success(user))
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _getUser.emit(Resource.Error(it.message.toString()))
                }
            }
    }

    fun logout(){
        viewModelScope.launch {
            _logout.emit(Resource.Loading())
        }
        firebaseAuth.signOut()
        viewModelScope.launch {
            _logout.emit(Resource.Success("DONE"))
        }
    }




}