package com.example.fyp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fyp.data.User
import com.example.fyp.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeVm(val firebaseAuth: FirebaseAuth, val firestore : FirebaseFirestore) : ViewModel() {


    private val _getUser = MutableStateFlow<Resource<List<User>>>(Resource.Unspecified())
    val getUser : StateFlow<Resource<List<User>>> =  _getUser.asStateFlow()





    fun getUsers(){
        viewModelScope.launch {
            _getUser.emit(Resource.Loading())
        }
        firestore.collection("player")
            .get()
            .addOnSuccessListener {
                val data = it.toObjects(User::class.java)
                viewModelScope.launch {
                    _getUser.emit(Resource.Success(data))
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _getUser.emit(Resource.Error(it.message.toString()))
                }
            }
    }




}